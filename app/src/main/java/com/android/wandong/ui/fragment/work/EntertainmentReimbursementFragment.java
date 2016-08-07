package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.EntertainmentReimbursementResponseBean;
import com.android.wandong.beans.NoticeResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.work.Tools.AuditStatusHelper;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.utils.ToastUtils;

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
public class EntertainmentReimbursementFragment extends BaseWorkPageFragment<EntertainmentReimbursementFragment.ItemData, EntertainmentReimbursementResponseBean> {
    public static final String TAB_TYPE="ENTERTAINMENT_REIMBURSEMENT";
    public static final String TAB_NAME="招待费报销";
    private DisplayImageOptions mDisplayImageOptions=Tools.buildDisplayImgOptions(R.drawable.head_portrait_entertain_apply);


    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.ENTER_TAIN_EXPENSE;
    }

    @Override
    protected void parseResponseBeanToItemDataList(EntertainmentReimbursementResponseBean baseResponseBean, List<ItemData> items) {
        if(baseResponseBean.getEntityInfo()!=null){
            for(EntertainmentReimbursementResponseBean.EntityInfoBean beanItem:baseResponseBean.getEntityInfo()){
                ItemData item=new ItemData();
                item.setId(beanItem.getId());
                item.setApplyNo(beanItem.getApplyNo());
                item.setAccountId(beanItem.getAccountId());
                item.setAccountName(beanItem.getAccountName());
                item.setReason(beanItem.getReason());
                item.setNumber(beanItem.getNumber());
                item.setAmount(beanItem.getAmount());
                item.setStatus(beanItem.getStatus());
                item.setOwnerId(beanItem.getOwnerId());
                item.setOwnerName(beanItem.getOwnerName());
                item.setCreatedOn(beanItem.getCreatedOn());
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
        EntertainmentReimbursementDetailFragment.launch(getActivity(),getAdapterItems().get((int) id).getId());
    }

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData>{

        @ViewInject(id = R.id.headPortrait)
        ImageView mViewHeadPortrait;

        @ViewInject(id = R.id.ApplyNo)
        TextView mViewApplyNo;

        @ViewInject(id = R.id.AccountName)
        TextView mViewAccountNamet;

        @ViewInject(id = R.id.name)
        TextView mViewName;

        @ViewInject(id = R.id.number)
        TextView mViewNumber;

        @ViewInject(id = R.id.time)
        TextView mViewTime;

        @ViewInject(id = R.id.img_status)
        ImageView mViewImgStatus;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_entertainment_reimbursement;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            //ImageLoader.getInstance().displayImage(data.PersonalImage, mViewHeadPortrait, mDisplayImageOptions);

            Tools.setTextView(mViewApplyNo, data.ApplyNo);
            Tools.setTextView(mViewAccountNamet,data.AccountName);
            Tools.setTextView(mViewName,data.OwnerName);
            Tools.setTextView(mViewNumber, String.valueOf(data.Number));
            AuditStatusHelper.setImageViewByStatus(mViewImgStatus, data.Status);
        }
    }

    public class ItemData {
        private String Id;
        private String ApplyNo;
        private String AccountId;
        private String AccountName;
        private String Reason;
        private int Number;
        private double Amount;
        private int Status;
        private String OwnerId;
        private String OwnerName;
        private String CreatedOn;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getApplyNo() {
            return ApplyNo;
        }

        public void setApplyNo(String ApplyNo) {
            this.ApplyNo = ApplyNo;
        }

        public String getAccountId() {
            return AccountId;
        }

        public void setAccountId(String AccountId) {
            this.AccountId = AccountId;
        }

        public String getAccountName() {
            return AccountName;
        }

        public void setAccountName(String AccountName) {
            this.AccountName = AccountName;
        }

        public String getReason() {
            return Reason;
        }

        public void setReason(String Reason) {
            this.Reason = Reason;
        }

        public int getNumber() {
            return Number;
        }

        public void setNumber(int Number) {
            this.Number = Number;
        }

        public double getAmount() {
            return Amount;
        }

        public void setAmount(double Amount) {
            this.Amount = Amount;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getOwnerId() {
            return OwnerId;
        }

        public void setOwnerId(String OwnerId) {
            this.OwnerId = OwnerId;
        }

        public String getOwnerName() {
            return OwnerName;
        }

        public void setOwnerName(String OwnerName) {
            this.OwnerName = OwnerName;
        }

        public String getCreatedOn() {
            return CreatedOn;
        }

        public void setCreatedOn(String CreatedOn) {
            this.CreatedOn = CreatedOn;
        }
    }
}
