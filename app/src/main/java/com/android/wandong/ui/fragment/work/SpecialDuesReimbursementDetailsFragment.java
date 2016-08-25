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
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.SpecialDuesReimbursementDetailsResponseBean;
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
public class SpecialDuesReimbursementDetailsFragment extends ABaseFragment {
    private final static String ARG_KEY = "specialdues_reimbur_key";

    @ViewInject(id = R.id.AccountName)
    private TextView mViewAccountName;//客户名称
    @ViewInject(id = R.id.OwnerName)
    private TextView mViewOwnerName;//创建人名称
    @ViewInject(id = R.id.money)
    private TextView mViewmoneyr;//招待费

    @ViewInject(id = R.id.Type)
    TextView mType ;
    @ViewInject(id = R.id.people)
    TextView mPeople ;

    @ViewInject(id = R.id.img_status)
    private ImageView mViewStatus;//审批状态
    @ViewInject(id = R.id.listViewApproval)
    private FixListView mListViewApproval;

    @ViewInject(id = R.id.indicator)
    private ImageView mImgIndicator;

    @ViewInject(id = R.id.tv_Remark)
    TextView mTvRemark ;

    @ViewInject(id = R.id.ApprovalInformation, click = "OnClick")
    private View mViewApprovalInformation;//审批信息

    private String mDailyExpenseId ;
    private DecimalFormat mMoneyFormat = new DecimalFormat();
    private Handler mHandler=new Handler();

    @Override
    protected int inflateContentView() {
        return R.layout.frag_specialdues_reimburse_details;
    }

    public static void launch(FragmentActivity activity, String id) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, id);
        FragmentContainerActivity.launch(activity, SpecialDuesReimbursementDetailsFragment.class, args);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDailyExpenseId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mDailyExpenseId);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("专项费报销详情");
        mMoneyFormat.applyPattern("###,##0.00元");
    }
    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("DailyExpenseId", mDailyExpenseId);
        startFormRequest(ApiUrls.DAILY_EXPENSE_DETAIL, requestParams, new BaseHttpRequestTask<SpecialDuesReimbursementDetailsResponseBean>() {
            @Override
            public SpecialDuesReimbursementDetailsResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, SpecialDuesReimbursementDetailsResponseBean.class);
            }

            @Override
            public String verifyResponseResult(SpecialDuesReimbursementDetailsResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(SpecialDuesReimbursementDetailsResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了
                if (result != null && result.getEntityInfo() != null) {
                    populateView(result);
                }

            }

        }, HttpRequestUtils.RequestType.POST);
    }

    private void populateView(SpecialDuesReimbursementDetailsResponseBean result) {
        if (result.getEntityInfo().getDetail() != null) {
            Tools.setTextView(mViewAccountName, result.getEntityInfo().getDetail().getName());
            Tools.setTextView(mViewOwnerName, result.getEntityInfo().getDetail().getOwnerName());
            Tools.setTextView(mViewmoneyr, mMoneyFormat.format(result.getEntityInfo().getDetail().getAmount()));
            Tools.setTextView(mType,result.getEntityInfo().getDetail().getCostTypeName());
            Tools.setTextView(mPeople, result.getEntityInfo().getDetail().getOwnerName());

            if(result.getEntityInfo().getDetail().getRemark() != null){
                mTvRemark.setVisibility(View.VISIBLE);
                Tools.setTextView(mTvRemark, result.getEntityInfo().getDetail().getRemark());
            }else{
                mTvRemark.setVisibility(View.GONE);
            }

            AuditStatusHelper.setImageViewByStatus(mViewStatus, result.getEntityInfo().getDetail().getAuditStatus());
        }
        ArrayList<ApprovalItem> approvalItems = new ArrayList<>();
        if(result.getEntityInfo().getApproval() != null){
            for (SpecialDuesReimbursementDetailsResponseBean.EntityInfoBean.ApprovalBean bean : result.getEntityInfo().getApproval()) {
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
