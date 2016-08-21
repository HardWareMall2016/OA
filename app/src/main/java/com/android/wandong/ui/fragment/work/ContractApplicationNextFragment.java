package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.ContractContent;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

/**
 * Created by ${keke} on 16/8/16.
 */
public class ContractApplicationNextFragment extends ABaseFragment{
    private final static String ARG_KEY = "contract";

    private static final int REQUEST_CODE_CUSTOMER = 100;
    private static final int REQUEST_CODE_CUSTOMER_MODE = 101;
    private static final int REQUEST_CODE_CUSTOMER_TYPE = 102;

    //views
    @ViewInject(id = R.id.tv_next_price)
    TextView mNextProductBasePrice ;
    @ViewInject(id = R.id.tv_next_Warranty)
    TextView mNextWarranty;
    @ViewInject(id = R.id.et_next_Published_price)
    EditText mEtPublicPrice ;
    @ViewInject(id = R.id.tv_container_next_allocation_price,click = "OnClick")
    TextView mAllocationPrice ;
    @ViewInject(id = R.id.et_next_Training_requirements)
    EditText mEtTrainingReauiments;
    @ViewInject(id = R.id.et_next_Training_cost)
    EditText mNextTraingCost;
    @ViewInject(id = R.id.et_next_Handling_requirements)
    EditText mEtNextHandling ;
    @ViewInject(id = R.id.et_next_Loading_unloading)
    EditText mEtNextLoading ;
    @ViewInject(id = R.id.et_next_Contract_amount)
    EditText mEtContractAmout;
    @ViewInject(id = R.id.et_next_Final_estimate)
    EditText mEtFinalEstimate ;

    @ViewInject(id = R.id.tv_container_next_commission_mode,click = "OnClick")
    TextView mCommissionmode;
    @ViewInject(id = R.id.tv_container_next_shipping_type,click = "OnClick")
    TextView mShippingType ;

    @ViewInject(id = R.id.btn_submit,click = "OnClick")
    Button mSubmit ;

    private ContractContent mContent;

    private String mPaymentAppointmentId;
    private String mTransportModeId;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_container_next;
    }

    public static void launch(FragmentActivity activity, ContractContent content) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, content);
        FragmentContainerActivity.launch(activity, ContractApplicationNextFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContent = savedInstanceState == null ? (ContractContent) getArguments().getSerializable(ARG_KEY) : (ContractContent) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mContent);
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("合同申请");

        mNextProductBasePrice.setText(mContent.getProductBasePrice());
        mEtContractAmout.setText(mContent.getContractAmount());

    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.tv_container_next_allocation_price:
                ContractApplicationNextAllocationListFragment.launchForResult(this, REQUEST_CODE_CUSTOMER);
                break;
            case R.id.tv_container_next_commission_mode:
                ContractApplicationNextCommissionListFragment.launchForResult(this, REQUEST_CODE_CUSTOMER_MODE);
                break;
            case R.id.tv_container_next_shipping_type:
                ContractApplicationNextShippingListFragment.launchForResult(this, REQUEST_CODE_CUSTOMER_TYPE);
                break;
            case R.id.btn_submit:
                if (!checkInput()) {
                    return;
                }
                Commit();
                break;
        }
    }

    private void Commit(){
        HttpRequestParams requestParams = new HttpRequestParams();
        requestParams.put("AccountName",mContent.getAccountName());
        requestParams.put("AmortizedMode","0");
        requestParams.put("BuyerName",mContent.getBuyerName());
        requestParams.put("CapitalOccupyPrincipal","");
        requestParams.put("CommissionEstimateAmount","");
        requestParams.put("CommissionMode","1");
        requestParams.put("ConfigurationRequire","1");
        requestParams.put("ContractAmount",mContent.getContractAmount());
        requestParams.put("ContractName",mContent.getContractName());
        requestParams.put("ContractTotal",mContent.getContractAmount());
        requestParams.put("DeliveryAppointment",mContent.getDeliveryAppointment());
        requestParams.put("DepartId", UserInfo.getCurrentUser().getDepartId());
        requestParams.put("FinalEstimateAmount",mEtFinalEstimate.getText().toString());
        requestParams.put("FreightEstimateAmount","");
        requestParams.put("GuaranteePublishPrice",mEtPublicPrice.getText().toString());
        requestParams.put("HandlingEstimateAmount",mEtNextLoading.getText().toString());
        requestParams.put("HandlingRequirement",mEtNextHandling.getText().toString());
        requestParams.put("Interest","");
        requestParams.put("MoneyBelonger",mContent.getMoneyBelonger());
        requestParams.put("OpportunityId",mContent.getOpportunityId());
        requestParams.put("Options","");
        requestParams.put("OptionsPublishPrice","");
        requestParams.put("PassWord",UserInfo.getCurrentUser().getPassword());
        requestParams.put("PaymentAppointment",mPaymentAppointmentId);
        requestParams.put("ProductBasePrice",mNextProductBasePrice.getText().toString());
        requestParams.put("ProductClassifyId",mContent.getProductClassifyId());
        requestParams.put("ProductId",mContent.getProductId());
        requestParams.put("PurchasingParts","");
        requestParams.put("PurchasingPublishPrice","");
        requestParams.put("Quantity",mContent.getQuantity());
        requestParams.put("TaskBelonger",mContent.getTaskBelonger());
        requestParams.put("TrainRequirement",mEtTrainingReauiments.getText().toString());
        requestParams.put("TrainingEstimateAmount",mNextTraingCost.getText().toString());
        requestParams.put("TransportMode", mTransportModeId);
        requestParams.put("Unit",mContent.getUnit());
        requestParams.put("UserName",UserInfo.getCurrentUser().getUserName());
        requestParams.put("UserSite",mContent.getUserSite());
        requestParams.put("Warranty", mNextWarranty.getText().toString());

        startFormRequest(ApiUrls.CONTRACT_APPLY_ADD, requestParams, new HttpRequestHandler(this) {
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                switch (resultCode) {
                    case success:
                        BaseResponseBean responseBean = Tools.parseJsonTostError(result, BaseResponseBean.class);
                        if (responseBean != null) {
                            ToastUtils.toast(responseBean.getMsg());
                            getActivity().finish();
                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                        break;
                }
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    private boolean checkInput() {

        if("请选择佣金方式".equals(mCommissionmode.getText().toString())){
            ToastUtils.toast("请选择佣金方式");
            return false;
        }

        if (TextUtils.isEmpty(mNextWarranty.getText().toString())) {
            ToastUtils.toast("请填写质保期");
            return false;
        }

        if(TextUtils.isEmpty(mEtPublicPrice.getText().toString())){
            ToastUtils.toast("请填写保修公布价格");
            return false;
        }

        if("请选择配送方式".equals(mShippingType.getText().toString())){
            ToastUtils.toast("请选择配送方式");
            return false;
        }

        if(TextUtils.isEmpty(mEtContractAmout.getText().toString())){
            ToastUtils.toast("请填写合同金额");
            return false;
        }

        if(TextUtils.isEmpty(mEtFinalEstimate.getText().toString())){
            ToastUtils.toast("请填写最终预估金额");
            return false;
        }

        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CUSTOMER && resultCode == Activity.RESULT_OK) {
            mAllocationPrice.setText(data.getStringExtra(ContractApplicationNextAllocationListFragment.KEY_ACCOUNT_NAME));
            mAllocationPrice.setTextColor(0xff333333);
        }

        if (requestCode == REQUEST_CODE_CUSTOMER_MODE && resultCode == Activity.RESULT_OK) {
            mCommissionmode.setText(data.getStringExtra(ContractApplicationNextCommissionListFragment.KEY_COMMISSION_NAME));
            mCommissionmode.setTextColor(0xff333333);
            mPaymentAppointmentId = data.getStringExtra(ContractApplicationNextCommissionListFragment.KEY_ACCOUNT_ID);
        }

        if (requestCode == REQUEST_CODE_CUSTOMER_TYPE && resultCode == Activity.RESULT_OK) {
            mShippingType.setText(data.getStringExtra(ContractApplicationNextShippingListFragment.KEY_ACCOUNT_SHIPPINGNAME));
            mShippingType.setTextColor(0xff333333);
            mTransportModeId = data.getStringExtra(ContractApplicationNextShippingListFragment.KEY_ACCOUNT_ID);
        }
    }

}
