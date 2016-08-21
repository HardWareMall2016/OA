package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.EntertainmentReimbursementCreateDetailContent;
import com.android.wandong.beans.EntertainmentReimbursementCreateDetailResponseBean;
import com.android.wandong.beans.MarketActivityCreateRequestBean;
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

import java.util.ArrayList;

/**
 * * 作者：keke on 2016/8/20 14:15
 */
public class EntertainmentReimbursementCreateDetailFragment extends ABaseFragment{
    private final static String ARG_KEY = "enter_reimbursecreate_detail";

    //views
    @ViewInject(id = R.id.tv_enter_tainment_companyname)
    TextView mTvCompanyName;
    @ViewInject(id = R.id.tv_enter_tainment_peplenumber)
    TextView mTvPepNumber ;
    @ViewInject(id = R.id.tv_enter_tainment_time)
    TextView mTvTime;
    @ViewInject(id = R.id.reasonContent)
    TextView mTvReasonContent;
    @ViewInject(id = R.id.create_province)
    TextView mTvProvice;
    @ViewInject(id = R.id.create_ApplyUnit)
    TextView mTvApplyUnit ;

    @ViewInject(id = R.id.TrueEstimateMeals)
    EditText mEtTrueMeals ;
    @ViewInject(id = R.id.EstimateHotel)
    EditText mEtHotel ;
    @ViewInject(id = R.id.EstimateOffice)
    EditText mEtOffice ;
    @ViewInject(id = R.id.EstimateTraffic)
    EditText mEtTraffic;
    @ViewInject(id = R.id.EstimateGift)
    EditText mEtGift;

    @ViewInject(id = R.id.EstimateTotal)
    TextView mTvTotal;

    @ViewInject(id = R.id.btn_commit,click = "OnClick")
    Button mCommit;

    private String mEntertainId ;

    private EntertainmentReimbursementCreateDetailContent mContent;

    public static void launch(FragmentActivity activity, EntertainmentReimbursementCreateDetailContent content) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, content);
        FragmentContainerActivity.launch(activity, EntertainmentReimbursementCreateDetailFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContent = savedInstanceState == null ? (EntertainmentReimbursementCreateDetailContent) getArguments().getSerializable(ARG_KEY) : (EntertainmentReimbursementCreateDetailContent) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mContent);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_enter_tainment_reimburse_create_detail;
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("招待费报销");

        mTvCompanyName.setText(mContent.getAccountName());
        mTvPepNumber.setText(mContent.getNumber()+"");
        mTvTime.setText("2016-10-10");
        mTvReasonContent.setText(mContent.getReason());

    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = new HttpRequestParams();
        requestParams.put("EntertainApplyId", mContent.getEntertainId());
        requestParams.put("PassWord", UserInfo.getCurrentUser().getPassword());
        requestParams.put("UserName", UserInfo.getCurrentUser().getUserName());

        startFormRequest(ApiUrls.ENTERTAIN_APPLY_DETAIL, requestParams, new BaseHttpRequestTask<EntertainmentReimbursementCreateDetailResponseBean>() {
            @Override
            public EntertainmentReimbursementCreateDetailResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, EntertainmentReimbursementCreateDetailResponseBean.class);
            }

            @Override
            public String verifyResponseResult(EntertainmentReimbursementCreateDetailResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(EntertainmentReimbursementCreateDetailResponseBean result) {
                super.onSuccess(result);
                if (result != null && result.getEntityInfo() != null && result.getEntityInfo().getDetail() != null) {

                    mEntertainId = result.getEntityInfo().getDetail().getEntertainId();

                    mTvProvice.setText(result.getEntityInfo().getDetail().getProvince());
                    mTvApplyUnit.setText(result.getEntityInfo().getDetail().getApplyUnit());

                    mEtTrueMeals.setText(result.getEntityInfo().getDetail().getEstimateMeals() + "");
                    mEtHotel.setText(result.getEntityInfo().getDetail().getEstimateHotel() + "");
                    mEtOffice.setText(result.getEntityInfo().getDetail().getEstimateOffice() + "");
                    mEtTraffic.setText(result.getEntityInfo().getDetail().getEstimateTraffic() + "");
                    mEtGift.setText(result.getEntityInfo().getDetail().getEstimateGift() + "");

                    mTvTotal.setText(result.getEntityInfo().getDetail().getEstimateTotal() + "");

                }

            }
        }, HttpRequestUtils.RequestType.POST);
    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.btn_commit:
                Commit();
                break;
        }
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
        requestBean.setEntityName("new_entertaincost");
        requestBean.setApprovalPrice(mTvTotal.getText().toString());

        MarketActivityCreateRequestBean.WorkflowFormInfoBean workflowFormInfoBean = new MarketActivityCreateRequestBean.WorkflowFormInfoBean();
        workflowFormInfoBean.setAuditStatus("");
        workflowFormInfoBean.setOpinion("");
        workflowFormInfoBean.setStepNumber("");
        requestBean.setWorkflowFormInfo(workflowFormInfoBean);

        ArrayList<MarketActivityCreateRequestBean.FormInfoBean> arrayList = new ArrayList<>();
        MarketActivityCreateRequestBean.FormInfoBean formInfoBean1 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean1.setFieldValue(mContent.getAccountId());
        formInfoBean1.setFieldName("new_accountid");
        formInfoBean1.setFieldType("4");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean2 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean2.setFieldValue(mTvPepNumber.getText().toString());
        formInfoBean2.setFieldName("new_number");
        formInfoBean2.setFieldType("6");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean3 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean3.setFieldValue("2016-10-10");
        formInfoBean3.setFieldName("new_entertaindate");
        formInfoBean3.setFieldType("5");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean4 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean4.setFieldValue(mTvReasonContent.getText().toString());
        formInfoBean4.setFieldName("new_reason");
        formInfoBean4.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean5 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean5.setFieldValue(mEtTrueMeals.getText().toString());
        formInfoBean5.setFieldName("new_actual_meals");
        formInfoBean5.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean6 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean6.setFieldValue(mEtHotel.getText().toString());
        formInfoBean6.setFieldName("new_actual_hotel");
        formInfoBean6.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean7 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean7.setFieldValue(mEtOffice.getText().toString());
        formInfoBean7.setFieldName("new_actual_office");
        formInfoBean7.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean8 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean8.setFieldValue(mEtTraffic.getText().toString());
        formInfoBean8.setFieldName("new_actual_traffic");
        formInfoBean8.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean9 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean9.setFieldValue(mEtGift.getText().toString());
        formInfoBean9.setFieldName("new_actual_gift");
        formInfoBean9.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean10 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean10.setFieldValue(mTvTotal.getText().toString());
        formInfoBean10.setFieldName("new_actual_total");
        formInfoBean10.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean11 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean11.setFieldValue(mEntertainId);
        formInfoBean11.setFieldName("new_entertainid");
        formInfoBean11.setFieldType("4");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean12 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean12.setFieldValue(mTvProvice.getText().toString());
        formInfoBean12.setFieldName("new_province");
        formInfoBean12.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean13 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean13.setFieldValue(mTvApplyUnit.getText().toString());
        formInfoBean13.setFieldName("new_applyunit");
        formInfoBean13.setFieldType("2");

        arrayList.add(formInfoBean1);
        arrayList.add(formInfoBean2);
        arrayList.add(formInfoBean3);
        arrayList.add(formInfoBean4);
        arrayList.add(formInfoBean5);
        arrayList.add(formInfoBean6);
        arrayList.add(formInfoBean7);
        arrayList.add(formInfoBean8);
        arrayList.add(formInfoBean9);
        arrayList.add(formInfoBean10);
        arrayList.add(formInfoBean11);
        arrayList.add(formInfoBean12);
        arrayList.add(formInfoBean13);

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

}
