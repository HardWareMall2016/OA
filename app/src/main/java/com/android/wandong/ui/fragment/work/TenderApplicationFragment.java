package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.ImageView;

import com.android.wandong.R;
import com.android.wandong.beans.NoticeResponseBean;
import com.android.wandong.network.ApiUrls;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;

import java.util.List;

/**
 * 作者：伍岳 on 2016/7/29 16:20
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
public class TenderApplicationFragment extends BaseWorkPageFragment<TenderApplicationFragment.ItemData, NoticeResponseBean> {
    public static final String TAB_TYPE="TENDER_APPLICATION";
    public static final String TAB_NAME="招投标申请";

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("new_kind", 1);//类别（1为公告、2为通知）
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.NOTICE_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(NoticeResponseBean baseResponseBean, List<ItemData> items) {
        if(baseResponseBean.getEntityInfo()!=null){
            for(int i=0;i<10;i++){
                ItemData item=new ItemData();
                items.add(item);
            }
        }
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ItemData> newItemView() {
        return new ListItemView();
    }

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData>{

        @ViewInject(id = R.id.headPortrait)
        protected ImageView mViewHeadPortrait;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_tender_application;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {

        }
    }

    public class ItemData {

    }
}
