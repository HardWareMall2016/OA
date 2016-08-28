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
import com.android.wandong.beans.EntertainApplyDetailResponseBean;
import com.android.wandong.beans.EntertainmentReimbursementDetailResponseBean;
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
 * Created by ${keke} on 16/8/4.
 */
public class EntertainmentReimbursementDetailFragment extends ABaseFragment {
    private final static String ARG_KEY = "enter_tain_reimbur_key";

    @ViewInject(id = R.id.ApplyNo)
    private TextView mViewApplyNo;//申请单号
    @ViewInject(id = R.id.AccountName)
    private TextView mViewAccountName;//客户名称
    @ViewInject(id = R.id.OwnerName)
    private TextView mViewOwnerName;//创建人名称
    @ViewInject(id = R.id.money)
    private TextView mViewmoneyr;//招待费
    @ViewInject(id = R.id.time)
    private TextView mViewTime;//时间
    @ViewInject(id = R.id.img_status)
    private ImageView mViewStatus;//审批状态
    @ViewInject(id = R.id.customer_number)
    private TextView mViewCustomerNum;//招待人数
    @ViewInject(id = R.id.TreatTime)
    private TextView mViewTreatTime;//招待时间
    @ViewInject(id = R.id.reasonContent)
    private TextView mViewReasonContent;//招待事由


    @ViewInject(id = R.id.ApplyUnit)
    private TextView mViewApplyUnit;//申请单元
    @ViewInject(id = R.id.EstimateMeals)
    private TextView mViewEstimateMeals;//预计餐费
    @ViewInject(id = R.id.EstimateOffice)
    private TextView mViewEstimateOffice;//预计办公费
    @ViewInject(id = R.id.EstimateTraffic)
    private TextView mViewEstimateTraffic;//预计交通费
    @ViewInject(id = R.id.EstimateGift)
    private TextView mViewEstimateGift;//预计礼品费
    @ViewInject(id = R.id.EstimateHotel)
    private TextView mViewEstimateHotel;//预计住宿费
    @ViewInject(id = R.id.EstimateTotal)
    private TextView mViewEstimateTotal;//预计合计费用

    @ViewInject(id = R.id.listViewApproval)
    private FixListView mListViewApproval;

    @ViewInject(id = R.id.indicator)
    private ImageView mImgIndicator;

    @ViewInject(id = R.id.province)
    TextView mTvProvince ;
    @ViewInject(id = R.id.TrueEstimateMeals)
    TextView mTvTrueEstimateMeals ;

    @ViewInject(id = R.id.ApprovalInformation, click = "OnClick")
    private View mViewApprovalInformation;//审批信息

    private String mSignId;
    private DecimalFormat mMoneyFormat = new DecimalFormat();
    private Handler mHandler=new Handler();


    public static void launch(FragmentActivity activity, String accountId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, accountId);
        FragmentContainerActivity.launch(activity, EntertainmentReimbursementDetailFragment.class, args);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_enter_tainment_reimburse_detail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSignId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mSignId);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("招待费报销详情");
        mMoneyFormat.applyPattern("###,##0.00元");
    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("EntertainCostId", mSignId);
        startFormRequest(ApiUrls.ENTER_TAIN_EXPENSE_DETAIL, requestParams, new BaseHttpRequestTask<EntertainmentReimbursementDetailResponseBean>() {
            @Override
            public EntertainmentReimbursementDetailResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, EntertainmentReimbursementDetailResponseBean.class);
            }

            @Override
            public String verifyResponseResult(EntertainmentReimbursementDetailResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(EntertainmentReimbursementDetailResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了
                if (result != null && result.getEntityInfo() != null) {
                    populateView(result);
                }

            }
        }, HttpRequestUtils.RequestType.POST);
    }

    private void populateView(EntertainmentReimbursementDetailResponseBean result) {
        if (result.getEntityInfo().getDetail() != null) {
            Tools.setTextView(mViewApplyNo, result.getEntityInfo().getDetail().getName());
            Tools.setTextView(mViewAccountName, result.getEntityInfo().getDetail().getAccountName());
            Tools.setTextView(mViewOwnerName, result.getEntityInfo().getDetail().getOwnerName());
            Tools.setTextView(mViewmoneyr, mMoneyFormat.format(result.getEntityInfo().getDetail().getActualTotal()));

            Tools.setTextView(mViewTime, Tools.parseTimeToDateStr(Tools.parseDateStrToLong(result.getEntityInfo().getDetail().getCreatedOn())));

            AuditStatusHelper.setImageViewByStatus(mViewStatus, result.getEntityInfo().getDetail().getAuditStatus());

            Tools.setTextView(mViewCustomerNum, String.format("%d人", result.getEntityInfo().getDetail().getNumber()));
            Tools.setTextView(mViewReasonContent, String.valueOf(result.getEntityInfo().getDetail().getReason()));

            Tools.setTextView(mTvProvince, result.getEntityInfo().getDetail().getProvince());

            Tools.setTextView(mTvTrueEstimateMeals, result.getEntityInfo().getDetail().getActualMeals()+"元");

            Tools.setTextView(mViewApplyUnit, String.valueOf(result.getEntityInfo().getDetail().getApplyUnit()));

            populateEstimateView(mViewEstimateMeals, result.getEntityInfo().getDetail().getActualMeals());
            populateEstimateView(mViewEstimateOffice, result.getEntityInfo().getDetail().getActualOffice());
            populateEstimateView(mViewEstimateTraffic, result.getEntityInfo().getDetail().getActualTraffic());
            populateEstimateView(mViewEstimateGift, result.getEntityInfo().getDetail().getActualGift());
            populateEstimateView(mViewEstimateHotel, result.getEntityInfo().getDetail().getActualHotel());

            Tools.setTextView(mViewEstimateTotal, mMoneyFormat.format(result.getEntityInfo().getDetail().getActualTotal()));
        }
        ArrayList<ApprovalItem> approvalItems = new ArrayList<>();
        if (result.getEntityInfo().getApproval() != null) {
            for (EntertainmentReimbursementDetailResponseBean.EntityInfoBean.ApprovalBean bean : result.getEntityInfo().getApproval()) {
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

    private void populateEstimateView(TextView estimateView, double value) {
        if (value == 0) {
            View parent = (View) estimateView.getParent();
            parent.setVisibility(View.GONE);
        } else {
            Tools.setTextView(estimateView, mMoneyFormat.format(value));
        }
    }

    void OnClick(View v) {
        switch (v.getId()) {
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

    private class ApprovalItem {
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
