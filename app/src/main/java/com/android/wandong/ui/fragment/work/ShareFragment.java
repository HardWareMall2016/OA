package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.ShareListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.common.PhotosFragment;
import com.android.wandong.ui.widget.FixGridView;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.utils.PixelUtils;

import java.util.ArrayList;
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
//分享
public class ShareFragment extends BaseWorkPageFragment<ShareFragment.ItemData, ShareListResponseBean> {
    public static final String TAB_TYPE = "SHARE";
    public static final String TAB_NAME = "分享";

    private LayoutInflater mInflater;

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mInflater = inflater;

    }

    @Override
    public int getListDividerHeight() {
        return PixelUtils.dp2px(8);
    }

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex", getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("BeginDate", "");
        requestParams.put("EndDate", "");
        requestParams.put("SearchName", "");
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.SHARE_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(ShareListResponseBean baseResponseBean, List<ItemData> items) {
        if (baseResponseBean.getEntityInfo() != null) {
            for (ShareListResponseBean.EntityInfoBean dataItem : baseResponseBean.getEntityInfo()) {
                ItemData item = new ItemData();
                item.newShareid = dataItem.getNewShareid();
                item.newName = dataItem.getNewName();
                item.newContent = dataItem.getNewContent();
                item.newReplynumber = dataItem.getNewReplynumber();
                item.OwnerId = dataItem.getOwnerId();
                item.OwnerName = dataItem.getOwnerName();
                item.CreatedOn = dataItem.getCreatedOn();
                item.AttachmentsList = dataItem.getAttachmentsList();
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
        //NoticeDetailsFragment.launch(getActivity(),getAdapterItems().get((int)id).new_noticeinfoid);
    }

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData> {

        @ViewInject(id = R.id.headPortrait)
        protected ImageView mViewHeadPortrait;

        @ViewInject(id = R.id.name)
        protected TextView mViewName;

        @ViewInject(id = R.id.title)
        protected TextView mViewTitle;

        @ViewInject(id = R.id.content)
        protected TextView mViewContent;

        @ViewInject(id = R.id.time)
        protected TextView mViewTime;

        @ViewInject(id = R.id.photos)
        protected FixGridView mFixGridView;

        @ViewInject(id = R.id.command_or_replay)
        protected TextView mViewReply;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_share;
        }

        @Override
        public void bindingData(View convertView, final ItemData data) {
            //ImageLoader.getInstance().displayImage(data.PersonalImage, mViewHeadPortrait, Tools.buildDisplayImageOptionsForAvatar());

            Tools.setTextView(mViewName, data.OwnerName);
            Tools.setTextView(mViewTitle, data.newName);
            Tools.setTextView(mViewContent, data.newContent);

            long time = Tools.parseDateStrToLong(data.CreatedOn);
            Tools.setTextView(mViewTime, Tools.parseTimeToChinaMonthMinutes(time));

            String reply=data.newReplynumber;
            if(TextUtils.isEmpty(reply)){
                reply="0";
            }
            mViewReply.setText(String.format("共%s条回复", reply));

            if (data.AttachmentsList.size() == 0) {
                mFixGridView.setVisibility(View.GONE);
            } else {
                mFixGridView.setVisibility(View.VISIBLE);
                mFixGridView.setAdapter(new GridViewAdapter(data.AttachmentsList));
                mFixGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        PhotosFragment.launch(getActivity(), new ArrayList<>(data.AttachmentsList), position);
                    }
                });
            }
        }
    }


    private class GridViewAdapter extends BaseAdapter {
        List<String> mAttachmentInfo = new ArrayList<>();

        public GridViewAdapter(List<String> attachmentInfo) {
            mAttachmentInfo = attachmentInfo;
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
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_item_common_attachment, null);
                holder = new GridViewHolder(convertView);
            } else {
                holder = (GridViewHolder) convertView.getTag();
            }

            ImageLoader.getInstance().displayImage(mAttachmentInfo.get(position), holder.viewAttachment, Tools.buildDefDisplayImgOptions());

            return convertView;
        }
    }

    private class GridViewHolder {
        public ImageView viewAttachment;

        public GridViewHolder(View convertView) {
            viewAttachment = (ImageView) convertView.findViewById(R.id.attachment);
            convertView.setTag(this);
        }
    }

    public class ItemData {
        String newShareid;
        String newName;
        String newContent;
        String newReplynumber;
        String OwnerId;
        String OwnerName;
        String CreatedOn;
        List<String> AttachmentsList;
    }
}
