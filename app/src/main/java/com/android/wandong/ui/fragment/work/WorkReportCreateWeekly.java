package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.beans.ConvertUserListResponseBean;
import com.android.wandong.model.work.PeopleInfo;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.FixGridView;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/8/14 16:22
 * 邮箱：wuyue8512@163.com
 * //
 * //         .............................................
 * //                  美女坐镇                  BUG辟易
 * //         .............................................
 * //
 * //                       .::::.
 * //                     .::::::::.
 * //                    :::::::::::
 * //                 ..:::::::::::'
 * //              '::::::::::::'
 * //                .::::::::::
 * //           '::::::::::::::..
 * //                ..::::::::::::.
 * //              ``::::::::::::::::
 * //               ::::``:::::::::'        .:::.
 * //              ::::'   ':::::'       .::::::::.
 * //            .::::'      ::::     .:::::::'::::.
 * //           .:::'       :::::  .:::::::::' ':::::.
 * //          .::'        :::::.:::::::::'      ':::::.
 * //         .::'         ::::::::::::::'         ``::::.
 * //     ...:::           ::::::::::::'              ``::.
 * //    ```` ':.          ':::::::::'                  ::::..
 * //                       '.:::::'                    ':'````..
 * //
 */
public class WorkReportCreateWeekly extends ABaseFragment implements AdapterView.OnItemClickListener {

    private final static int REQUEST_CODE_PEOPLE = 101;

    @ViewInject(id = R.id.people)
    protected FixGridView mFixGridView;

    @ViewInject(id = R.id.today_work_summary)
    protected EditText mEtWorkSummary;

    @ViewInject(id = R.id.tomorrow_work_plan)
    protected EditText mEtWorkPlan;

    @ViewInject(id = R.id.workExperience)
    protected EditText mEtWorkExperience;

    @ViewInject(id = R.id.btn_submit, click = "OnClick")
    View mViewSubmit;

    @ViewInject(id = R.id.selectedPeople, click = "OnClick")
    TextView mViewSelectedPeople;

    private ArrayList<PeopleInfo> mPeopleList = new ArrayList<>();

    private PeopleAdapter mAdapter;

    public static void launch(Activity activity){
        /*FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, productId);*/
        FragmentContainerActivity.launch(activity, WorkReportCreateWeekly.class, null);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_create_weekly;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("写周报");

        mPeopleList.clear();
        mPeopleList.add(new PeopleInfo());
        mAdapter = new PeopleAdapter(mPeopleList,getActivity());
        mFixGridView.setAdapter(mAdapter);
        mFixGridView.setOnItemClickListener(this);
        mViewSelectedPeople.setText(String.format("已选择%d人", mPeopleList.size() - 1));
    }

    private class PeopleAdapter extends ABaseAdapter<PeopleInfo> {
        public PeopleAdapter(ArrayList<PeopleInfo> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<PeopleInfo> newItemView() {
            return new PeopleItemView();
        }
    }

    private class PeopleItemView extends ABaseAdapter.AbstractItemView<PeopleInfo> {
        @ViewInject(id = R.id.photo)
        ImageView mViewPhoto;

        @ViewInject(id = R.id.name)
        TextView mViewName;

        @ViewInject(id = R.id.remove_btn)
        ImageView mViewRemoveBtn;

        @ViewInject(id = R.id.add_btn)
        ImageView mViewAddBtn;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_attached_people;
        }

        @Override
        public void bindingData(View convertView, PeopleInfo data) {
            if(getPosition()==getSize()-1){
                mViewAddBtn.setVisibility(View.VISIBLE);
                mViewPhoto.setVisibility(View.GONE);
                mViewName.setVisibility(View.GONE);
                mViewRemoveBtn.setVisibility(View.GONE);
            } else {
                mViewPhoto.setVisibility(View.VISIBLE);
                mViewName.setVisibility(View.VISIBLE);
                mViewRemoveBtn.setVisibility(View.VISIBLE);
                mViewAddBtn.setVisibility(View.GONE);

                mViewRemoveBtn.setTag(data);
                mViewRemoveBtn.setOnClickListener(mOnRemovePeopleClickListener);

                mViewName.setText(data.userName);
                ImageLoader.getInstance().displayImage(data.headportrait, mViewPhoto, Tools.buildDisplayImageOptionsForAvatar());
            }
        }
    }

    private View.OnClickListener mOnRemovePeopleClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            PeopleInfo data=(PeopleInfo)v.getTag();
            mPeopleList.remove(data);
            mAdapter.notifyDataSetChanged();

            mViewSelectedPeople.setText(String.format("已选择%d人",mPeopleList.size()-1));
        }
    };

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                createWeeklyReportRequest();
                break;
            case R.id.selectedPeople:
                AnnouncementCreateObjectFragment.launchForResult(this, REQUEST_CODE_PEOPLE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PEOPLE && resultCode == Activity.RESULT_OK) {
            AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo = (AnnouncementCreateObjectFragment.AnnounceObjectInfo) data.getSerializableExtra(AnnouncementCreateObjectFragment.EXT_DATA_KEY);
            requestAnnouncementCreateObject(selectInfo);
        }
    }


    private void requestAnnouncementCreateObject(AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo) {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        String roles = "";
        for (String item : selectInfo.roles) {
            if (TextUtils.isEmpty(roles)) {
                roles = item;
            } else {
                roles += "," + item;
            }
        }
        String departs = "";
        for (String item : selectInfo.departs) {
            if (TextUtils.isEmpty(departs)) {
                departs = item;
            } else {
                departs += "," + item;
            }
        }
        String user = "";
        for (String item : selectInfo.users) {
            if (TextUtils.isEmpty(user)) {
                user = item;
            } else {
                user += "," + item;
            }
        }
        requestParams.put("roles", roles);
        requestParams.put("departs", departs);
        requestParams.put("users", user);
        startFormRequest(ApiUrls.CONTACTS_CONVERT_USERLIST, requestParams, new HttpRequestHandler(this) {
            @Override
            public void onPrepare() {
                showRotateProgressDialog("正在获取中...",false);
            }

            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                closeRotateProgressDialog();
                switch (resultCode) {
                    case success:
                        ConvertUserListResponseBean responseBean = Tools.parseJsonTostError(result, ConvertUserListResponseBean.class);
                        if (responseBean != null&&responseBean.getEntityInfo()!=null) {
                            for(ConvertUserListResponseBean.EntityInfoBean bean:responseBean.getEntityInfo()){
                                PeopleInfo peopleInfo=new PeopleInfo();
                                peopleInfo.userId=bean.getSystemUserId();
                                peopleInfo.userName=bean.getFullname();
                                peopleInfo.headportrait=bean.getNewHeadportrait();
                                peopleInfo.hyphenateid=bean.getNewHyphenateid();

                                if(bean.getSystemUserId()==null){
                                    continue;
                                }

                                boolean exists=false;
                                for(PeopleInfo item:mPeopleList){
                                    if(peopleInfo.userId.equals(item.userId)){
                                        exists=true;
                                        break;
                                    }
                                }
                                if(!exists){
                                    mPeopleList.add(0,peopleInfo);
                                }
                            }
                            mAdapter.notifyDataSetChanged();
                            mViewSelectedPeople.setText(String.format("已选择%d人", mPeopleList.size() - 1));
                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                        break;
                }
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    private void createWeeklyReportRequest(){
        if (isRequestProcessing(ApiUrls.WORKREPORT_SENDREPORT)) {
            return;
        }

        List<WorkSummaryItem> workSummaryItems = new ArrayList<>();

        if (TextUtils.isEmpty(mEtWorkSummary.getText().toString())) {
            ToastUtils.toast("请填写本周工作总结");
            return;
        }

        WorkSummaryItem item = new WorkSummaryItem();
        item.setAccountid("6702278A-C215-E611-AC23-085700E64E0F");
        item.setContent(mEtWorkSummary.getText().toString());

        workSummaryItems.add(item);


        String workPlan=mEtWorkPlan.getText().toString();
        if(TextUtils.isEmpty(workPlan)){
            ToastUtils.toast("请填写下周工作计划");
            return;
        }
        String workExperience=mEtWorkExperience.getText().toString();
        if(TextUtils.isEmpty(workExperience)){
            ToastUtils.toast("请填写工作心得体会");
            return;
        }

        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("reporttype", 2);//周报
        requestParams.put("workPlan", workPlan);
        requestParams.put("workexperience", workExperience);
        requestParams.put("worksummary", JSON.toJSONString(workSummaryItems));
        //数组 重复填写
        //requestParams.put("UserList[][hyphenateId]", "Dddddddd");
        //requestParams.put("UserList[][userid]", "Dddddddd");
        //数组 重复填写
        if(mPeopleList.size()>1){
            for(int i=0;i<mPeopleList.size()-1;i++){
                requestParams.put("UserList["+i+"][hyphenateId]", mPeopleList.get(i).hyphenateid);
                requestParams.put("UserList["+i+"][userid]", mPeopleList.get(i).userId);
            }
        }

        startFormRequest(ApiUrls.WORKREPORT_SENDREPORT, requestParams, new HttpRequestHandler(this) {
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                switch (resultCode) {
                    case success:
                        BaseResponseBean responseBean = Tools.parseJsonTostError(result, BaseResponseBean.class);
                        if (responseBean != null) {
                            ToastUtils.toast("提交成功！");
                            getActivity().finish();
                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                        break;
                }
            }
        }, HttpRequestUtils.RequestType.POST);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==mPeopleList.size()-1){
            AnnouncementCreateObjectFragment.launchForResult(this, REQUEST_CODE_PEOPLE);
        }
    }

    private class WorkSummaryItem{
        private String content;
        private String accountid;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAccountid() {
            return accountid;
        }

        public void setAccountid(String accountid) {
            this.accountid = accountid;
        }
    }
}
