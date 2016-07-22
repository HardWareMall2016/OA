package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.OutDoorSignInListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/7/20 20:35
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
//外勤签到
public class OutdoorSignInFragment extends APullToRefreshListFragment<OutdoorSignInFragment.ItemData> {
    public static final String TAB_TYPE="OUTDOOR_SIGN_IN";
    public static final String TAB_NAME="外勤签到";

    private final static int PAGE_SIZE=10;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_comm_layout_with_search;
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ItemData> newItemView() {
        return new ListItemView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        OutdoorSignDetailFragment.launch(getActivity(),getAdapterItems().get((int)id).SignId);
    }

    @Override
    protected void configRefresh(RefreshConfig config) {
        config.minResultSize=PAGE_SIZE;
    }

    @Override
    protected void requestData(RefreshMode mode) {
        HttpRequestParams requestParams= Tools.createHttpRequestParams();
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", PAGE_SIZE);

        startFormRequest(ApiUrls.OUTDOOR_SIGN_IN_LIST, requestParams, new PagingTask<OutDoorSignInListResponseBean>(mode) {
            @Override
            public OutDoorSignInListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, OutDoorSignInListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(OutDoorSignInListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<ItemData> parseResult(OutDoorSignInListResponseBean baseResponseBean) {
                List<ItemData> items=new ArrayList<>();
                if(baseResponseBean!=null&&baseResponseBean.getEntityInfo()!=null){
                    for(OutDoorSignInListResponseBean.EntityInfoBean dataItem:baseResponseBean.getEntityInfo()){
                        ItemData item=new ItemData();
                        item.SignId=dataItem.getSignId();
                        item.OwnerId=dataItem.getOwnerId();
                        item.OwnerName=dataItem.getOwnerName();
                        item.Address=dataItem.getAddress();
                        item.SignOutAddress=dataItem.getSignOutAddress();
                        item.LocationTime=dataItem.getLocationTime();
                        item.Latitude=dataItem.getLatitude();
                        item.Longitude=dataItem.getLongitude();
                        item.AccountId=dataItem.getAccountId();
                        item.AccountName=dataItem.getAccountName();
                        item.Remarks=dataItem.getRemarks();
                        item.SignInTime=dataItem.getSignInTime();
                        item.SignOutTime=dataItem.getSignOutTime();
                        item.Signabnormal=dataItem.getSignabnormal();
                        item.SignInAbnormal=dataItem.getSignInAbnormal();
                        item.AbnormalDistance=dataItem.getAbnormalDistance();
                        item.PersonalImage=dataItem.getPersonalImage();
                        items.add(item);
                    }
                }

                return items;
            }
        }, HttpRequestUtils.RequestType.POST);
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
            return R.layout.list_item_outdoor_sign;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            ImageLoader.getInstance().displayImage(data.PersonalImage, mViewHeadPortrait, Tools.buildDisplayImageOptionsForAvatar());
            Tools.setTextView(mViewName, data.OwnerName);
            Tools.setTextView(mViewLocation,"地点："+data.Address);
            Tools.setTextView(mViewRelativeCustomer,"关联客户："+data.AccountName);
            Tools.setTextView(mViewSummary,data.Remarks);
        }
    }

    public class ItemData {
        String SignId;
        String OwnerId;
        String OwnerName;
        String Address;
        String SignOutAddress;
        String LocationTime;
        String Latitude;
        String Longitude;
        String AccountId;
        String AccountName;
        String Remarks;
        String SignInTime;
        String SignOutTime;
        int Signabnormal;
        int SignInAbnormal;
        int AbnormalDistance;
        String PersonalImage;
    }
}
