package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.NoticeResponseBean;
import com.android.wandong.beans.TenderApplicationResponseBean;
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
public class TenderApplicationFragment extends BaseWorkPageFragment<TenderApplicationFragment.ItemData, TenderApplicationResponseBean> {
    public static final String TAB_TYPE="TENDER_APPLICATION";
    public static final String TAB_NAME="招投标申请";

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.TENDER_AUTHORIZATION_APPLY_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(TenderApplicationResponseBean baseResponseBean, List<ItemData> items) {
        if(baseResponseBean.getEntityInfo()!=null){
            for(TenderApplicationResponseBean.EntityInfoBean beanItem:baseResponseBean.getEntityInfo()){
                ItemData item=new ItemData();
                item.setTenderAuthorizationId(beanItem.getTenderAuthorizationId());
                item.setApplyNo(beanItem.getApplyNo());
                item.setName(beanItem.getName());
                item.setBidStatus(beanItem.getBidStatus());
                item.setNumber(beanItem.getNumber());
                item.setAccountName(beanItem.getAccountName());
                item.setOwnerName(beanItem.getOwnerName());
                item.setCreatedOn(beanItem.getCreatedOn());
                item.setStatus(beanItem.getStatus());
                item.setQuantity(beanItem.getQuantity());
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
        TenderApplicationDetailsFragment.launch(getActivity(), getAdapterItems().get((int) id).TenderAuthorizationId);
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
            return R.layout.list_item_tender_application;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            mApplyNo.setText(data.getName());
            mName.setText(data.getOwnerName());
            mNumber.setText(data.getQuantity()+"台");
            AuditStatusHelper.setImageViewByStatus(mViewStatus, data.getStatus());
        }
    }

    public class ItemData {
        private String TenderAuthorizationId;
        private String ProjectName;
        private String ApplyNo;
        private String Name;
        private int BidStatus;
        private String OpenTendersTime;
        private int Quantity;
        private String Number;
        private String AccountName;
        private String OwnerName;
        private String CreatedOn;
        private int Status;

        public String getTenderAuthorizationId() {
            return TenderAuthorizationId;
        }

        public void setTenderAuthorizationId(String TenderAuthorizationId) {
            this.TenderAuthorizationId = TenderAuthorizationId;
        }

        public String getProjectName() {
            return ProjectName;
        }

        public void setProjectName(String ProjectName) {
            this.ProjectName = ProjectName;
        }

        public String getApplyNo() {
            return ApplyNo;
        }

        public void setApplyNo(String ApplyNo) {
            this.ApplyNo = ApplyNo;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getBidStatus() {
            return BidStatus;
        }

        public void setBidStatus(int BidStatus) {
            this.BidStatus = BidStatus;
        }

        public String getOpenTendersTime() {
            return OpenTendersTime;
        }

        public void setOpenTendersTime(String OpenTendersTime) {
            this.OpenTendersTime = OpenTendersTime;
        }

        public int getQuantity() {
            return Quantity;
        }

        public void setQuantity(int Quantity) {
            this.Quantity = Quantity;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String Number) {
            this.Number = Number;
        }

        public String getAccountName() {
            return AccountName;
        }

        public void setAccountName(String AccountName) {
            this.AccountName = AccountName;
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

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }
    }
}
