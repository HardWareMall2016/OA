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
import com.android.wandong.beans.EntertainExpenseCreateListResponseBean;
import com.android.wandong.beans.EntertainmentReimbursementCreateDetailContent;
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
 * Created by ${keke} on 16/8/14.
 */
public class EntertainmentReimbursementCreateFragment extends APullToRefreshListFragment<EntertainmentReimbursementCreateFragment.AccountInfo> {

    private int mSelectedPos = -1;

    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, EntertainmentReimbursementCreateFragment.class, null);
    }

    @Override
    protected void setInitPullToRefresh(ListView listView, PullToRefreshListView pullToRefreshListView, Bundle savedInstanceState) {
        super.setInitPullToRefresh(listView, pullToRefreshListView, savedInstanceState);
        listView.setDividerHeight(getListDividerHeight());
        View searchHeader = getActivity().getLayoutInflater().inflate(R.layout.layout_work_search_header, null);
        if (getListDividerHeight() != 0) {
            searchHeader.setPadding(PixelUtils.dp2px(8), PixelUtils.dp2px(0), PixelUtils.dp2px(8), PixelUtils.dp2px(0));
        }
        mPullToRefreshListView.getRefreshableView().addHeaderView(searchHeader);
    }

    public int getListDividerHeight() {
        return 0;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("选择招待费申请");
    }


    @Override
    protected void requestData(RefreshMode mode) {
        if (mode != RefreshMode.update) {
            mSelectedPos = -1;
        }
        HttpRequestParams requestParams = new HttpRequestParams();
        requestParams.put("UserId", UserInfo.getCurrentUser().getUserId());
        requestParams.put("UserName", UserInfo.getCurrentUser().getLoginAccount());
        requestParams.put("PassWord", UserInfo.getCurrentUser().getPassword());
        requestParams.put("PageIndex", getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("AuditStatus", "3");
        requestParams.put("BeginDate", "");
        requestParams.put("CampaignName", "");
        requestParams.put("CostType", "");
        requestParams.put("EndDate", "");
        requestParams.put("IsJustLookOwner", "true");
        requestParams.put("IsRelation", "false");

        startFormRequest(ApiUrls.ENTER_TAIN_EXPENSE, requestParams, new PagingTask<EntertainExpenseCreateListResponseBean>(mode) {
            @Override
            public EntertainExpenseCreateListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, EntertainExpenseCreateListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(EntertainExpenseCreateListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<AccountInfo> parseResult(EntertainExpenseCreateListResponseBean baseResponseBean) {
                List<AccountInfo> items = new ArrayList<>();
                if (baseResponseBean != null && baseResponseBean.getEntityInfo() != null) {
                    for (EntertainExpenseCreateListResponseBean.EntityInfoBean bean : baseResponseBean.getEntityInfo()) {
                        AccountInfo reportDataItem = new AccountInfo();
                        reportDataItem.Id = bean.getId();
                        reportDataItem.ApplyNo = bean.getApplyNo();
                        reportDataItem.AccountId = bean.getAccountId();
                        reportDataItem.AccountName = bean.getAccountName();
                        reportDataItem.Reason = bean.getReason();
                        reportDataItem.Number = bean.getNumber();
                        reportDataItem.Amount = bean.getAmount();
                        reportDataItem.Status = bean.getStatus();
                        reportDataItem.OwnerId = bean.getOwnerId();
                        reportDataItem.OwnerName = bean.getOwnerName();
                        reportDataItem.CreatedOn = bean.getCreatedOn();
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
        EntertainmentReimbursementCreateDetailContent content = new EntertainmentReimbursementCreateDetailContent();
        content.setId(getAdapterItems().get((int)id).Id);
        content.setApplyNo(getAdapterItems().get((int)id).ApplyNo);
        content.setAccountId(getAdapterItems().get((int)id).AccountId);
        content.setAccountName(getAdapterItems().get((int)id).AccountName);
        content.setReason(getAdapterItems().get((int)id).Reason);
        content.setNumber(getAdapterItems().get((int)id).Number);
        content.setAmount(getAdapterItems().get((int)id).Amount);
        content.setStatus(getAdapterItems().get((int)id).Status);
        content.setOwnerId(getAdapterItems().get((int)id).OwnerId);
        content.setOwnerName(getAdapterItems().get((int)id).OwnerName);
        content.setCreatedOn(getAdapterItems().get((int)id).CreatedOn);
        EntertainmentReimbursementCreateDetailFragment.launch(getActivity(),content);
    }
    @Override
    protected ABaseAdapter.AbstractItemView<AccountInfo> newItemView() {
        return new ItemView();
    }

    private class ItemView extends ABaseAdapter.AbstractItemView<AccountInfo> {
        @ViewInject(id = R.id.ApplyNo)
        TextView mApplyNo;
        @ViewInject(id = R.id.AccountName)
        TextView mAccountName;
        @ViewInject(id = R.id.name)
        TextView mName;
        @ViewInject(id = R.id.number)
        TextView mNumber;
        @ViewInject(id = R.id.headPortrait)
        ImageView mViewHeadPortrait;
        @ViewInject(id = R.id.img_status)
        ImageView mViewStatus;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_market_activity_application;
        }

        @Override
        public void bindingData(View convertView, AccountInfo data) {
            mApplyNo.setText(data.ApplyNo);
            mAccountName.setText(data.AccountName);
            mName.setText(data.OwnerName);
            mNumber.setText(data.Amount + "");
            AuditStatusHelper.setImageViewByStatus(mViewStatus, data.Status);
        }
    }


    public class AccountInfo {
        String Id;
        String ApplyNo;
        String AccountId;
        String AccountName;
        String Reason;
        int Number;
        int Amount;
        int Status;
        String OwnerId;
        String OwnerName;
        String CreatedOn;
    }
}
