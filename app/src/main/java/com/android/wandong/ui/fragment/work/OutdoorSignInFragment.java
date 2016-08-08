package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.OutDoorSignInListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.FixGridView;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;
import com.zhan.framework.utils.PixelUtils;

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

    @ViewInject(id = R.id.search_content)
    protected View mViewContentSearch;

    private final static int PAGE_SIZE=10;

    private LayoutInflater mInflater;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_comm_layout_with_search;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mInflater=inflater;
    }

    @Override
    protected void setInitPullToRefresh(ListView listView, PullToRefreshListView pullToRefreshListView, Bundle savedInstanceState) {
        super.setInitPullToRefresh(listView, pullToRefreshListView, savedInstanceState);
        listView.setDividerHeight(PixelUtils.dp2px(16));

        LinearLayout.LayoutParams lp=(LinearLayout.LayoutParams)mViewContentSearch.getLayoutParams();
        lp.bottomMargin=0;
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
                        OutDoorSignInListResponseBean.EntityInfoBean.SignInfoBean signInfoBean=dataItem.getSignInfo();
                        if(signInfoBean==null){
                            continue;
                        }
                        ItemData item=new ItemData();
                        item.SignId=signInfoBean.getSignId();
                        item.OwnerId=signInfoBean.getOwnerId();
                        item.OwnerName=signInfoBean.getOwnerName();
                        item.Address=signInfoBean.getAddress();
                        item.SignOutAddress=signInfoBean.getSignOutAddress();
                        item.LocationTime=signInfoBean.getLocationTime();
                        item.Latitude=signInfoBean.getLatitude();
                        item.Longitude=signInfoBean.getLongitude();
                        item.AccountId=signInfoBean.getAccountId();
                        item.AccountName=signInfoBean.getAccountName();
                        item.Remarks=signInfoBean.getRemarks();
                        item.SignInTime=signInfoBean.getSignInTime();
                        item.SignOutTime=signInfoBean.getSignOutTime();
                        item.Signabnormal=signInfoBean.getSignabnormal();
                        item.SignInAbnormal=signInfoBean.getSignInAbnormal();
                        item.AbnormalDistance=signInfoBean.getAbnormalDistance();
                        item.PersonalImage=signInfoBean.getPersonalImage();

                        List<String> attachmentInfo=dataItem.getAttachmentInfo();
                        if(attachmentInfo!=null){
                            item.AttachmentInfo.addAll(attachmentInfo);
                        }

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

        @ViewInject(id = R.id.attachment_info)
        protected FixGridView mViewAttachmentInfo;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_outdoor_sign;
        }

        @Override
        public void bindingData(View convertView, final ItemData data) {
            ImageLoader.getInstance().displayImage(data.PersonalImage, mViewHeadPortrait, Tools.buildDisplayImageOptionsForAvatar());
            Tools.setTextView(mViewName, data.OwnerName);
            Tools.setTextView(mViewLocation,"地点："+data.Address);
            Tools.setTextView(mViewRelativeCustomer,"关联客户："+data.AccountName);
            Tools.setTextView(mViewSummary,data.Remarks);

            if(data.AttachmentInfo.size()==0){
                mViewAttachmentInfo.setVisibility(View.GONE);
            }else {
                mViewAttachmentInfo.setVisibility(View.VISIBLE);
                mViewAttachmentInfo.setAdapter(new GridViewAdapter(data.AttachmentInfo));
                mViewAttachmentInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        OutdoorSignAttachmentsFragment.ParamsBean paramsBean=new OutdoorSignAttachmentsFragment.ParamsBean();
                        paramsBean.photos=data.AttachmentInfo;
                        paramsBean.showPos=position;
                        paramsBean.address=data.Address;
                        OutdoorSignAttachmentsFragment.launch(getActivity(), paramsBean);
                    }
                });
            }
        }
    }

    private class GridViewAdapter extends BaseAdapter{
        List<String> mAttachmentInfo=new ArrayList<>();
        public GridViewAdapter( List<String> attachmentInfo){
            mAttachmentInfo=attachmentInfo;
        }

        @Override
        public int getCount() {
            return mAttachmentInfo.size();
        }

        @Override
        public Object getItem(int position) {
            return mAttachmentInfo.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            GridViewHolder holder;
            if(convertView==null){
                convertView=mInflater.inflate(R.layout.list_item_common_attachment,null);
                holder=new GridViewHolder(convertView);
            }else{
                holder= (GridViewHolder)convertView.getTag();
            }

            ImageLoader.getInstance().displayImage(mAttachmentInfo.get(position), holder.viewAttachment, Tools.buildDefDisplayImgOptions());

            return convertView;
        }
    }

    private class GridViewHolder{
        public ImageView viewAttachment;
        public GridViewHolder(View convertView){
            viewAttachment=(ImageView)convertView.findViewById(R.id.attachment);
            convertView.setTag(this);
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

        List<String> AttachmentInfo=new ArrayList<>();
    }
}
