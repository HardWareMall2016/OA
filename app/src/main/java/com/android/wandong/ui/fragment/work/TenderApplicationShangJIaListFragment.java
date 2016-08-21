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
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.ContractProductModelListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhan.framework.component.container.FragmentArgs;
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
 * Created by ${keke} on 16/8/21.
 */
public class TenderApplicationShangJIaListFragment extends APullToRefreshListFragment<TenderApplicationShangJIaListFragment.AccountInfo> {
    private final static String ARG_KEY = "shangjia";
    public static String KEY_BIDPRODUCT_NAME="bidproduct_name";
    public static String KEY_BIDPRODUCT_ID="bidproduct_id";
    private int mSelectedPos=-1;

    private String mCustomerId ;

    public static void launchForResult(TenderApplicationCreateFragment from, int requestCode, String mCustomerId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, mCustomerId);
        FragmentContainerActivity.launchForResult(from, TenderApplicationShangJIaListFragment.class, args, requestCode);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCustomerId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mCustomerId);
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
            ToastUtils.toast("请选择商机");
            return;
        }

        AccountInfo accountInfo=getAdapterItems().get(mSelectedPos);

        Intent intent=new Intent();
        intent.putExtra(KEY_BIDPRODUCT_NAME,accountInfo.Name);
        intent.putExtra(KEY_BIDPRODUCT_ID, accountInfo.Id);
        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("选择商机");
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

        /*HttpRequestParams requestParams = new HttpRequestParams();
        requestParams.put("UserName", UserInfo.getCurrentUser().getUserName());
        requestParams.put("PassWord", UserInfo.getCurrentUser().getPassword());
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("ProductClassifyId",mProductId);

        startFormRequest(ApiUrls.OPPORTUNITY_GETPRODUCT, requestParams, new PagingTask<ContractProductModelListResponseBean>(mode) {
            @Override
            public ContractProductModelListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, ContractProductModelListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(ContractProductModelListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<AccountInfo> parseResult(ContractProductModelListResponseBean baseResponseBean) {
                List<AccountInfo> items = new ArrayList<>();
                if (baseResponseBean != null && baseResponseBean.getEntityInfo() != null) {
                    for (ContractProductModelListResponseBean.EntityInfoBean bean : baseResponseBean.getEntityInfo()) {
                        AccountInfo reportDataItem = new AccountInfo();
                        reportDataItem.Id = bean.getId();
                        reportDataItem.Name = bean.getName();
                        reportDataItem.Price = bean.getPrice();
                        items.add(reportDataItem);
                    }
                }
                return items;
            }
        }, HttpRequestUtils.RequestType.POST);*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mSelectedPos!=id){
            mSelectedPos= (int) id;
            notifyDataSetChanged();
        }
    }


    public class AccountInfo{
        String Id;
        String Name;
        int Price;
    }
}
