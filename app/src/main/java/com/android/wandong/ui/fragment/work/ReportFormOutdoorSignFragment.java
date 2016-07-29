package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.CHScrollView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;
import com.zhan.framework.utils.PixelUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/7/22 23:29
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
public class ReportFormOutdoorSignFragment extends APullToRefreshListFragment<ReportFormOutdoorSignFragment.ReportItem>  implements  CHScrollView.OnScrollChangedListener{

    private final static String ARG_KEY = "arg_key";

    @ViewInject(id = R.id.header_scroll_content)
    protected CHScrollView mHeaderScrollPart;

    private List<CHScrollView> mScrollViews=new ArrayList<>();

    public static void launch(Activity activity, String id) {
        FragmentContainerActivity.launch(activity, ReportFormOutdoorSignFragment.class, null);
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

    @Override
    protected int inflateContentView() {
        return R.layout.frag_report_form_outdoor_sign;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("外勤签到");
        mScrollViews.clear();
        mHeaderScrollPart.setOnCHScrollChangedListener(this);
        mScrollViews.add(mHeaderScrollPart);
    }


    @Override
    protected ABaseAdapter.AbstractItemView<ReportItem> newItemView() {
        return new ReportFormItemView();
    }

    @Override
    protected void requestData(RefreshMode mode) {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("PageIndex", getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("new_kind", 2);//类别（1为公告、2为通知）

        startFormRequest(ApiUrls.OUTDOOR_SIGN_IN_LIST, requestParams, new PagingTask<BaseResponseBean>(mode) {
            @Override
            public BaseResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, BaseResponseBean.class);
            }

            @Override
            public String verifyResponseResult(BaseResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<ReportItem> parseResult(BaseResponseBean baseResponseBean) {
                List<ReportItem> items=new ArrayList<>();
                if(baseResponseBean!=null){
                    for (int i = 0; i < 20; i++) {
                        ReportItem reportDataItem = new ReportItem();
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

    public class ReportItem {

    }

    private class ReportFormItemView extends ABaseAdapter.AbstractItemView<ReportItem> {
        @ViewInject(id = R.id.scroll_content)
        protected CHScrollView mScrollPart;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_outdoor_sign_form;
        }

        @Override
        public void bindingView(View convertView) {
            super.bindingView(convertView);
            //第一次满屏后，向下滑动，有一条数据在开始时未加入
            final int scrollX =mHeaderScrollPart.getScrollX();
            if(scrollX != 0) {
                mScrollPart.post(new Runnable() {
                    @Override
                    public void run() {
                        //当listView刷新完成之后，把该条移动到最终位置
                        mScrollPart.scrollTo(scrollX, 0);
                    }
                });
            }
            mScrollPart.setOnCHScrollChangedListener(ReportFormOutdoorSignFragment.this);
            mScrollViews.add(mScrollPart);
        }

        @Override
        public void bindingData(View convertView, ReportItem data) {

        }
    }

}
