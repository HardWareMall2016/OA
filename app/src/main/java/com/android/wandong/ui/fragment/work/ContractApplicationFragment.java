package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.ContractApplicationResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.work.Tools.AuditStatusHelper;
import com.android.wandong.utils.Tools;
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
public class ContractApplicationFragment extends BaseWorkPageFragment<ContractApplicationFragment.ItemData, ContractApplicationResponseBean> {
    public static final String TAB_TYPE="CONTRACT_APPLICATION";
    public static final String TAB_NAME="合同申请";

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("BeginDate","");
        requestParams.put("ContractName","");
        requestParams.put("EndDate","");
        requestParams.put("ExecutionStatus","");
        requestParams.put("IsJustLookOwner","false");
        requestParams.put("OwnerId","");
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("PassWord", UserInfo.getCurrentUser().getPassword());
        requestParams.put("Province","");
        requestParams.put("SearchName","");
        requestParams.put("UserName",UserInfo.getCurrentUser().getUserName());
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.CONTRACT_APPLY_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(ContractApplicationResponseBean baseResponseBean, List<ItemData> items) {
        if(baseResponseBean.getEntityInfo()!=null){
            for(ContractApplicationResponseBean.EntityInfoBean beanItem:baseResponseBean.getEntityInfo()){
                ItemData item=new ItemData();
                item.ContractId = beanItem.getField1().getValue();
                item.ApplyNo = beanItem.getField2().getValue();
                item.Status = beanItem.getField3().getValue();
                item.OwnerName = beanItem.getField4().getValue();
                item.ContracTotal = beanItem.getField5().getValue();
                item.ContractName = beanItem.getField7().getValue();
                item.CreatedOn = beanItem.getField8().getValue();
                items.add(item);
            }
        }
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ItemData> newItemView() {
        return new ListItemView();
    }

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData>{

        @ViewInject(id = R.id.ContractName)
        TextView mContractName;
        @ViewInject(id = R.id.create_on)
        TextView mCreateOn;
        @ViewInject(id = R.id.Status)
        TextView mStatus;
        @ViewInject(id = R.id.OwnerName)
        TextView mOwnerName ;
        @ViewInject(id = R.id.ContracTotal)
        TextView mContracTotal ;
        @ViewInject(id = R.id.time)
        TextView mViewTime;

        @ViewInject(id = R.id.img_status)
        ImageView mImageStatus ;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_contract_application;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            mContractName.setText(data.ContractName);
            mCreateOn.setText("创建时间：" + Tools.parseTimeToDateStr(Tools.parseDateStrToLong(data.CreatedOn)));
            if(data.Status == 3){
                mStatus.setText("执行状态：已批准");
            }else if(data.Status == 2){
                mStatus.setText("执行状态：待审批");
            }else{
                mStatus.setText("执行状态："+data.Status+"");
            }
            mOwnerName.setText(data.OwnerName);
            mContracTotal.setText(data.ContracTotal+"");
            Tools.setTextView(mViewTime, Tools.parseTimeToDateStr(Tools.parseDateStrToLong(data.CreatedOn)));
            AuditStatusHelper.setImageViewByStatus(mImageStatus, data.Status);

        }
    }

    public class ItemData {
        private String ContractId ;//ID
        private String ApplyNo ;//单据号
        private int Status;//执行状态
        private String OwnerName;//负责人
        private int ContracTotal ;//合同金额
        private String ContractName ;//合同名称
        private String CreatedOn;//创建时间

    }
}
