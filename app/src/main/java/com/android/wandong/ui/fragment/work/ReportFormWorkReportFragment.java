package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.common.ABaseTabFragment;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.utils.PixelUtils;

import java.util.ArrayList;
import java.util.List;

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
public class ReportFormWorkReportFragment extends ABaseTabFragment<ReportFormWorkReportFragment.ReportDataItem> {
    private final static String ARG_KEY = "arg_key";

    //Tab code
    private final static int TYPE_DAILY_REPORT = 100;
    private final static int TYPE_WEEKLY_REPORT = 200;

    //Item type
    private final static int ITEM_TYPE_DAILY_REPORT = 0;
    private final static int ITEM_TYPE_WEEKLY_REPORT = 1;

    @ViewInject(id = R.id.daily_report_header)
    protected View mDailyReportHeader;

    @ViewInject(id = R.id.weekly_report_header)
    protected View mWeeklyReportHeader;

    //Data
    private String mReportId;

    public static void launch(Activity activity, String id) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, id);
        FragmentContainerActivity.launch(activity, ReportFormWorkReportFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReportId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mReportId);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_report_form_work_report;
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ReportDataItem> newItemView() {
        return new ReportItemView();
    }

    @Override
    public int getItemViewType(int position) {
        if(getCurMainTab()==TYPE_DAILY_REPORT){
            return ITEM_TYPE_DAILY_REPORT;
        }else{
            return ITEM_TYPE_WEEKLY_REPORT;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    protected void requestData(RefreshMode mode) {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("PageIndex", getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("new_kind", 2);//类别（1为公告、2为通知）

        //Temp 数据
        startFormRequest(ApiUrls.NOTICE_LIST, requestParams, new PagingTask<BaseResponseBean>(mode) {
            @Override
            public BaseResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, BaseResponseBean.class);
            }

            @Override
            public String verifyResponseResult(BaseResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<ReportFormWorkReportFragment.ReportDataItem> parseResult(BaseResponseBean baseResponseBean) {
                List<ReportFormWorkReportFragment.ReportDataItem> items = new ArrayList<>();
                if (baseResponseBean != null) {
                    for (int i = 0; i < 20; i++) {
                        ReportFormWorkReportFragment.ReportDataItem reportDataItem = new ReportFormWorkReportFragment.ReportDataItem();
                        items.add(reportDataItem);
                    }
                }
                return items;
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    @Override
    protected List<TabInfo> generateTabList() {
        List<TabInfo> tabs = new ArrayList<>();
        TabInfo dailyReportTab = new TabInfo();
        dailyReportTab.tabCode = TYPE_DAILY_REPORT;
        dailyReportTab.name = "日报表";

        TabInfo weeklyReportTab = new TabInfo();
        weeklyReportTab.tabCode = TYPE_WEEKLY_REPORT;
        weeklyReportTab.name = "周报表";

        tabs.add(dailyReportTab);
        tabs.add(weeklyReportTab);
        return tabs;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("工作报告");
        refreshHeaderView(TYPE_DAILY_REPORT);
    }

    @Override
    protected void onTabChanged(int mainTabCode, int subTabCode) {
        refreshHeaderView(mainTabCode);
        setRefreshing();
    }

    @Override
    public void onCreateCustomActionMenu(LinearLayout menuContent, Activity activity) {
        ImageView filterIcon=new ImageView(activity);
        filterIcon.setMinimumWidth(PixelUtils.dp2px(40));
        filterIcon.setMinimumHeight(PixelUtils.dp2px(40));
        filterIcon.setImageResource(R.drawable.icon_occupy);
        filterIcon.setBackgroundResource(R.drawable.default_bg);

        menuContent.addView(filterIcon);
    }

    private void refreshHeaderView(int tabCode) {
        switch (tabCode) {
            case TYPE_DAILY_REPORT:
                mDailyReportHeader.setVisibility(View.VISIBLE);
                mWeeklyReportHeader.setVisibility(View.GONE);
                break;
            case TYPE_WEEKLY_REPORT:
                mDailyReportHeader.setVisibility(View.GONE);
                mWeeklyReportHeader.setVisibility(View.VISIBLE);
                break;
        }
    }

    private class ReportItemView extends ABaseAdapter.AbstractItemView<ReportDataItem> {

        @Override
        public int inflateViewId() {
            if(getItemViewType()==ITEM_TYPE_DAILY_REPORT){
                return R.layout.list_item_dialy_form;
            }else{
                return R.layout.list_item_weekly_form;
            }

        }

        @Override
        public void bindingData(View convertView, ReportDataItem data) {

        }
    }

    public class ReportDataItem {
        DailyReportItem mDailyReport;//日报表项
        WeekLyReportItem mWeekLyReport;//周报表项
    }

    public class DailyReportItem {

    }

    public class WeekLyReportItem {

    }

}
