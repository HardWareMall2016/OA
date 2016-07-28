package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.CHScrollView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;

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
public class ReportFormReimbursementDetails extends APullToRefreshListFragment<ReportFormReimbursementDetails.ReportDataItem> implements  CHScrollView.OnScrollChangedListener{

    @ViewInject(id = R.id.header_scroll_content)
    protected CHScrollView mHeaderScrollPart;

    private List<CHScrollView> mScrollViews=new ArrayList<>();

    @Override
    protected int inflateContentView() {
        return R.layout.report_form_reimbursement_details;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mScrollViews.clear();
        mHeaderScrollPart.setOnCHScrollChangedListener(this);
        mScrollViews.add(mHeaderScrollPart);
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ReportDataItem> newItemView() {
        return new ReportItemView();
    }

    @Override
    protected void requestData(RefreshMode mode) {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("PageIndex", getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("new_kind", 1);//类别（1为公告、2为通知）

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
            protected List<ReportFormReimbursementDetails.ReportDataItem> parseResult(BaseResponseBean baseResponseBean) {
                List<ReportFormReimbursementDetails.ReportDataItem> items = new ArrayList<>();
                if (baseResponseBean != null) {
                    for (int i = 0; i < 20; i++) {
                        ReportFormReimbursementDetails.ReportDataItem reportDataItem = new ReportFormReimbursementDetails.ReportDataItem();
                        items.add(reportDataItem);
                    }
                }
                return items;
            }
        }, HttpRequestUtils.RequestType.POST);
    }


    @Override
    public void onScrollChanged(int l, int t, int oldl, int oldt, CHScrollView scrollView) {
        for (CHScrollView view:mScrollViews){
            if(view!=scrollView){
                view.smoothScrollTo(l,t);
            }
        }
    }

    private class ReportItemView extends ABaseAdapter.AbstractItemView<ReportDataItem> {
        @ViewInject(id = R.id.scroll_content)
        protected CHScrollView mScrollPart;

        @Override
        public int inflateViewId() {
                return R.layout.list_item_report_form_reimbursement_details;
        }

        @Override
        public void bindingView(View convertView) {
            super.bindingView(convertView);
            mScrollPart.setOnCHScrollChangedListener(ReportFormReimbursementDetails.this);
            mScrollViews.add(mScrollPart);
        }

        @Override
        public void bindingData(View convertView, ReportDataItem data) {
            mScrollPart.setScrollX(mHeaderScrollPart.getScrollX());
        }
    }

    public class ReportDataItem {

    }

}
