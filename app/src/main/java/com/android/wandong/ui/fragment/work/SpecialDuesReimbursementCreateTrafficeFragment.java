package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.CostTypeListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * * 作者：keke on 2016/8/20 16:00
 */
public class SpecialDuesReimbursementCreateTrafficeFragment extends APullToRefreshListFragment<SpecialDuesReimbursementCreateTrafficeFragment.AccountInfo> {

    private int mSelectedPos=-1;
    public static String KEY_ACCOUNT_NAME = "account_name";
    public static String KEY_ACCOUNT_ID = "account_id";

    public static void launchForResult(SpecialDuesReimbursementCreateFragment from, int requestCode) {
        FragmentContainerActivity.launchForResult(from, SpecialDuesReimbursementCreateTrafficeFragment.class, null, requestCode);
    }

    @Override
    public void onPrepareActionbarMenu(TextView menu, Activity activity) {
        menu.setText("确定");
    }

    @Override
    public void onActionBarMenuClick() {
        if(mSelectedPos==-1){
            ToastUtils.toast("请选择费用类型");
            return;
        }

        AccountInfo accountInfo=getAdapterItems().get(mSelectedPos);

        Intent intent=new Intent();
        intent.putExtra(KEY_ACCOUNT_NAME,accountInfo.Name);
        intent.putExtra(KEY_ACCOUNT_ID, accountInfo.Value);
        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("费用类型");
        mSelectedPos=-1;
    }

    @Override
    protected void configRefresh(RefreshConfig config) {
        config.minResultSize=20;
    }


    @Override
    protected ABaseAdapter.AbstractItemView<SpecialDuesReimbursementCreateTrafficeFragment.AccountInfo> newItemView() {
        return new ItemView();
    }

    @Override
    protected void requestData(RefreshMode mode) {

        if(mode!=RefreshMode.update){
            mSelectedPos=-1;
        }
        HttpRequestParams requestParams = new HttpRequestParams();
        requestParams.put("AttributeName", "new_costtype");
        requestParams.put("EntityName", "new_campaign");

        startFormRequest(ApiUrls.COMMON_GETOPTION_VALUE, requestParams, new PagingTask<CostTypeListResponseBean>(mode) {
            @Override
            public CostTypeListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, CostTypeListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(CostTypeListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<AccountInfo> parseResult(CostTypeListResponseBean baseResponseBean) {
                List<AccountInfo> items=new ArrayList<>();
                if(baseResponseBean!=null&&baseResponseBean.getEntityInfo()!=null){
                    for (CostTypeListResponseBean.EntityInfoBean bean: baseResponseBean.getEntityInfo()) {
                        AccountInfo reportDataItem = new AccountInfo();
                        reportDataItem.Value=bean.getValue();
                        reportDataItem.Name=bean.getName();
                        items.add(reportDataItem);
                    }
                }
                return items;
            }
        }, HttpRequestUtils.RequestType.POST);
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
            Tools.setTextView(mViewAccountName,data.Name);
            if(mSelectedPos==getPosition()){
                mViewStatus.setImageResource(R.drawable.checkbox_sel);
            }else{
                mViewStatus.setImageResource(R.drawable.checkbox_unsel);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mSelectedPos!=id){
            mSelectedPos= (int) id;
            notifyDataSetChanged();
        }
    }
    public class AccountInfo{
        private String Name;
        private String Value;
    }
}
