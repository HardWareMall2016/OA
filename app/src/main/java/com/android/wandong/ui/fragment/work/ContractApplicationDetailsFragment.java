package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.ContractApplicationDetailContent;
import com.android.wandong.beans.ContractApplicationDetailsResponseBean;
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

import java.util.ArrayList;

/**
 * Created by ${keke} on 16/8/28.
 */
public class ContractApplicationDetailsFragment extends ABaseFragment {
    private final static String ARG_KEY = "contract_detail";

    @ViewInject(id = R.id.ApplyNo)
    TextView mApplyNo ;
    @ViewInject(id = R.id.AccountName)
    TextView mAccountName;
    @ViewInject(id = R.id.create_on)
    TextView mCreateOn ;
    @ViewInject(id = R.id.Status)
    TextView mStatus;
    @ViewInject(id = R.id.OwnerName)
    TextView mOwnerName;
    @ViewInject(id = R.id.money)
    TextView money;
    @ViewInject(id = R.id.time)
    TextView mViewTime;
    @ViewInject(id = R.id.img_status)
    ImageView mViewStatus;

    @ViewInject(id = R.id.tv_base_message,click = "OnClick")
    TextView mTVBaseMessage;
    @ViewInject(id = R.id.tv_Business_agreement,click = "OnClick")
    TextView mTvAgreeMent;
    @ViewInject(id = R.id.tv_implement_message,click = "OnClick")
    TextView mTvImplementMsg;

    //view1
    @ViewInject(id = R.id.tv_contract_name)
    TextView mTvContractName;
    @ViewInject(id = R.id.tv_unit_name)
    TextView mTvUnitName;
    @ViewInject(id = R.id.tv_user_address)
    TextView mTvAddress;
    @ViewInject(id = R.id.tv_task_people)
    TextView mTvTaskPeople;
    @ViewInject(id = R.id.tv_bonus_people)
    TextView mTvBonusPeople;
    @ViewInject(id = R.id.tv_buyer_name)
    TextView mTvBuyerName;
    @ViewInject(id = R.id.customer_people)
    TextView mTvCustomer ;
    @ViewInject(id = R.id.tv_product_line)
    TextView mTvProductLine;
    @ViewInject(id = R.id.tv_product_type)
    TextView mTvProductType;
    @ViewInject(id = R.id.tv_ContracTotal)
    TextView mTvContracTotal;
    @ViewInject(id = R.id.tv_Quantity)
    TextView mTvQuantity;
    @ViewInject(id = R.id.tv_Payment_agreement)
    TextView mTvPaymentAgreement;
    @ViewInject(id = R.id.tv_Configuration)
    TextView mTvConfiguration;
    @ViewInject(id = R.id.tv_base_price)
    TextView mTvBasePrice;
    @ViewInject(id = R.id.tv_CommissionModeName)
    TextView mTvCommissionModeName;
    @ViewInject(id = R.id.tv_CommissionEstimateAmount)
    TextView mTvCommissionEstimateAmount;
    @ViewInject(id = R.id.tv_Warranty)
    TextView mTvWarranty;
    @ViewInject(id = R.id.tv_GuaranteePublishPrice)
    TextView mTvGuaranteePublishPrice;
    @ViewInject(id = R.id.tv_TransportModeName)
    TextView mTvTransportModeName;
    @ViewInject(id = R.id.tv_CapitalOccupyPrincipal)
    TextView mTvCapitalOccupyPrincipal;
    @ViewInject(id = R.id.tv_AmortizedModeName)
    TextView mTvAmortizedModeName;
    @ViewInject(id = R.id.tv_Interest)
    TextView mTvInterest;
    @ViewInject(id = R.id.tva_ContracTotal)
    TextView mTvaContracTotal;
    @ViewInject(id = R.id.tv_FinalEstimateAmount)
    TextView mTvFinalEstimateAmount;


    @ViewInject(id = R.id.Tv_ERP_ContractNo)
    TextView mTvERPContractNo;

    @ViewInject(id = R.id.ll_1)
    LinearLayout mLl1;
    @ViewInject(id = R.id.ll_2)
    LinearLayout mLl2;
    @ViewInject(id = R.id.ll_3)
    LinearLayout mLl3;

    @ViewInject(id = R.id.listViewApproval)
    FixListView mListViewApproval;
    @ViewInject(id = R.id.indicator)
    ImageView mImgIndicator;
    @ViewInject(id = R.id.ApprovalInformation, click = "OnClick")
    View mViewApprovalInformation;//审批信息


    private ContractApplicationDetailContent content ;

    private Handler mHandler=new Handler();

    @Override
    protected int inflateContentView() {
        return R.layout.frag_contract_application_details;
    }

    public static void launch(FragmentActivity activity, ContractApplicationDetailContent content) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, content);
        FragmentContainerActivity.launch(activity, ContractApplicationDetailsFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        content = savedInstanceState == null ? (ContractApplicationDetailContent) getArguments().getSerializable(ARG_KEY) : (ContractApplicationDetailContent) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, content);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("合同申请详情");

        mApplyNo.setText(content.getApplyNo());
        mAccountName.setText(content.getContractName());
        Tools.setTextView(mCreateOn, "创建时间：" + Tools.parseTimeToDateStr(Tools.parseDateStrToLong(content.getCreatedOn())));

        if(content.getStatus() == 3){
            mStatus.setText("执行状态：已批准");
        }else if(content.getStatus() == 2){
            mStatus.setText("执行状态：待审批");
        }else if(content.getStatus() == 4){
            mStatus.setText("执行状态：驳回");
        }else{
            mStatus.setText("执行状态：签订");
        }

        AuditStatusHelper.setImageViewByStatus(mViewStatus, content.getStatus());

        Tools.setTextView(mViewTime, Tools.parseTimeToDateStr(Tools.parseDateStrToLong(content.getCreatedOn())));
        mOwnerName.setText(content.getOwnerName());
        money.setText(content.getContracTotal()+"元");
    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("ContractId", content.getContractId());
        startFormRequest(ApiUrls.CONTRACT_APPLY_DETAIL, requestParams, new BaseHttpRequestTask<ContractApplicationDetailsResponseBean>() {
            @Override
            public ContractApplicationDetailsResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, ContractApplicationDetailsResponseBean.class);
            }

            @Override
            public String verifyResponseResult(ContractApplicationDetailsResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(ContractApplicationDetailsResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了
                if (result != null && result.getEntityInfo() != null) {
                    populateView(result);
                }

            }
        }, HttpRequestUtils.RequestType.POST);
    }

    private void populateView(ContractApplicationDetailsResponseBean result) {
        if(result.getEntityInfo().getDetail() != null){
            mTvContractName.setText("合同名称:"+result.getEntityInfo().getDetail().getContractName());
            mTvUnitName.setText("所属单元:"+result.getEntityInfo().getDetail().getUnit());
            mTvAddress.setText("用户所在地:"+result.getEntityInfo().getDetail().getUserSite());
            mTvTaskPeople.setText("任务归属人:"+result.getEntityInfo().getDetail().getTaskBelonger());
            mTvBonusPeople.setText("奖金归属人:"+result.getEntityInfo().getDetail().getMoneyBelonger());
            mTvBuyerName.setText("买方名称:"+result.getEntityInfo().getDetail().getBuyerName());
            mTvCustomer.setText("客户名称:"+result.getEntityInfo().getDetail().getAccountName());
            mTvProductLine.setText("产品线:"+result.getEntityInfo().getDetail().getProductClassifyName());
            mTvProductType.setText("产品型号:"+result.getEntityInfo().getDetail().getProductName());
            mTvContracTotal.setText("合同总价:"+result.getEntityInfo().getDetail().getContracTotal()+"");
            mTvQuantity.setText("销售数量:"+result.getEntityInfo().getDetail().getQuantity()+"");
            mTvPaymentAgreement.setText("付款约定:"+result.getEntityInfo().getDetail().getPaymentMode());

            mTvConfiguration.setText("配置要求:"+result.getEntityInfo().getDetail().getConfigurationRequireName());
            mTvBasePrice.setText("产品基价:"+result.getEntityInfo().getDetail().getProductBasePrice());
            mTvCommissionModeName.setText("佣金方式:"+result.getEntityInfo().getDetail().getCommissionModeName());
            mTvCommissionEstimateAmount.setText("佣金预估金额:"+result.getEntityInfo().getDetail().getCommissionEstimateAmount());
            mTvWarranty.setText("质保期:"+result.getEntityInfo().getDetail().getWarranty());
            mTvGuaranteePublishPrice.setText("保修公布价格:"+result.getEntityInfo().getDetail().getGuaranteePublishPrice());
            mTvTransportModeName.setText("运输方式:"+result.getEntityInfo().getDetail().getTransportModeName());
            mTvCapitalOccupyPrincipal.setText("资金占用本金:"+result.getEntityInfo().getDetail().getCapitalOccupyPrincipal());
            mTvAmortizedModeName.setText("分期方式:"+result.getEntityInfo().getDetail().getAmortizedModeName());
            mTvInterest.setText("资金占用计算:"+result.getEntityInfo().getDetail().getInterest());
            mTvaContracTotal.setText("合同金额:"+result.getEntityInfo().getDetail().getContracTotal()+"");
            mTvFinalEstimateAmount.setText("最终预估金额:"+result.getEntityInfo().getDetail().getFinalEstimateAmount()+"");


            mTvERPContractNo.setText("合同编号:"+result.getEntityInfo().getDetail().getERP_ContractNo());

            ArrayList<ApprovalItem> approvalItems = new ArrayList<>();
            if (result.getEntityInfo().getApproval() != null) {
                for (ContractApplicationDetailsResponseBean.EntityInfoBean.ApprovalBean bean : result.getEntityInfo().getApproval()) {
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
            Tools.setTextView(name, data.Approver);
            Tools.setTextView(result, data.Result);
            Tools.setTextView(opinion, data.Opinion);
            Tools.setTextView(time, data.ApprovalTime);

        }
    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.tv_base_message:
                mTVBaseMessage.setTextColor(Color.parseColor("#FFFF0000"));
                mTvAgreeMent.setTextColor(Color.parseColor("#999999"));
                mTvImplementMsg.setTextColor(Color.parseColor("#999999"));
                mLl1.setVisibility(View.VISIBLE);
                mLl2.setVisibility(View.GONE);
                mLl3.setVisibility(View.GONE);
                break;
            case R.id.tv_Business_agreement:
                mTvAgreeMent.setTextColor(Color.parseColor("#FFFF0000"));
                mTVBaseMessage.setTextColor(Color.parseColor("#999999"));
                mTvImplementMsg.setTextColor(Color.parseColor("#999999"));
                mLl2.setVisibility(View.VISIBLE);
                mLl1.setVisibility(View.GONE);
                mLl3.setVisibility(View.GONE);
                break;
            case R.id.tv_implement_message:
                mTvImplementMsg.setTextColor(Color.parseColor("#FFFF0000"));
                mTvAgreeMent.setTextColor(Color.parseColor("#999999"));
                mTVBaseMessage.setTextColor(Color.parseColor("#999999"));
                mLl3.setVisibility(View.VISIBLE);
                mLl1.setVisibility(View.GONE);
                mLl2.setVisibility(View.GONE);
                break;
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


}
