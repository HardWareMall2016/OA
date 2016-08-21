package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.ContractApplicationCreateBusinessListResponseBean;
import com.android.wandong.beans.MarketReimburseCreateListResponseBean;
import com.android.wandong.beans.ReimburseCreateTwoContent;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.work.Tools.AuditStatusHelper;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;
import com.zhan.framework.utils.PixelUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${keke} on 16/8/21.
 */
public class ContractApplicationCreateBusinessFragment extends APullToRefreshListFragment<ContractApplicationCreateBusinessFragment.AccountInfo> {

    private int mSelectedPos=-1;

    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, ContractApplicationCreateBusinessFragment.class, null);
    }

    @Override
    protected void setInitPullToRefresh(ListView listView, PullToRefreshListView pullToRefreshListView, Bundle savedInstanceState) {
        super.setInitPullToRefresh(listView, pullToRefreshListView, savedInstanceState);
        listView.setDividerHeight(getListDividerHeight());
        View searchHeader=getActivity().getLayoutInflater().inflate(R.layout.layout_work_search_header,null);
        if(getListDividerHeight()!=0){
            searchHeader.setPadding(PixelUtils.dp2px(8),PixelUtils.dp2px(0),PixelUtils.dp2px(8),PixelUtils.dp2px(0));
        }
        mPullToRefreshListView.getRefreshableView().addHeaderView(searchHeader);
    }

    public int getListDividerHeight(){
        return 0;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("选择商机");
    }


    @Override
    protected void requestData(RefreshMode mode) {
        if(mode!=RefreshMode.update){
            mSelectedPos=-1;
        }
        HttpRequestParams requestParams = new HttpRequestParams();
        requestParams.put("UserName", UserInfo.getCurrentUser().getUserName());
        requestParams.put("PassWord",UserInfo.getCurrentUser().getPassword());
        requestParams.put("Name","");
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);

        startFormRequest(ApiUrls.OPPORTUNITY_LIST, requestParams, new PagingTask<ContractApplicationCreateBusinessListResponseBean>(mode) {
            @Override
            public ContractApplicationCreateBusinessListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, ContractApplicationCreateBusinessListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(ContractApplicationCreateBusinessListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<AccountInfo> parseResult(ContractApplicationCreateBusinessListResponseBean baseResponseBean) {
                List<AccountInfo> items = new ArrayList<>();
                if (baseResponseBean != null && baseResponseBean.getEntityInfo() != null && baseResponseBean.getEntityInfo().getList() != null) {
                    for (ContractApplicationCreateBusinessListResponseBean.EntityInfoBean.ListBean bean : baseResponseBean.getEntityInfo().getList()) {
                        AccountInfo reportDataItem = new AccountInfo();
                        reportDataItem.OpportunityId = bean.getOpportunityId();
                        reportDataItem.Name = bean.getName();
                        reportDataItem.AccountName = bean.getAccountName();
                        reportDataItem.Stage = bean.getStage();
                        reportDataItem.EstimatedCloseDate = bean.getEstimatedCloseDate();
                        reportDataItem.EstimatedValue = bean.getEstimatedValue();
                        reportDataItem.CreatedOn = bean.getCreatedOn();
                        reportDataItem.OwnerName = bean.getOwnerName();
                        items.add(reportDataItem);
                    }
                }
                return items;
            }
        }, HttpRequestUtils.RequestType.POST);
    }
    @Override
    protected void configRefresh(RefreshConfig config) {
        config.minResultSize=20;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.onItemClick(parent, view, position, id);
        ContractApplicationCreateFragment.launch(getActivity(), getAdapterItems().get((int)id).OpportunityId);
    }

    @Override
    protected ABaseAdapter.AbstractItemView<AccountInfo> newItemView() {
        return new ItemView();
    }

    private class ItemView extends ABaseAdapter.AbstractItemView<AccountInfo>{
        @ViewInject(id = R.id.business_name)
        TextView mBusinessName ;
        @ViewInject(id = R.id.AccountName)
        TextView mAccountName ;
        @ViewInject(id = R.id.name)
        TextView mName ;
        @ViewInject(id = R.id.number)
        TextView mNumber ;

        @ViewInject(id = R.id.status)
        TextView mViewStatus ;
        @Override
        public int inflateViewId() {
            return R.layout.list_item_contract_application_business;
        }

        @Override
        public void bindingData(View convertView, AccountInfo data) {
            mBusinessName.setText(data.Name);
            mAccountName.setText(data.AccountName);
            mName.setText(data.OwnerName);
            mNumber.setText(Double.toString(data.EstimatedValue));

            mViewStatus.setText("阶段" + data.Stage);
        }
    }

    public class AccountInfo{
        String OpportunityId;
        String Name;
        String AccountName;
        int Stage;
        String EstimatedCloseDate;
        double EstimatedValue;
        String OwnerName;
        String CreatedOn;
    }
}
