package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.beans.WorkReportReplyListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.FixListView;
import com.android.wandong.ui.widget.RatingBar;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.PixelUtils;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;

/**
 * 作者：伍岳 on 2016/7/23 16:34
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
public class WorkReportDetailsFragment extends ABaseFragment {
    private final static String ARG_KEY = "arg_key";


    @ViewInject(id = R.id.headPortrait)
    protected ImageView mViewHeadPortrait;

    @ViewInject(id = R.id.name)
    protected TextView mViewName;

    @ViewInject(id = R.id.time)
    protected TextView mViewTime;

    @ViewInject(id = R.id.reporttype)
    protected TextView mViewReporttype;

    @ViewInject(id = R.id.RatingBar)
    protected RatingBar mViewRatingBar;


    @ViewInject(id = R.id.weekWorkContent)
    protected View mViewWeekWorkContent;

    @ViewInject(id = R.id.weekWorkSummaryTitle)
    protected TextView mViewWeekWorkSummaryTitle;

    @ViewInject(id = R.id.weekWorkSummary)
    protected TextView mViewWeekWorkSummary;

    @ViewInject(id = R.id.nextWeekWorkPlanTitle)
    protected TextView mViewNextWeekWorkPlanTitle;

    @ViewInject(id = R.id.nextWeekWorkPlan)
    protected TextView mViewNextWeekWorkPlan;

    @ViewInject(id = R.id.workExperienceTitle)
    protected TextView mViewWorkExperienceTitle;

    @ViewInject(id = R.id.workExperience)
    protected TextView mViewWorkExperience;

    @ViewInject(id = R.id.comment)
    protected TextView mViewComment;

    @ViewInject(id = R.id.comment_time)
    protected TextView mViewCommentTime;



    @ViewInject(id = R.id.dailyWorkContent)
    protected View mViewDailyWorkContent;

    @ViewInject(id = R.id.relativeCustomer_dailyWorkSummary)
    protected LinearLayout mViewContentRelativeCustomerDailyWorkSummary;

    @ViewInject(id = R.id.nextDayWorkPlanTitle)
    protected TextView mViewNextDayWorkPlanTitle;

    @ViewInject(id = R.id.nextDayWorkPlan)
    protected TextView mViewNextDayWorkPlan;

    @ViewInject(id = R.id.dailyWorkExperienceTitle)
    protected TextView mViewDailyWorkExperienceTitle;

    @ViewInject(id = R.id.dailyWorkExperience)
    protected TextView mViewDailyWorkExperience;



    @ViewInject(id = R.id.comments_list)
    protected FixListView mListViewComments;

    @ViewInject(id = R.id.command_or_replay)
    protected TextView mViewReplyCount;

    @ViewInject(id = R.id.click_to_input, click = "OnClick")
    protected EditText mViewClickToInput;

    @ViewInject(id = R.id.send)
    protected TextView mViewSendBtn;

    //Data
    private WorkReportListFragment.ItemData mReportData;

    private String mCommentsContent="";

    private LayoutInflater mInflater;

    public static void launch(Activity activity, WorkReportListFragment.ItemData data) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, data);
        FragmentContainerActivity.launch(activity, WorkReportDetailsFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReportData = savedInstanceState == null ? (WorkReportListFragment.ItemData) getArguments().getSerializable(ARG_KEY) : (WorkReportListFragment.ItemData) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mReportData);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mInflater=inflater;
        getActivity().setTitle("工作报告详情");
        populateReplyViews();
        
        refreshSendBtnEnable(mViewSendBtn, false);
        mViewClickToInput.addTextChangedListener(mReplyTextWatcher);
        mViewSendBtn.setOnClickListener(mOnSendClickListener);
    }

    @Override
    public void onCreateCustomActionMenu(LinearLayout menuContent, Activity activity) {
        /*ImageView btnCalendar = new ImageView(activity);
        btnCalendar.setMinimumWidth(PixelUtils.dp2px(40));
        btnCalendar.setMinimumHeight(PixelUtils.dp2px(40));
        btnCalendar.setImageResource(R.drawable.icon_calendar);
        btnCalendar.setBackgroundResource(R.drawable.default_bg);
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkReportCalendarFragment.launch(getActivity());
            }
        });

        menuContent.addView(btnCalendar);*/
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_report_details;
    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("entityId", mReportData.entityId);

        startFormRequest(ApiUrls.WORK_REPORT_GET_REPLY_USERS_LIST, requestParams, new BaseHttpRequestTask<WorkReportReplyListResponseBean>() {
            @Override
            public WorkReportReplyListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, WorkReportReplyListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(WorkReportReplyListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(WorkReportReplyListResponseBean result) {
                super.onSuccess(result);
                ArrayList<Comments> dataList = new ArrayList<>();
                if (result != null && result.getEntityInfo() != null && result.getEntityInfo().getReplylist() != null) {
                    for (WorkReportReplyListResponseBean.EntityInfoBean.ReplylistBean bean : result.getEntityInfo().getReplylist()) {
                        Comments comments = new Comments();
                        comments.new_headportrait = bean.getNew_headportrait();
                        comments.new_name = bean.getNew_name();
                        comments.new_replycontent = bean.getNew_replycontent();
                        dataList.add(comments);
                    }
                }

                mViewReplyCount.setText(String.format("回复 (%d)",dataList.size()));

                mListViewComments.setAdapter(new CommentsAdapter(dataList, getActivity()));

            }
        }, HttpRequestUtils.RequestType.POST);
    }

    private void sendReplyRequest(){
        if(isRequestProcessing(ApiUrls.WORK_REPORT_SEND_REPLY_CONTENT)){
            return;
        }

        HttpRequestParams requestParams=Tools.createHttpRequestParams();
        requestParams.put("entityId",mReportData.entityId);
        requestParams.put("replycontent",mCommentsContent);
        showRotateProgressDialog("正在发送",true);
        startFormRequest(ApiUrls.WORK_REPORT_SEND_REPLY_CONTENT, requestParams, new HttpRequestHandler(this) {
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                closeRotateProgressDialog();
                switch (resultCode) {
                    case success:
                        BaseResponseBean responseBean = Tools.parseJsonTostError(result, BaseResponseBean.class);
                        if (responseBean != null) {

                            if(mReplyDialog!=null&&mReplyDialog.isShowing()){
                                mReplyDialog.dismiss();
                            }
                            mCommentsContent="";
                            mViewClickToInput.setText(mCommentsContent);

                            ToastUtils.toast("回复成功！");
                            requestData();
                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                        break;
                }
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    private Dialog mReplyDialog;
    private EditText mDialogCommentsContent;
    private TextView mDialogSendBtn;

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.click_to_input:
                mReplyDialog = Tools.showDialogFromBottom(getActivity(), R.layout.dialog_work_report_comments_input, true);
                mDialogCommentsContent = (EditText) mReplyDialog.findViewById(R.id.comments_content);
                mDialogCommentsContent.setText(mCommentsContent);
                mDialogCommentsContent.addTextChangedListener(mReplyTextWatcher);

                mDialogSendBtn = (TextView) mReplyDialog.findViewById(R.id.send);
                mDialogSendBtn.setOnClickListener(mOnSendClickListener);
                refreshSendBtnEnable(mDialogSendBtn, mCommentsContent.length() >0);

                mDialogCommentsContent.requestFocus();
                mReplyDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        mViewClickToInput.setText(mCommentsContent);
                    }
                });
                break;
        }
    }

    private View.OnClickListener mOnSendClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            sendReplyRequest();
        }
    };


    private TextWatcher mReplyTextWatcher=new TextWatcher(){
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(mReplyDialog!=null&&mReplyDialog.isShowing()){
                mCommentsContent = mDialogCommentsContent.getText().toString();
                refreshSendBtnEnable(mDialogSendBtn, mCommentsContent.length() >0);
            }
            refreshSendBtnEnable(mViewSendBtn,mCommentsContent.length()>0);
        }
    };

    private void refreshSendBtnEnable(TextView sendBtn,boolean enable){
        sendBtn.setEnabled(enable);
        if(enable){
            sendBtn.setTextColor(0xffF15353);
        }else{
            sendBtn.setTextColor(0xff9390A5);
        }
    }


    private class Comments {
        String new_replycontent;
        String new_headportrait;
        String new_name;
    }

    private void populateReplyViews(){
        ImageLoader.getInstance().displayImage(mReportData.new_headportrait, mViewHeadPortrait, Tools.buildDisplayImageOptionsForAvatar());

        Tools.setTextView(mViewName, mReportData.ownername);
        Tools.setTextView(mViewTime, mReportData.createdon);

        if(mReportData.new_score>0){
            mViewReporttype.setVisibility(View.GONE);
            mViewRatingBar.setVisibility(View.VISIBLE);
            mViewRatingBar.setRating(mReportData.new_score);
        }else{
            mViewReporttype.setVisibility(View.VISIBLE);
            Tools.setTextView(mViewReporttype, String.format("%s-未点评",mReportData.new_reporttype));
            mViewRatingBar.setVisibility(View.GONE);
        }

        mViewWeekWorkContent.setVisibility(View.GONE);
        mViewDailyWorkContent.setVisibility(View.GONE);

         if("周报".equals(mReportData.new_reporttype)){
            mViewWeekWorkContent.setVisibility(View.VISIBLE);
            if(mReportData.newWorkSummary.size()>0){
                mViewWeekWorkSummaryTitle.setVisibility(View.VISIBLE);
                mViewWeekWorkSummary.setVisibility(View.VISIBLE);

                Tools.setTextView(mViewWeekWorkSummary, mReportData.newWorkSummary.get(0).new_workcontent);
            }else{
                mViewWeekWorkSummaryTitle.setVisibility(View.GONE);
                mViewWeekWorkSummary.setVisibility(View.GONE);
            }

            if(TextUtils.isEmpty(mReportData.new_workplan)){
                mViewNextWeekWorkPlanTitle.setVisibility(View.GONE);
                mViewNextWeekWorkPlan.setVisibility(View.GONE);
            }else{
                mViewNextWeekWorkPlanTitle.setVisibility(View.VISIBLE);
                mViewNextWeekWorkPlan.setVisibility(View.VISIBLE);

                Tools.setTextView(mViewNextWeekWorkPlan, mReportData.new_workplan);
            }

            if(TextUtils.isEmpty(mReportData.new_workexperience)){
                mViewWorkExperienceTitle.setVisibility(View.GONE);
                mViewWorkExperience.setVisibility(View.GONE);
            }else{
                mViewWorkExperienceTitle.setVisibility(View.VISIBLE);
                mViewWorkExperience.setVisibility(View.VISIBLE);

                Tools.setTextView(mViewWorkExperience,mReportData.new_workexperience);
            }


            Tools.setTextView(mViewComment, String.format("%s:%s",mReportData.new_commentperson,mReportData.new_commentcontent));
            Tools.setTextView(mViewCommentTime, mReportData.new_commenttime);

            SpannableString spanString = new SpannableString("  点评");
            ForegroundColorSpan span = new ForegroundColorSpan(0xff87BC7F);
            spanString.setSpan(span, 0, spanString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mViewCommentTime.append(spanString);

        }else if("日报".equals(mReportData.new_reporttype)){
            mViewDailyWorkContent.setVisibility(View.VISIBLE);
             mViewContentRelativeCustomerDailyWorkSummary.removeAllViews();
             if(mReportData.newWorkSummary.size()>0){
                 for(WorkReportListFragment.NewWorkSummary summary:mReportData.newWorkSummary){
                     View view= mInflater.inflate(R.layout.item_work_report_relative_cus_daily_summary,mViewContentRelativeCustomerDailyWorkSummary,true);
                     TextView viewRelativeCustomer= (TextView)view.findViewById(R.id.relative_customer);
                     TextView viewDailyWorkSummary= (TextView)view.findViewById(R.id.dailyWorkSummary);
                     Tools.setTextView(viewRelativeCustomer, String.format("关联客户:%s",summary.new_customername));
                     Tools.setTextView(viewDailyWorkSummary, summary.new_workcontent);
                 }
             }
            if(TextUtils.isEmpty(mReportData.new_workplan)){
                mViewNextDayWorkPlanTitle.setVisibility(View.GONE);
                mViewNextDayWorkPlan.setVisibility(View.GONE);
            }else{
                mViewNextDayWorkPlanTitle.setVisibility(View.VISIBLE);
                mViewNextDayWorkPlan.setVisibility(View.VISIBLE);
                Tools.setTextView(mViewNextDayWorkPlan, mReportData.new_workplan);
            }

            if(TextUtils.isEmpty(mReportData.new_workexperience)){
                mViewDailyWorkExperienceTitle.setVisibility(View.GONE);
                mViewDailyWorkExperience.setVisibility(View.GONE);
            }else{
                mViewDailyWorkExperienceTitle.setVisibility(View.VISIBLE);
                mViewDailyWorkExperience.setVisibility(View.VISIBLE);
                Tools.setTextView(mViewDailyWorkExperience, mReportData.new_workexperience);
            }
        }
    }

    private class CommentsAdapter extends ABaseAdapter<Comments> {

        public CommentsAdapter(ArrayList<Comments> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<Comments> newItemView() {
            return new CommentsItemView();
        }
    }

    private class CommentsItemView extends ABaseAdapter.AbstractItemView<Comments> {
        @ViewInject(id = R.id.headPortrait)
        protected ImageView mViewHeadPortrait;

        @ViewInject(id = R.id.name)
        protected TextView mViewName;

        @ViewInject(id = R.id.description)
        protected TextView mViewDescription;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_work_report_details_comments;
        }

        @Override
        public void bindingData(View convertView, Comments data) {
            ImageLoader.getInstance().displayImage(data.new_headportrait, mViewHeadPortrait, Tools.buildDisplayImageOptionsForAvatar());
            Tools.setTextView(mViewName, data.new_name);
            Tools.setTextView(mViewDescription, data.new_replycontent);
        }
    }
}
