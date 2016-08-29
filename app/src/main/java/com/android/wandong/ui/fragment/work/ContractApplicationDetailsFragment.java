package com.android.wandong.ui.fragment.work;

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
import com.android.wandong.beans.ContractApplicationDetailsResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.work.Tools.AuditStatusHelper;
import com.android.wandong.ui.widget.FixListView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

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

    @ViewInject(id = R.id.ll_1)
    LinearLayout mLl1;
    @ViewInject(id = R.id.ll_2)
    LinearLayout mLl2;
    @ViewInject(id = R.id.ll_3)
    LinearLayout mLl3;

    @ViewInject(id = R.id.listViewApproval1)
    FixListView mListViewApproval1;
    @ViewInject(id = R.id.indicator1)
    ImageView mImgIndicator1;
    @ViewInject(id = R.id.ApprovalInformation1, click = "OnClick")
    View mViewApprovalInformation1;//审批信息

    @ViewInject(id = R.id.listViewApproval2)
    FixListView mListViewApproval2;
    @ViewInject(id = R.id.indicator2)
    ImageView mImgIndicator2;
    @ViewInject(id = R.id.ApprovalInformation2, click = "OnClick")
    View mViewApprovalInformation2;//审批信息

    @ViewInject(id = R.id.listViewApproval3)
    FixListView mListViewApproval3;
    @ViewInject(id = R.id.indicator3)
    ImageView mImgIndicator3;
    @ViewInject(id = R.id.ApprovalInformation3, click = "OnClick")
    View mViewApprovalInformation3;//审批信息

    private String contractId;

    private Handler mHandler=new Handler();

    @Override
    protected int inflateContentView() {
        return R.layout.frag_contract_application_details;
    }

    public static void launch(FragmentActivity activity, String contractId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, contractId);
        FragmentContainerActivity.launch(activity, ContractApplicationDetailsFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contractId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, contractId);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("合同申请详情");
    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("ContractId", contractId);
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
            mApplyNo.setText(result.getEntityInfo().getDetail().getName());
            mAccountName.setText(result.getEntityInfo().getDetail().getAccountName());
            Tools.setTextView(mCreateOn, "创建时间：" + Tools.parseTimeToDateStr(Tools.parseDateStrToLong(result.getEntityInfo().getDetail().getCreatedOn())));
            if(result.getEntityInfo().getDetail().getStatus() == 3){
                mStatus.setText("执行状态：已批准");
            } else if (result.getEntityInfo().getDetail().getStatus() == 2) {
                mStatus.setText("执行状态：待审批");
            }else{
                mStatus.setText("执行状态："+result.getEntityInfo().getDetail().getStatus()+"");
            }
            AuditStatusHelper.setImageViewByStatus(mViewStatus, result.getEntityInfo().getDetail().getStatus());
            Tools.setTextView(mViewTime, Tools.parseTimeToDateStr(Tools.parseDateStrToLong(result.getEntityInfo().getDetail().getCreatedOn())));
            mOwnerName.setText(result.getEntityInfo().getDetail().getOwnerName());
            money.setText(result.getEntityInfo().getDetail().getContracTotal()+"");

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
            case R.id.ApprovalInformation1:
                if (mListViewApproval1.getVisibility() == View.GONE) {
                    mListViewApproval1.setVisibility(View.VISIBLE);
                    mImgIndicator1.setImageResource(R.drawable.icon_yellow_up);

                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //滚动到底部
                            ScrollView scrollView = (ScrollView) contentLayout;
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    }, 50);

                } else {
                    mListViewApproval1.setVisibility(View.GONE);
                    mImgIndicator1.setImageResource(R.drawable.icon_yellow_down);
                }
                break;
            case R.id.ApprovalInformation2:
                if (mListViewApproval2.getVisibility() == View.GONE) {
                    mListViewApproval2.setVisibility(View.VISIBLE);
                    mImgIndicator2.setImageResource(R.drawable.icon_yellow_up);

                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //滚动到底部
                            ScrollView scrollView = (ScrollView) contentLayout;
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    }, 50);

                } else {
                    mListViewApproval2.setVisibility(View.GONE);
                    mImgIndicator2.setImageResource(R.drawable.icon_yellow_down);
                }
                break;
            case R.id.ApprovalInformation3:
                if (mListViewApproval3.getVisibility() == View.GONE) {
                    mListViewApproval3.setVisibility(View.VISIBLE);
                    mImgIndicator3.setImageResource(R.drawable.icon_yellow_up);

                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //滚动到底部
                            ScrollView scrollView = (ScrollView) contentLayout;
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    }, 50);

                } else {
                    mListViewApproval3.setVisibility(View.GONE);
                    mImgIndicator3.setImageResource(R.drawable.icon_yellow_down);
                }
                break;
        }
    }


}
