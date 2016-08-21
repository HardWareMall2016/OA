package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.ContractApplicationCreateResponseBean;
import com.android.wandong.beans.ReimburseCreateTwoContent;
import com.android.wandong.beans.WorkReportReplyListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;

/**
 * Created by ${keke} on 16/8/16.
 */
public class ContractApplicationCreateFragment extends ABaseFragment{
    private final static String ARG_KEY = "contract_create";

    private static final int REQUEST_CODE_ONE = 100;
    private static final int REQUEST_CODE_TWO = 101;
    private static final int REQUEST_CODE_THREE = 102;

    //views
    @ViewInject(id = R.id.et_contract_name)
    EditText mEtContractName ;
    @ViewInject(id = R.id.tv_contract_unitname)
    TextView mTvContractUnitName;
    @ViewInject(id = R.id.et_contract_address)
    EditText mEtContractAddress;
    @ViewInject(id = R.id.et_contract_task)
    EditText mEtContractTask;
    @ViewInject(id = R.id.et_contract_bonus)
    EditText mEtContractBonus ;
    @ViewInject(id = R.id.et_contract_buyer_name)
    EditText mEtBuyerName;
    @ViewInject(id = R.id.et_contract_customer_name)
    EditText mEtCustorName ;
    @ViewInject(id = R.id.tv_container_product_line,click = "OnClick")
    TextView mProductLine ;
    @ViewInject(id = R.id.tv_container_product_model,click = "OnClick")
    TextView mProductModel;
    @ViewInject(id = R.id.tv_container_payment_method,click = "OnClick")
    TextView mPayMentMethod;
    @ViewInject(id = R.id.ed_contract_price)
    EditText mEtPrice ;
    @ViewInject(id = R.id.et_contract_sale_number)
    EditText mEtSaleNumber;
    @ViewInject(id = R.id.et_contract_delivery)
    EditText mEtDelivery;

    @ViewInject(id = R.id.btn_submit_next,click = "OnClick")
    Button mSubmitNext;

    private String opportunityId ;

    private String mContractName;
    private String mContractAddress;
    private String mContractTask;
    private String mContractBonus ;
    private String mContractBuyerName;
    private String mCustomerName;
    private String mPrice;
    private String mSaleNumber;
    private String mContractDelivery;

    public static void launch(Activity mActivity, String opportunityId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, opportunityId);
        FragmentContainerActivity.launch(mActivity, ContractApplicationCreateFragment.class, args);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        opportunityId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, opportunityId);
    }


    @Override
    protected int inflateContentView() {
        return R.layout.frag_container_create;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("合同申请");

    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = new HttpRequestParams();
        requestParams.put("UserName", UserInfo.getCurrentUser().getUserName());
        requestParams.put("PassWord", UserInfo.getCurrentUser().getPassword());
        requestParams.put("OpportunityId", opportunityId);

        startFormRequest(ApiUrls.OPPPRTUNITY_DETAIL, requestParams, new BaseHttpRequestTask<ContractApplicationCreateResponseBean>() {
            @Override
            public ContractApplicationCreateResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, ContractApplicationCreateResponseBean.class);
            }

            @Override
            public String verifyResponseResult(ContractApplicationCreateResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(ContractApplicationCreateResponseBean result) {
                super.onSuccess(result);
                if (result != null && result.getEntityInfo() != null) {
                    mEtCustorName.setText(result.getEntityInfo().getAccountName());

                    for(ContractApplicationCreateResponseBean.EntityInfoBean.OpportunityProductItemBean itemBean : result.getEntityInfo().getOpportunityProductItem()){
                        mProductLine.setText(itemBean.getProductClassifyName());
                        mProductModel.setText(itemBean.getName());
                        mEtSaleNumber.setText(itemBean.getQuantity()+"");
                    }
                }

            }
        }, HttpRequestUtils.RequestType.POST);

    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.tv_container_product_line:
                ContractApplicationProductLineListFragment.launchForResult(this, REQUEST_CODE_ONE);
                break;
            case R.id.tv_container_product_model:
                ContractApplicationProductModelListFragment.launchForResult(this, REQUEST_CODE_TWO);
                break;
            case R.id.tv_container_payment_method:
                ContractApplicationPayListFragment.launchForResult(this, REQUEST_CODE_THREE);
                break;
            case R.id.btn_submit_next:
                if (!checkInput()) {
                    return;
                }
                ContractApplicationNextFragment.launch(getActivity());
                break;
        }
    }
    private boolean checkInput() {
        mContractName = mEtContractName.getText().toString();
        mContractAddress = mEtContractAddress.getText().toString();
        mContractTask = mEtContractTask.getText().toString();
        //mContractBonus = mEtContractBonus.getText().toString();
        mContractBuyerName = mEtBuyerName.getText().toString();
        mCustomerName = mEtCustorName.getText().toString();
        mPrice = mEtPrice.getText().toString();
        mSaleNumber = mEtSaleNumber.getText().toString();
        //mContractDelivery = mEtDelivery.getText().toString();


        if (TextUtils.isEmpty(mContractName)) {
            ToastUtils.toast("请填写合同名称");
            return false;
        }

        if (TextUtils.isEmpty(mContractAddress)) {
            ToastUtils.toast("请填写用户所在地");
            return false;
        }

        if (TextUtils.isEmpty(mContractTask)) {
            ToastUtils.toast("请填写任务归属人");
            return false;
        }

        if(TextUtils.isEmpty(mContractBuyerName)){
            ToastUtils.toast("请填写买方名称");
            return false;
        }

        if(TextUtils.isEmpty(mCustomerName)){
            ToastUtils.toast("请填写客户名称");
            return false;
        }

        if(TextUtils.isEmpty(mPrice)){
            ToastUtils.toast("请填写合同总价");
            return false;
        }

        if(TextUtils.isEmpty(mSaleNumber)){
            ToastUtils.toast("请填写销售数量");
            return false;
        }

        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ONE && resultCode == Activity.RESULT_OK) {
            mProductLine.setText(data.getStringExtra(ContractApplicationProductLineListFragment.KEY_ACCOUNT_NAME));
            mProductLine.setTextColor(0xff333333);
        }
        if (requestCode == REQUEST_CODE_TWO && resultCode == Activity.RESULT_OK) {
            mProductModel.setText(data.getStringExtra(ContractApplicationProductModelListFragment.KEY_ACCOUNT_NAME));
            mProductModel.setTextColor(0xff333333);
        }
        if (requestCode == REQUEST_CODE_THREE && resultCode == Activity.RESULT_OK) {
            mPayMentMethod.setText(data.getStringExtra(ContractApplicationPayListFragment.KEY_ACCOUNT_NAME));
            mPayMentMethod.setTextColor(0xff333333);
        }
    }
}
