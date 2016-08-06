package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.NoticeResponseBean;
import com.android.wandong.beans.TravelExpenseReimburseResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.work.Tools.AuditStatusHelper;
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
public class TravelExpenseReimbursementFragment extends BaseWorkPageFragment<TravelExpenseReimbursementFragment.ItemData, TravelExpenseReimburseResponseBean> {
    public static final String TAB_TYPE="TRAVEL_EXPENSE_REIMBURSEMENT";
    public static final String TAB_NAME="差旅费报销";

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("IsJustLookOwner", "");
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.TRAVEL_EXPENSE_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(TravelExpenseReimburseResponseBean baseResponseBean, List<ItemData> items) {
        if(baseResponseBean.getEntityInfo()!=null){
            for(TravelExpenseReimburseResponseBean.EntityInfoBean beanItem:baseResponseBean.getEntityInfo()){
                ItemData item=new ItemData();
                item.setTravelCostId(beanItem.getTravelCostId());
                item.setName(beanItem.getName());
                item.setAuditStatus(beanItem.getAuditStatus());
                item.setStepNumber(beanItem.getStepNumber());
                item.setSubmitTime(beanItem.getSubmitTime());
                item.setApprovalPrice(beanItem.getApprovalPrice());
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

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData>{

        @ViewInject(id = R.id.ApplyNo)
        TextView mApplyNo ;
        @ViewInject(id = R.id.name)
        TextView mName ;
        @ViewInject(id = R.id.number)
        TextView mNumber ;
        @ViewInject(id = R.id.headPortrait)
        ImageView mViewHeadPortrait;
        @ViewInject(id = R.id.img_status)
        ImageView mViewStatus ;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_travel_expense_reimbursement;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            mApplyNo.setText(data.getName());
            mName.setText(data.getOwnerName());
            mNumber.setText(data.getApprovalPrice()+"");
            AuditStatusHelper.setImageViewByStatus(mViewStatus, data.getAuditStatus());
        }
    }

    public class ItemData {
        private String TravelCostId;
        private String Name;
        private int AuditStatus;
        private int StepNumber;
        private String SubmitTime;
        private double ApprovalPrice;
        private String OwnerId;
        private String OwnerName;
        private String CreatedOn;

        public String getTravelCostId() {
            return TravelCostId;
        }

        public void setTravelCostId(String TravelCostId) {
            this.TravelCostId = TravelCostId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getAuditStatus() {
            return AuditStatus;
        }

        public void setAuditStatus(int AuditStatus) {
            this.AuditStatus = AuditStatus;
        }

        public int getStepNumber() {
            return StepNumber;
        }

        public void setStepNumber(int StepNumber) {
            this.StepNumber = StepNumber;
        }

        public String getSubmitTime() {
            return SubmitTime;
        }

        public void setSubmitTime(String SubmitTime) {
            this.SubmitTime = SubmitTime;
        }

        public double getApprovalPrice() {
            return ApprovalPrice;
        }

        public void setApprovalPrice(double ApprovalPrice) {
            this.ApprovalPrice = ApprovalPrice;
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
