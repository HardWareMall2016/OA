package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.InspectionReceptionResponseBean;
import com.android.wandong.beans.NoticeResponseBean;
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
public class InspectionReceptionApplicationFragment extends BaseWorkPageFragment<InspectionReceptionApplicationFragment.ItemData, InspectionReceptionResponseBean> {
    public static final String TAB_TYPE="INSPECTION_RECEPTION_APPLICATION";
    public static final String TAB_NAME="考察接待申请";

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.RECEPTION_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(InspectionReceptionResponseBean baseResponseBean, List<ItemData> items) {
        if(baseResponseBean.getEntityInfo()!=null){
            for(InspectionReceptionResponseBean.EntityInfoBean beanItem:baseResponseBean.getEntityInfo()){
                ItemData item=new ItemData();
                item.setReceptionId(beanItem.getReceptionId());
                item.setApplyNo(beanItem.getApplyNo());
                item.setAccountId(beanItem.getAccountId());
                item.setAccountName(beanItem.getAccountName());
                item.setVisitName(beanItem.getVisitName());
                item.setVisitNumber(beanItem.getVisitNumber());
                item.setVisitTelephone(beanItem.getVisitTelephone());
                item.setApplyTime(beanItem.getApplyTime());
                item.setStatus(beanItem.getStatus());
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
        InspectionReceptionApplicationDetailsFragment.launch(getActivity(), getAdapterItems().get((int) id).ReceptionId);
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
            return R.layout.list_item_inspection_reception_application;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            mApplyNo.setText(data.getAccountName());
            mName.setText(data.getOwnerName());
            mNumber.setText(data.getVisitNumber()+"");
            AuditStatusHelper.setImageViewByStatus(mViewStatus, data.getStatus());
        }
    }

    public class ItemData {
        private String ReceptionId;
        private String ApplyNo;
        private String AccountId;
        private String AccountName;
        private String VisitName;
        private int VisitNumber;
        private String VisitTelephone;
        private String ApplyTime;
        private int Status;
        private String OwnerName;
        private String CreatedOn;

        public String getReceptionId() {
            return ReceptionId;
        }

        public void setReceptionId(String ReceptionId) {
            this.ReceptionId = ReceptionId;
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

        public String getVisitName() {
            return VisitName;
        }

        public void setVisitName(String VisitName) {
            this.VisitName = VisitName;
        }

        public int getVisitNumber() {
            return VisitNumber;
        }

        public void setVisitNumber(int VisitNumber) {
            this.VisitNumber = VisitNumber;
        }

        public String getVisitTelephone() {
            return VisitTelephone;
        }

        public void setVisitTelephone(String VisitTelephone) {
            this.VisitTelephone = VisitTelephone;
        }

        public String getApplyTime() {
            return ApplyTime;
        }

        public void setApplyTime(String ApplyTime) {
            this.ApplyTime = ApplyTime;
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

        public String getCreatedOn() {
            return CreatedOn;
        }

        public void setCreatedOn(String CreatedOn) {
            this.CreatedOn = CreatedOn;
        }
    }
}
