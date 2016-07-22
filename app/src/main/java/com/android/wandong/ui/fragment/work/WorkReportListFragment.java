package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.WorkReportListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
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
                items.add(item);
            }
        }
    }

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData>{

        @ViewInject(id = R.id.headPortrait)
        protected ImageView mViewHeadPortrait;

        @ViewInject(id = R.id.name)
        protected TextView mViewName;

        @ViewInject(id = R.id.time)
        protected TextView mViewTime;

        @ViewInject(id = R.id.sign_time)
        protected TextView mViewSignTime;

        @ViewInject(id = R.id.summary)
        protected TextView mViewSummary;

        @ViewInject(id = R.id.location)
        protected TextView mViewLocation;

        @ViewInject(id = R.id.relative_customer)
        protected TextView mViewRelativeCustomer;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_work_report;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            /*ImageLoader.getInstance().displayImage(data.PersonalImage, mViewHeadPortrait, Tools.buildDisplayImageOptionsForAvatar());
            Tools.setTextView(mViewName, data.OwnerName);
            Tools.setTextView(mViewLocation,"地点："+data.Address);
            Tools.setTextView(mViewRelativeCustomer,"关联客户："+data.AccountName);
            Tools.setTextView(mViewSummary,data.Remarks);*/
        }
    }

    public class ItemData {

    }
}
