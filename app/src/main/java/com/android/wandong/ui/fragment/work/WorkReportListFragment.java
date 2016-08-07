package com.android.wandong.ui.fragment.work;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.WorkReportListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.RatingBar;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/7/22 09:43
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
public class WorkReportListFragment extends BaseWorkPageFragment<WorkReportListFragment.ItemData,WorkReportListResponseBean> {
    public static final String TAB_TYPE="WORK_REPORT";
    public static final String TAB_NAME="工作报告";

    @Override
    protected ABaseAdapter.AbstractItemView<ItemData> newItemView() {
        return new ListItemView();
    }

    @Override
    protected void populateRequestParams(RefreshMode mode,HttpRequestParams requestParams) {
        requestParams.put("PageNumber",getNextPage(mode));
        requestParams.put("PageCount", getRefreshConfig().minResultSize);
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.WORK_REPORT_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(WorkReportListResponseBean baseResponseBean, List<ItemData> items) {
        if(baseResponseBean.getEntityInfo()!=null){
            for(WorkReportListResponseBean.EntityInfoBean dataItem:baseResponseBean.getEntityInfo()){
                ItemData item=new ItemData();
                item.entityId=dataItem.getEntityId();
                item.new_workplan=dataItem.getNew_workplan();
                item.new_workexperience=dataItem.getNew_workexperience();
                item.new_reporttype=dataItem.getNew_reporttype();
                item.ownerid=dataItem.getOwnerid();
                item.new_headportrait=dataItem.getNew_headportrait();
                item.new_hyphenateid=dataItem.getNew_hyphenateid();
                item.ownername=dataItem.getOwnername();
                item.createdon=dataItem.getCreatedon();
                item.new_commentpersonid=dataItem.getNew_commentpersonid();
                item.new_commentperson=dataItem.getNew_commentperson();
                item.new_commenttime=dataItem.getNew_commenttime();
                item.new_commentcontent=dataItem.getNew_commentcontent();
                item.new_scorelabel=dataItem.getNew_scorelabel();
                item.new_score=dataItem.getNew_score();
                item.new_isrest=dataItem.getNew_isrest();
                item.new_replynumber=dataItem.getNew_replynumber();

                if(dataItem.getNew_worksummary()!=null){
                    for(WorkReportListResponseBean.EntityInfoBean.NewWorksummaryBean bean:dataItem.getNew_worksummary()){
                        NewWorkSummary newWorkSummary=new NewWorkSummary();
                        newWorkSummary.new_customerid=bean.getNew_customerid();
                        newWorkSummary.new_customername=bean.getNew_customername();
                        newWorkSummary.new_workcontent=bean.getNew_workcontent();
                        item.newWorkSummary.add(newWorkSummary);
                    }
                }

                items.add(item);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemData data=getAdapterItems().get((int)id);
        if(!"True".equals(data.new_isrest)){
            WorkReportDetailsFragment.launch(getActivity(),data);
        }
    }

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData>{

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

        @ViewInject(id = R.id.relative_customer)
        protected TextView mViewRelativeCustomer;

        @ViewInject(id = R.id.dailyWorkSummaryTitle)
        protected TextView mViewDailyWorkSummaryTitle;

        @ViewInject(id = R.id.dailyWorkSummary)
        protected TextView mViewDailyWorkSummary;

        @ViewInject(id = R.id.nextDayWorkPlanTitle)
        protected TextView mViewNextDayWorkPlanTitle;

        @ViewInject(id = R.id.nextDayWorkPlan)
        protected TextView mViewNextDayWorkPlan;

        @ViewInject(id = R.id.dailyWorkExperienceTitle)
        protected TextView mViewDailyWorkExperienceTitle;

        @ViewInject(id = R.id.dailyWorkExperience)
        protected TextView mViewDailyWorkExperience;



        @ViewInject(id = R.id.todayRest)
        protected TextView mViewTodayRest;

        @ViewInject(id = R.id.replay_contnet)
        protected View mViewReplayContent;

        @ViewInject(id = R.id.replay)
        protected TextView mViewReplay;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_work_report;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            ImageLoader.getInstance().displayImage(data.new_headportrait, mViewHeadPortrait, Tools.buildDisplayImageOptionsForAvatar());

            Tools.setTextView(mViewName, data.ownername);
            Tools.setTextView(mViewTime, data.createdon);

            if(data.new_score>0){
                mViewReporttype.setVisibility(View.GONE);
                mViewRatingBar.setVisibility(View.VISIBLE);
                mViewRatingBar.setRating(data.new_score);
            }else{
                mViewReporttype.setVisibility(View.VISIBLE);
                Tools.setTextView(mViewReporttype, String.format("%s-未点评",data.new_reporttype));
                mViewRatingBar.setVisibility(View.GONE);
            }

            mViewWeekWorkContent.setVisibility(View.GONE);
            mViewDailyWorkContent.setVisibility(View.GONE);
            mViewTodayRest.setVisibility(View.GONE);
            mViewReplayContent.setVisibility(View.GONE);

            if("True".equals(data.new_isrest)){
                mViewTodayRest.setVisibility(View.VISIBLE);
                mViewReporttype.setVisibility(View.GONE);
                mViewRatingBar.setVisibility(View.GONE);

            }else if("周报".equals(data.new_reporttype)){
                mViewWeekWorkContent.setVisibility(View.VISIBLE);
                mViewReplayContent.setVisibility(View.VISIBLE);
                if(data.newWorkSummary.size()>0){
                    mViewWeekWorkSummaryTitle.setVisibility(View.VISIBLE);
                    mViewWeekWorkSummary.setVisibility(View.VISIBLE);

                    Tools.setTextView(mViewWeekWorkSummary, data.newWorkSummary.get(0).new_workcontent);
                }else{
                    mViewWeekWorkSummaryTitle.setVisibility(View.GONE);
                    mViewWeekWorkSummary.setVisibility(View.GONE);
                }

                if(TextUtils.isEmpty(data.new_workplan)){
                    mViewNextWeekWorkPlanTitle.setVisibility(View.GONE);
                    mViewNextWeekWorkPlan.setVisibility(View.GONE);
                }else{
                    mViewNextWeekWorkPlanTitle.setVisibility(View.VISIBLE);
                    mViewNextWeekWorkPlan.setVisibility(View.VISIBLE);

                    Tools.setTextView(mViewNextWeekWorkPlan, data.new_workplan);
                }

                if(TextUtils.isEmpty(data.new_workexperience)){
                    mViewWorkExperienceTitle.setVisibility(View.GONE);
                    mViewWorkExperience.setVisibility(View.GONE);
                }else{
                    mViewWorkExperienceTitle.setVisibility(View.VISIBLE);
                    mViewWorkExperience.setVisibility(View.VISIBLE);

                    Tools.setTextView(mViewWorkExperience,data.new_workexperience);
                }


                Tools.setTextView(mViewComment, String.format("%s:%s",data.new_commentperson,data.new_commentcontent));
                Tools.setTextView(mViewCommentTime, data.new_commenttime);

                SpannableString spanString = new SpannableString("  点评");
                ForegroundColorSpan span = new ForegroundColorSpan(0xff87BC7F);
                spanString.setSpan(span, 0, spanString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                mViewCommentTime.append(spanString);

            }else if("日报".equals(data.new_reporttype)){
                mViewDailyWorkContent.setVisibility(View.VISIBLE);
                mViewReplayContent.setVisibility(View.VISIBLE);

                if(data.newWorkSummary.size()>0){
                    mViewRelativeCustomer.setVisibility(View.VISIBLE);
                    mViewDailyWorkSummaryTitle.setVisibility(View.VISIBLE);
                    mViewDailyWorkSummary.setVisibility(View.VISIBLE);

                    Tools.setTextView(mViewRelativeCustomer, String.format("关联客户:%s",data.newWorkSummary.get(0).new_customername));
                    Tools.setTextView(mViewDailyWorkSummary, data.newWorkSummary.get(0).new_workcontent);
                }else{
                    mViewRelativeCustomer.setVisibility(View.GONE);
                    mViewDailyWorkSummaryTitle.setVisibility(View.GONE);
                    mViewDailyWorkSummary.setVisibility(View.GONE);
                }
                if(TextUtils.isEmpty(data.new_workplan)){
                    mViewNextDayWorkPlanTitle.setVisibility(View.GONE);
                    mViewNextDayWorkPlan.setVisibility(View.GONE);
                }else{
                    mViewNextDayWorkPlanTitle.setVisibility(View.VISIBLE);
                    mViewNextDayWorkPlan.setVisibility(View.VISIBLE);
                    Tools.setTextView(mViewNextDayWorkPlan, data.new_workplan);
                }

                if(TextUtils.isEmpty(data.new_workexperience)){
                    mViewDailyWorkExperienceTitle.setVisibility(View.GONE);
                    mViewDailyWorkExperience.setVisibility(View.GONE);
                }else{
                    mViewDailyWorkExperienceTitle.setVisibility(View.VISIBLE);
                    mViewDailyWorkExperience.setVisibility(View.VISIBLE);
                    Tools.setTextView(mViewDailyWorkExperience, data.new_workexperience);
                }
            }

            Tools.setTextView(mViewReplay,String.format("共%s条回复",data.new_replynumber));
        }
    }

    public static class ItemData implements Serializable{
        private static final long serialVersionUID = 6732554588714814444L;
        String entityId;
        String new_workplan;
        String new_workexperience;
        String new_reporttype;
        String ownerid;
        String new_headportrait;
        String new_hyphenateid;
        String ownername;
        String createdon;
        String new_commentpersonid;
        String new_commentperson;
        String new_commenttime;
        String new_commentcontent;
        String new_scorelabel;
        int new_score;
        String new_isrest;
        String new_replynumber;

        List<NewWorkSummary> newWorkSummary=new ArrayList<>();
    }

    public static class NewWorkSummary implements Serializable{
        private static final long serialVersionUID = -1318979797552104595L;
        String new_customerid;
        String new_customername;
        String new_workcontent;
    }
}
