package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.MarketReimburseDetailReplyContent;
import com.android.wandong.beans.ReplyDetailRequestBean;
import com.android.wandong.beans.ReplyDetailResponseBean;
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

import java.net.IDN;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 作者：蒲柯柯 on 2016/8/31 11:46
 * 邮箱：983198505@qq.com
 * 介绍:
 */
public class ReplyDetailFragment extends ABaseFragment{
    private final static String ARG_KEY = "key_reply";

    @ViewInject(id = R.id.tv_current_limit)
    TextView mTvCurrentLimit;
    @ViewInject(id = R.id.tv_reimbursement)
    TextView mTvReimbursement;
    @ViewInject(id = R.id.tv_Agreed,click = "OnClick")
    TextView mTvAgreed;
    @ViewInject(id = R.id.tv_NoAgreed,click = "OnClick")
    TextView mTvNoAgreed;

    private MarketReimburseDetailReplyContent content;
    private DecimalFormat mMoneyFormat = new DecimalFormat();

    @Override
    protected int inflateContentView() {
        return R.layout.frag_reply_details;
    }

    public static void launch(FragmentActivity activity, MarketReimburseDetailReplyContent content) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, content);
        FragmentContainerActivity.launch(activity, ReplyDetailFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        content = savedInstanceState == null ? (MarketReimburseDetailReplyContent) getArguments().getSerializable(ARG_KEY) : (MarketReimburseDetailReplyContent) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, content);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("批复");
        mMoneyFormat.applyPattern("###,##0.00元");
        Tools.setTextView(mTvReimbursement, mMoneyFormat.format(content.getAmount()));
    }

    @Override
    public void requestData() {
        final HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("EntityName", "new_entertaincost");
        requestParams.put("UserId", UserInfo.getCurrentUser().getUserId());
        startFormRequest(ApiUrls.APPROVAL_GETUSEABLE_PRICE, requestParams, new BaseHttpRequestTask<ReplyDetailResponseBean>() {
            @Override
            public ReplyDetailResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, ReplyDetailResponseBean.class);
            }

            @Override
            public String verifyResponseResult(ReplyDetailResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(ReplyDetailResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了
                if(result != null){
                    mTvCurrentLimit.setText(result.getMsg());
                }
            }

        }, HttpRequestUtils.RequestType.POST);
    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.tv_Agreed:
                AgreedDate();
                break;
            case R.id.tv_NoAgreed:
                break;
        }
    }

    private void AgreedDate() {
        ReplyDetailRequestBean requestBean=new ReplyDetailRequestBean();
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
        requestBean.setApprovalPrice("0");

        ReplyDetailRequestBean.WorkflowFormInfoBean workflowFormInfoBean = new ReplyDetailRequestBean.WorkflowFormInfoBean();
        workflowFormInfoBean.setOpinion("");
        workflowFormInfoBean.setStepNumber("");
        requestBean.setWorkflowFormInfo(workflowFormInfoBean);

        /*ArrayList<ReplyDetailRequestBean.WorkflowFormInfoBean> arrayList = new ArrayList<>();
        ReplyDetailRequestBean.FormInfoBean formInfoBean1 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean1.setFieldValue(mCustomerId);
        formInfoBean1.setFieldName("new_accountid");
        formInfoBean1.setFieldType("4");


        arrayList.add(formInfoBean1);

        requestBean.setFormInfo(arrayList);*/

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
