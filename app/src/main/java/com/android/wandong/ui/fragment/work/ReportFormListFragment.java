package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.NoticeResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.CircleView;
import com.android.wandong.ui.widget.RoundProgressBar;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.utils.PixelUtils;

import java.util.List;

/**
 * 作者：伍岳 on 2016/7/22 15:26
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
//报表
public class ReportFormListFragment extends BaseWorkPageFragment<ReportFormListFragment.ItemData, NoticeResponseBean> {
    public static final String TAB_TYPE = "REPORT_LIST";
    public static final String TAB_NAME = "报表";

    //报表类型：工作报告，外勤签到，报销
    private enum ReportType{WORK_REPORT,OUTDOOR_SIGN,REIMBURSEMENT}


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mViewContentSearch.setVisibility(View.GONE);
    }

    @Override
    protected void setInitPullToRefresh(ListView listView, PullToRefreshListView pullToRefreshListView, Bundle savedInstanceState) {
        super.setInitPullToRefresh(listView, pullToRefreshListView, savedInstanceState);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        listView.setDividerHeight(PixelUtils.dp2px(16));
    }

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex", getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("new_kind", 1);//类别（1为公告、2为通知）
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.NOTICE_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(NoticeResponseBean baseResponseBean, List<ItemData> items) {
        if (baseResponseBean.getEntityInfo() != null) {
            /*for (NoticeResponseBean.EntityInfoBean dataItem : baseResponseBean.getEntityInfo()) {
                ItemData item = new ItemData();
                items.add(item);
            }*/

            ItemData item = new ItemData();
            item.reportType=ReportType.WORK_REPORT;
            item.typeName = "工作报告";
            item.unreachedColor = 0xffFEBF8C;
            item.reachedTitle = "已点评报告 : ";
            item.reachedColor = 0xffFF801A;
            item.unreachedTitle = "未点评报告 : ";
            item.unreachedNun = 5;
            item.reachedNum = 6;
            item.progress = 70;
            item.totalNum = 11;
            item.totalTitle = "工作报告总数";
            items.add(item);

            item = new ItemData();
            item.reportType=ReportType.OUTDOOR_SIGN;
            item.typeName = "外勤签到";
            item.unreachedColor = 0xffB6D8A3;
            item.reachedTitle = "已签到 : ";
            item.reachedColor = 0xff6DB247;
            item.unreachedTitle = "未签到 : ";
            item.unreachedNun = 6;
            item.reachedNum = 6;
            item.progress = 50;
            item.totalNum = 12;
            item.totalTitle = "外勤签到总数";
            items.add(item);

            item = new ItemData();
            item.reportType=ReportType.REIMBURSEMENT;
            item.typeName = "工作报告";
            item.unreachedColor = 0xffFED889;
            item.reachedTitle = "报销已批准 : ";
            item.reachedColor = 0xffFFB200;
            item.unreachedTitle = "报销未批准 : ";
            item.unreachedNun = 5;
            item.reachedNum = 6;
            item.progress = 30;
            item.totalNum = 11;
            item.totalTitle = "费用报销总数";
            items.add(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemData data=getAdapterItems().get((int) id);
        switch (data.reportType){
            case WORK_REPORT:
                ReportFormWorkReportFragment.launch(getActivity(), "");
                break;
            case OUTDOOR_SIGN:
                ReportFormOutdoorSignFragment.launch(getActivity(), "");
                break;
            case REIMBURSEMENT:
                ReportFormReimbursement.launch(getActivity());
                break;
        }
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ItemData> newItemView() {
        return new ListItemView();
    }


    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData> {

        @ViewInject(id = R.id.report_type)
        protected TextView mViewReportType;

        @ViewInject(id = R.id.indicator_un_reached)
        protected CircleView mCircleViewUnreachedIndicator;

        @ViewInject(id = R.id.un_reached_title)
        protected TextView mViewUnreachedTitle;

        @ViewInject(id = R.id.indicator_reached)
        protected CircleView mCircleViewReachedIndicator;

        @ViewInject(id = R.id.reached_title)
        protected TextView mViewReachedTitle;

        @ViewInject(id = R.id.roundProgressBar)
        protected RoundProgressBar mRoundProgressBar;

        @ViewInject(id = R.id.total)
        protected TextView mViewTotal;

        @ViewInject(id = R.id.total_title)
        protected TextView mViewTotalTitle;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_report;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            Tools.setTextView(mViewReportType, data.typeName);

            mCircleViewUnreachedIndicator.setDrawColor(data.unreachedColor);
            Tools.setTextView(mViewUnreachedTitle, data.unreachedTitle);
            String unreachedNum=" "+String.valueOf(data.unreachedNun);
            SpannableString spannableString=new SpannableString(unreachedNum);
            spannableString.setSpan(new ForegroundColorSpan(data.unreachedColor), 0, unreachedNum.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new RelativeSizeSpan(1.5f), 0, unreachedNum.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //2.0f表示默认字体大小的两倍
            mViewUnreachedTitle.append(spannableString);

            mCircleViewReachedIndicator.setDrawColor(data.reachedColor);
            Tools.setTextView(mViewReachedTitle, data.reachedTitle);
            String reachedNum= " "+String.valueOf(data.reachedNum);
            spannableString = new SpannableString(reachedNum);
            spannableString.setSpan(new ForegroundColorSpan(data.reachedColor), 0, reachedNum.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new RelativeSizeSpan(1.5f), 0, unreachedNum.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //2.0f表示默认字体大小的两倍
            mViewReachedTitle.append(spannableString);

            mRoundProgressBar.setReachedBarColor(data.reachedColor);
            mRoundProgressBar.setUnreachedBarColor(data.unreachedColor);
            mRoundProgressBar.setProgress(data.progress);
            Tools.setTextView(mViewTotal, String.valueOf(data.totalNum));
            Tools.setTextView(mViewTotalTitle, data.totalTitle);

            mViewTotal.setTextColor(data.reachedColor);
        }
    }


    public class ItemData {
        ReportType reportType;
        String typeName;
        int unreachedColor;
        String reachedTitle;
        int reachedColor;
        String unreachedTitle;
        int unreachedNun;
        int reachedNum;
        int progress;
        int totalNum;
        String totalTitle;
    }
}
