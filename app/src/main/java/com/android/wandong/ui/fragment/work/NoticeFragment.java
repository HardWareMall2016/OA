package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.NoticeResponseBean;
import com.android.wandong.network.ApiUrls;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;

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
//通知
public class NoticeFragment extends BaseWorkPageFragment<NoticeFragment.ItemData, NoticeResponseBean> {
    public static final String TAB_TYPE = "NOTICE";
    public static final String TAB_NAME = "通知";

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex", getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("new_kind", 2);//类别（1为公告、2为通知）
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.NOTICE_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(NoticeResponseBean baseResponseBean, List<ItemData> items) {
        if (baseResponseBean.getEntityInfo() != null) {
            for (NoticeResponseBean.EntityInfoBean dataItem : baseResponseBean.getEntityInfo()) {
                ItemData item = new ItemData();
                items.add(item);
            }
        }
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ItemData> newItemView() {
        return new ListItemView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NoticeDetailsFragment.launch(getActivity(),getAdapterItems().get((int)id).noticeId);
    }

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData> {

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
            return R.layout.list_item_notice;
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
        String noticeId;
    }
}
