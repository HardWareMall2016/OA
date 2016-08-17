package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.FixGridView;
import com.android.wandong.utils.Tools;
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
public class WorkReportCreateWeekly extends ABaseFragment{

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
    }

    public class PeopleInfo{

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
        @ViewInject(id = R.id.attachment)
        ImageView mViewAttachment;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_attached_people;
        }

        @Override
        public void bindingData(View convertView, PeopleInfo data) {
            if(getPosition()==getSize()-1){
                //ImageLoader.getInstance().displayImage("drawable://" + R.drawable.icon_sign_in_add_photo, mViewAttachment, Tools.buildDefDisplayImgOptions());
            } else {
                //ImageLoader.getInstance().displayImage("file://"+data, mViewAttachment, Tools.buildDefDisplayImgOptions());
            }
        }
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                createWeeklyReportRequest();
                break;
        }
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
        //requestParams.put("UserList[][hyphenateid]", "Dddddddd");
        //requestParams.put("UserList[][userid]", "Dddddddd");

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
