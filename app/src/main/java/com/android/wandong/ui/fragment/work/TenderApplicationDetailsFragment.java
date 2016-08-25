package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.TenderApplicationDetailsResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.work.Tools.AuditStatusHelper;
import com.android.wandong.ui.widget.FixListView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.ui.widget.CircleImageView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by ${keke} on 16/8/7.
 */
public class TenderApplicationDetailsFragment extends ABaseFragment {
    private final static String ARG_KEY = "tender_application_key";

    @ViewInject(id = R.id.ApplyNo)
    TextView mViewApplyNo;//申请单号
    @ViewInject(id = R.id.AccountName)
    TextView mViewAccountName;//客户名称
    @ViewInject(id = R.id.OwnerName)
    TextView mViewOwnerName;//创建人名称
    @ViewInject(id = R.id.money)
    TextView mViewmoneyr;//招待费
    @ViewInject(id = R.id.time)
    TextView mViewTime;//时间
    @ViewInject(id = R.id.img_status)
    ImageView mViewStatus;//审批状态
    @ViewInject(id = R.id.listViewApproval)
    FixListView mListViewApproval;

    @ViewInject(id = R.id.indicator)
    ImageView mImgIndicator;

    @ViewInject(id = R.id.names)
    TextView mName ;
    @ViewInject(id = R.id.address)
    TextView mAddress ;
    @ViewInject(id = R.id.product_line)
    TextView mProductLine ;
    @ViewInject(id = R.id.zhaobiao_product)
    TextView mZhaobiaoProduct;
    @ViewInject(id = R.id.open_time)
    TextView mOpenTime ;
    @ViewInject(id = R.id.daili_company)
    TextView mDailiCompany;
    @ViewInject(id = R.id.network)
    TextView mNetWork ;
    @ViewInject(id = R.id.copmany_name)
    TextView mCopmanyName ;
    @ViewInject(id = R.id.tv_Remark)
    TextView mTvRemark;


    @ViewInject(id = R.id.ApprovalInformation, click = "OnClick")
    private View mViewApprovalInformation;//审批信息

    private String mCampaignId ;
    private DecimalFormat mMoneyFormat = new DecimalFormat();
    private Handler mHandler=new Handler();

    @Override
    protected int inflateContentView() {
        return R.layout.frag_tender_application_details;
    }

    public static void launch(FragmentActivity activity, String campaignId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, campaignId);
        FragmentContainerActivity.launch(activity, TenderApplicationDetailsFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCampaignId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mCampaignId);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("招投标申请详情");
        mMoneyFormat.applyPattern("###,##0.00元");
    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("TenderAuthorizationId", mCampaignId);
        startFormRequest(ApiUrls.TENDER_AUTHORIZATION_APPLY_DETAIL, requestParams, new BaseHttpRequestTask<TenderApplicationDetailsResponseBean>() {
            @Override
            public TenderApplicationDetailsResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, TenderApplicationDetailsResponseBean.class);
            }

            @Override
            public String verifyResponseResult(TenderApplicationDetailsResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(TenderApplicationDetailsResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了
                if (result != null && result.getEntityInfo() != null) {
                    populateView(result);
                }

            }

        }, HttpRequestUtils.RequestType.POST);
    }

    private void populateView(TenderApplicationDetailsResponseBean result) {
        if (result.getEntityInfo().getDetail() != null) {
            Tools.setTextView(mViewApplyNo, result.getEntityInfo().getDetail().getName());
            Tools.setTextView(mViewAccountName, result.getEntityInfo().getDetail().getProjectName()+"  "+result.getEntityInfo().getDetail().getNumber());
            Tools.setTextView(mViewOwnerName, result.getEntityInfo().getDetail().getOwnerName());
            Tools.setTextView(mViewmoneyr, result.getEntityInfo().getDetail().getQuantity()+"台");
            //Tools.setTextView(mViewTime, );
            AuditStatusHelper.setImageViewByStatus(mViewStatus, result.getEntityInfo().getDetail().getAuditStatus());
            Tools.setTextView(mName, result.getEntityInfo().getDetail().getAccountName());
            Tools.setTextView(mAddress, result.getEntityInfo().getDetail().getProvince()+" "+result.getEntityInfo().getDetail().getCity());
            Tools.setTextView(mProductLine, result.getEntityInfo().getDetail().getProductClassifyName());
            Tools.setTextView(mZhaobiaoProduct, result.getEntityInfo().getDetail().getProductName());
            //Tools.setTextView(mOpenTime, result.getEntityInfo().getDetail().getProductClassifyName());
            Tools.setTextView(mDailiCompany, result.getEntityInfo().getDetail().getTenderAgency());
            Tools.setTextView(mNetWork, result.getEntityInfo().getDetail().getWebsite());
            Tools.setTextView(mCopmanyName, result.getEntityInfo().getDetail().getEmpoweredName());
            if(result.getEntityInfo().getDetail().getRemark() != null){
                mTvRemark.setVisibility(View.VISIBLE);
                Tools.setTextView(mTvRemark, result.getEntityInfo().getDetail().getRemark());
            }else{
                mTvRemark.setVisibility(View.GONE);
            }

        }

        ArrayList<ApprovalItem> approvalItems = new ArrayList<>();
        if(result.getEntityInfo().getApproval() != null){
            for (TenderApplicationDetailsResponseBean.EntityInfoBean.ApprovalBean bean : result.getEntityInfo().getApproval()) {
                ApprovalItem item = new ApprovalItem();
                item.StepNumber = bean.getStepNumber();
                item.ApprovalTime = bean.getApprovalTime();
                item.ApprovalPrice = bean.getApprovalPrice();
                item.Opinion = bean.getOpinion();
                item.Result = bean.getResult();
                item.ApproverId = bean.getApproverId();
                item.Approver = bean.getApprover();
                approvalItems.add(item);
            }
        }
        mListViewApproval.setAdapter(new ApprovalAdapter(approvalItems, getActivity()));
    }

    void OnClick(View v) {
        switch (v.getId()){
            case R.id.ApprovalInformation:
                if (mListViewApproval.getVisibility() == View.GONE) {
                    mListViewApproval.setVisibility(View.VISIBLE);
                    mImgIndicator.setImageResource(R.drawable.icon_yellow_up);

                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //滚动到底部
                            ScrollView scrollView = (ScrollView) contentLayout;
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    }, 50);

                } else {
                    mListViewApproval.setVisibility(View.GONE);
                    mImgIndicator.setImageResource(R.drawable.icon_yellow_down);
                }
                break;
        }
    }
    private class ApprovalItem{
        String StepNumber;
        String ApprovalTime;
        double ApprovalPrice;
        String Opinion;
        String Result;
        String ApproverId;
        String Approver;
    }

    private class ApprovalAdapter extends ABaseAdapter<ApprovalItem> {

        public ApprovalAdapter(ArrayList<ApprovalItem> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<ApprovalItem> newItemView() {
            return new ApprovalItemView();
        }
    }

    private class ApprovalItemView extends ABaseAdapter.AbstractItemView<ApprovalItem> {
        @ViewInject(id = R.id.headPortrait)
        private CircleImageView headPortrait;

        @ViewInject(id = R.id.name)
        private TextView name;

        @ViewInject(id = R.id.result)
        private TextView result;

        @ViewInject(id = R.id.opinion)
        private TextView opinion;

        @ViewInject(id = R.id.time)
        private TextView time;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_approval;
        }

        @Override
        public void bindingData(View convertView, ApprovalItem data) {
            //ImageLoader.getInstance().displayImage(data.ApprovalTime, headPortrait, Tools.buildDisplayImageOptionsForAvatar());

            Tools.setTextView(name, data.Approver);
            Tools.setTextView(result, data.Result);
            Tools.setTextView(opinion, data.Opinion);
            Tools.setTextView(time, data.ApprovalTime);

        }
    }
}
