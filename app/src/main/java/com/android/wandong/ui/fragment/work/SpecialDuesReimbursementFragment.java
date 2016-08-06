package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.NoticeResponseBean;
import com.android.wandong.beans.SpecialDuesReimburseResponseBean;
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
public class SpecialDuesReimbursementFragment extends BaseWorkPageFragment<SpecialDuesReimbursementFragment.ItemData, SpecialDuesReimburseResponseBean> {
    public static final String TAB_TYPE="SPECIAL_DUES_REIMBURSEMENT";
    public static final String TAB_NAME="专项费报销";

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("AuditStatus", "");
        requestParams.put("BeginDate","");
        requestParams.put("EndDate","");
        requestParams.put("IsJustLookOwner","");
        requestParams.put("OwnerId","");
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.DAILY_EXPENSE_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(SpecialDuesReimburseResponseBean baseResponseBean, List<ItemData> items) {
        if(baseResponseBean.getEntityInfo()!=null){
            for(SpecialDuesReimburseResponseBean.EntityInfoBean beanItem:baseResponseBean.getEntityInfo()){
                ItemData item=new ItemData();
                item.setId(beanItem.getId());
                item.setApplyNo(beanItem.getApplyNo());
                item.setStatus(beanItem.getStatus());
                item.setOwnerName(beanItem.getOwnerName());
                item.setCostType(beanItem.getCostType());
                item.setAmount(beanItem.getAmount());
                item.setRemark(beanItem.getRemark());
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
            return R.layout.list_item_special_dues_reimbursement;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            mApplyNo.setText(data.getApplyNo());
            mName.setText(data.getOwnerName());
            mNumber.setText(data.getAmount()+"");
            AuditStatusHelper.setImageViewByStatus(mViewStatus, data.getStatus());
        }
    }

    public class ItemData {
        private String Id;
        private String ApplyNo;
        private int Status;
        private String OwnerName;
        private int CostType;
        private double Amount;
        private String Remark;
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

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getOwnerName() {
            return OwnerName;
        }

        public void setOwnerName(String OwnerName) {
            this.OwnerName = OwnerName;
        }

        public int getCostType() {
            return CostType;
        }

        public void setCostType(int CostType) {
            this.CostType = CostType;
        }

        public double getAmount() {
            return Amount;
        }

        public void setAmount(double Amount) {
            this.Amount = Amount;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public String getCreatedOn() {
            return CreatedOn;
        }

        public void setCreatedOn(String CreatedOn) {
            this.CreatedOn = CreatedOn;
        }
    }
}
