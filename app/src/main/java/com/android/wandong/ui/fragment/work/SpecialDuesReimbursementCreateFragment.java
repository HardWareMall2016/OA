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
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.MarketActivityCreateRequestBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;

/**
 * Created by ${keke} on 16/8/13.
 */
public class SpecialDuesReimbursementCreateFragment extends ABaseFragment{
    private static final int REQUEST_CODE_CUSTOMER=100;

    @ViewInject(id = R.id.tv_specialdurse_traffice,click = "OnClick")
    TextView mTraffic ;
    @ViewInject(id = R.id.et_specialdurse_reimbursement)
    EditText mEtReimbursement;
    @ViewInject(id = R.id.et_specialdurse_time)
    EditText mEtTime ;
    @ViewInject(id = R.id.remark)
    EditText mEtRemark;
    @ViewInject(id = R.id.btn_commit,click = "OnClick")
    Button mCommit;

    private String mReimburseMent;
    private String mTime ;
    private String mRemark ;
    private String mCustomerId;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_specialdues_reimburse_create;
    }

    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, SpecialDuesReimbursementCreateFragment.class, null);
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("专项费报销");
    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.btn_commit:
                if (!checkInput()) {
                    return;
                }

                Commit();
                break;
            case R.id.tv_specialdurse_traffice:
                SpecialDuesReimbursementCreateTrafficeFragment.launchForResult(this, REQUEST_CODE_CUSTOMER);
                break;
        }
    }

    private boolean checkInput() {
        mReimburseMent = mEtReimbursement.getText().toString();
        mTime = mEtTime.getText().toString();
        mRemark = mEtRemark.getText().toString();

        if("请选择费用类型".equals(mTraffic.getText().toString())){
            ToastUtils.toast("请选择费用类型");
            return false;
        }

        if (TextUtils.isEmpty(mReimburseMent)) {
            ToastUtils.toast("请填写报销金额");
            return false;
        }

        if(TextUtils.isEmpty(mTime)){
            ToastUtils.toast("请填写时间");
            return false;
        }

        return true;
    }

    private void Commit() {
        MarketActivityCreateRequestBean requestBean=new MarketActivityCreateRequestBean();
        requestBean.setDepartId(UserInfo.getCurrentUser().getDepartId());
        requestBean.setId("");
        requestBean.setPassWord(UserInfo.getCurrentUser().getPassword());
        requestBean.setOperType("1");
        requestBean.setUserId(UserInfo.getCurrentUser().getUserId());
        requestBean.setHasChildren(false);
        requestBean.setIsAuditForm(false);
        requestBean.setUserName(UserInfo.getCurrentUser().getUserName());
        requestBean.setIsStartWorkflow(true);
        requestBean.setEntityName("new_special_payment");
        requestBean.setApprovalPrice(mReimburseMent);

        MarketActivityCreateRequestBean.WorkflowFormInfoBean workflowFormInfoBean = new MarketActivityCreateRequestBean.WorkflowFormInfoBean();
        workflowFormInfoBean.setAuditStatus("");
        workflowFormInfoBean.setOpinion("");
        workflowFormInfoBean.setStepNumber("");
        requestBean.setWorkflowFormInfo(workflowFormInfoBean);

        ArrayList<MarketActivityCreateRequestBean.FormInfoBean> arrayList = new ArrayList<>();
        MarketActivityCreateRequestBean.FormInfoBean formInfoBean1 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean1.setFieldValue("2");//交通补助为2
        formInfoBean1.setFieldName("new_costtype");
        formInfoBean1.setFieldType("1");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean2 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean2.setFieldValue(mReimburseMent);
        formInfoBean2.setFieldName("new_amount");
        formInfoBean2.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean3 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean3.setFieldValue("2049");
        formInfoBean3.setFieldName("new_feeddate");
        formInfoBean3.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean4 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean4.setFieldValue(mRemark);
        formInfoBean4.setFieldName("new_remark");
        formInfoBean4.setFieldType("2");


        arrayList.add(formInfoBean1);
        arrayList.add(formInfoBean2);
        arrayList.add(formInfoBean3);
        arrayList.add(formInfoBean4);

        requestBean.setFormInfo(arrayList);

        startJsonRequest(ApiUrls.COMMON_SUBMIT_APPLY, requestBean, new HttpRequestHandler(this) {
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
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CUSTOMER && resultCode == Activity.RESULT_OK) {
            mTraffic.setText(data.getStringExtra(SpecialDuesReimbursementCreateTrafficeFragment.KEY_ACCOUNT_NAME));
            mTraffic.setTextColor(0xff333333);
            mCustomerId =data.getStringExtra(SpecialDuesReimbursementCreateTrafficeFragment.KEY_ACCOUNT_ID);
        }
    }
}
