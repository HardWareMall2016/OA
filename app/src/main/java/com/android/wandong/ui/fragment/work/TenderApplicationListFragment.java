package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.AccountListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;
import com.zhan.framework.utils.PixelUtils;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${keke} on 16/8/13.
 */
public class TenderApplicationListFragment extends APullToRefreshListFragment<TenderApplicationListFragment.AccountInfo> {

    public static String KEY_ACCOUNT_NAME="account_name";
    public static String KEY_ACCOUNT_ID="account_id";
    private int mSelectedPos=-1;

    public static void launchForResult(TenderApplicationCreateFragment from, int requestCode) {
        FragmentContainerActivity.launchForResult(from, InspectionReceptionListFragment.class, null, requestCode);
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
    public void onPrepareActionbarMenu(TextView menu, Activity activity) {
        menu.setText("确定");
    }

    @Override
    public void onActionBarMenuClick() {
        if(mSelectedPos==-1){
            ToastUtils.toast("请选择客户");
            return;
        }

        AccountInfo accountInfo=getAdapterItems().get(mSelectedPos);

        Intent intent=new Intent();
        intent.putExtra(KEY_ACCOUNT_NAME,accountInfo.Name);
        intent.putExtra(KEY_ACCOUNT_ID, accountInfo.AccountId);
        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("客户列表");
        mSelectedPos=-1;
    }

    @Override
    protected void configRefresh(RefreshConfig config) {
        config.minResultSize=20;
    }

    @Override
    protected ABaseAdapter.AbstractItemView<AccountInfo> newItemView() {
        return new ItemView();
    }

    private class ItemView extends ABaseAdapter.AbstractItemView<AccountInfo>{
        @ViewInject(id = R.id.AccountName)
        TextView mViewAccountName ;

        @ViewInject(id = R.id.imgStatus)
        ImageView mViewStatus ;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_account;
        }

        @Override
        public void bindingData(View convertView, AccountInfo data) {
            Tools.setTextView(mViewAccountName, data.Name);
            if(mSelectedPos==getPosition()){
                mViewStatus.setImageResource(R.drawable.checkbox_sel);
            }else{
                mViewStatus.setImageResource(R.drawable.checkbox_unsel);
            }
        }
    }


    @Override
    protected void requestData(RefreshMode mode) {

        if(mode!=RefreshMode.update){
            mSelectedPos=-1;
        }

        HttpRequestParams requestParams= Tools.createHttpRequestParams();
        requestParams.put("PageIndex", getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);

        startFormRequest(ApiUrls.ACCOUNT_LIST, requestParams, new PagingTask<AccountListResponseBean>(mode) {
            @Override
            public AccountListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, AccountListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(AccountListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<AccountInfo> parseResult(AccountListResponseBean baseResponseBean) {
                List<AccountInfo> items = new ArrayList<>();
                if (baseResponseBean != null && baseResponseBean.getEntityInfo() != null && baseResponseBean.getEntityInfo().getList() != null) {
                    for (AccountListResponseBean.EntityInfoBean.ListBean bean : baseResponseBean.getEntityInfo().getList()) {
                        AccountInfo reportDataItem = new AccountInfo();
                        reportDataItem.AccountId = bean.getAccountId();
                        reportDataItem.Name = bean.getName();
                        reportDataItem.OwnerId = bean.getOwnerId();
                        reportDataItem.OwnerName = bean.getOwnerName();
                        reportDataItem.Level = bean.getLevel();
                        reportDataItem.Longitude = bean.getLongitude();
                        reportDataItem.Latitude = bean.getLatitude();
                        reportDataItem.Type = bean.getType();
                        reportDataItem.CreatedOn = bean.getCreatedOn();
                        reportDataItem.ContractNumber = bean.getContractNumber();
                        reportDataItem.OpportunityNumber = bean.getOpportunityNumber();
                        items.add(reportDataItem);
                    }
                }
                return items;
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mSelectedPos!=id){
            mSelectedPos= (int) id;
            notifyDataSetChanged();
        }
    }


    public class AccountInfo{
        String AccountId;
        String Name;
        String OwnerId;
        String OwnerName;
        int Level;
        double Longitude;
        double Latitude;
        int Type;
        String CreatedOn;
        int ContractNumber;
        int OpportunityNumber;
    }
}
