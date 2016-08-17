package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
public class WorkReportCreateDaily extends ABaseFragment {
    private static final int REQUEST_CODE_CUSTOMER = 100;

    @ViewInject(id = R.id.people)
    protected FixGridView mFixGridView;

    private ArrayList<PeopleInfo> mPeopleList = new ArrayList<>();

    private PeopleAdapter mAdapter;

    @ViewInject(id = R.id.layout_relative_customer_and_today_summary)
    protected LinearLayout mLayoutHeader;

    //默认的关联客户和工作总结项
    @ViewInject(id = R.id.def_item)
    protected View mLayoutDefItem;

    @ViewInject(id = R.id.btn_submit, click = "OnClick")
    View mViewSubmit;

    @ViewInject(id = R.id.tomorrow_work_plan)
    protected EditText mEtWorkPlan;

    @ViewInject(id = R.id.workExperience)
    protected EditText mEtWorkExperience;

    private LayoutInflater mInflate;

    private ViewHolder mCurrentViewHolder;

    public static void launch(Activity activity){
        /*FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, productId);*/
        FragmentContainerActivity.launch(activity, WorkReportCreateDaily.class, null);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_create_daily;
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("写日报");

        mInflate=inflater;

        mPeopleList.clear();
        mPeopleList.add(new PeopleInfo());
        mAdapter = new PeopleAdapter(mPeopleList,getActivity());
        mFixGridView.setAdapter(mAdapter);

        setViewHolder(mLayoutDefItem, true);
    }

    public class PeopleInfo{

    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                createDailyReportRequest();
                break;
        }
    }

    private void createDailyReportRequest(){
        if (isRequestProcessing(ApiUrls.WORKREPORT_SENDREPORT)) {
            return;
        }

        List<WorkSummaryItem>  workSummaryItems=new ArrayList<>();
        for(int i=0;i<mLayoutHeader.getChildCount();i++){
            ViewHolder viewHolder= (ViewHolder)mLayoutHeader.getChildAt(i).getTag();

            if(TextUtils.isEmpty(viewHolder.relativeCusId)){
                ToastUtils.toast("请选择关联用户");
                return;
            }
            if(TextUtils.isEmpty(viewHolder.todayWorkSummary.getText().toString())){
                ToastUtils.toast("请填写今日工作总结");
                return;
            }

            WorkSummaryItem item=new WorkSummaryItem();
            item.setAccountid(viewHolder.relativeCusId);
            item.setContent(viewHolder.todayWorkSummary.getText().toString());

            workSummaryItems.add(item);
        }

        String workPlan=mEtWorkPlan.getText().toString();
        if(TextUtils.isEmpty(workPlan)){
            ToastUtils.toast("请填写明日工作计划");
            return;
        }
        String workExperience=mEtWorkExperience.getText().toString();
        if(TextUtils.isEmpty(workExperience)){
            ToastUtils.toast("请填写工作心得体会");
            return;
        }

        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("reporttype", 1);//日报
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

    private class ViewHolder{
        boolean isDefItem;
        String relativeCusName;
        String relativeCusId;

        View itemView;
        TextView relativeCustomerTitle;
        TextView relativeCustomerValue;
        EditText todayWorkSummary;
    }

    private void setViewHolder(View itemView,boolean isDefItem){
        ViewHolder viewHolder=new ViewHolder();
        viewHolder.isDefItem=isDefItem;
        viewHolder.itemView=itemView;
        viewHolder.relativeCustomerTitle=(TextView)itemView.findViewById(R.id.relative_customer_title);
        viewHolder.relativeCustomerTitle.setOnClickListener(mOnRelativeCustomerClickListener);
        viewHolder.relativeCustomerTitle.setTag(viewHolder);
        if(isDefItem){
            viewHolder.relativeCustomerTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_add_small, 0, 0, 0);
        }else{
            viewHolder.relativeCustomerTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_delete_small,0,0,0);
        }

        viewHolder.relativeCustomerValue=(TextView)itemView.findViewById(R.id.relative_customer_value);
        viewHolder.relativeCustomerValue.setOnClickListener(mOnRelativeCustomerClickListener);
        viewHolder.relativeCustomerValue.setTag(viewHolder);

        viewHolder.todayWorkSummary=(EditText)itemView.findViewById(R.id.today_work_summary);

        itemView.setTag(viewHolder);
    }

    private View.OnClickListener mOnRelativeCustomerClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            ViewHolder viewHolder=(ViewHolder)v.getTag();
            switch (v.getId()){
                case R.id.relative_customer_title:
                    if(viewHolder.isDefItem){
                        View itemView=mInflate.inflate(R.layout.item_create_daily_report_header,null);
                        setViewHolder(itemView,false);
                        mLayoutHeader.addView(itemView,0);
                    }else{
                        mLayoutHeader.removeView(viewHolder.itemView);
                    }
                    break;
                case R.id.relative_customer_value:
                    mCurrentViewHolder=viewHolder;
                    AccountListFragment.launchForResult(WorkReportCreateDaily.this, REQUEST_CODE_CUSTOMER);
                    break;
            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CUSTOMER && resultCode == Activity.RESULT_OK) {
            if(mCurrentViewHolder!=null){
                mCurrentViewHolder.relativeCusId=data.getStringExtra(AccountListFragment.KEY_ACCOUNT_ID);
                mCurrentViewHolder.relativeCusName=data.getStringExtra(AccountListFragment.KEY_ACCOUNT_NAME);

                mCurrentViewHolder.relativeCustomerValue.setText(mCurrentViewHolder.relativeCusName);
                mCurrentViewHolder.relativeCustomerValue.setTextColor(0xff333333);
            }
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
