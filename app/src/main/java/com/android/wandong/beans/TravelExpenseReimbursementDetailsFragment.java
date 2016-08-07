package com.android.wandong.beans;

import android.app.Activity;
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
import com.android.wandong.network.ApiUrls;
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
public class TravelExpenseReimbursementDetailsFragment extends ABaseFragment {
    private final static String ARG_KEY = "travel_reimbur_key";

    @ViewInject(id = R.id.travel_headPortrait)
    ImageView mImgHeadPortrait;
    @ViewInject(id = R.id.AccountName)
    TextView mViewAccountName;//客户名称
    @ViewInject(id = R.id.Day)
    TextView mViewDay;
    @ViewInject(id = R.id.travel_number)
    TextView mViewNumber;
    @ViewInject(id = R.id.money)
    TextView mMoney ;
    @ViewInject(id = R.id.time)
    TextView mTime ;
    @ViewInject(id = R.id.img_status)
    ImageView mStatus ;
    @ViewInject(id = R.id.listViewTravel)
    FixListView mListViewTravel;

    @ViewInject(id = R.id.indicator)
    ImageView mImgIndicator;

    @ViewInject(id = R.id.ApprovalInformation, click = "OnClick")
    View mViewApprovalInformation;//审批信息
    @ViewInject(id = R.id.listViewApproval)
    FixListView mListViewApproval;


    private TravelAdapter mTravelAdapter;

    private TravelExpenseReimburseContent mContent;
    private String mTravelCostId ;
    private DecimalFormat mMoneyFormat = new DecimalFormat();
    private Handler mHandler=new Handler();

    @Override
    protected int inflateContentView() {
        return R.layout.frag_travel_reimburse_details;
    }

    public static void launch(FragmentActivity activity, TravelExpenseReimburseContent mContent) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, mContent);
        FragmentContainerActivity.launch(activity, TravelExpenseReimbursementDetailsFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContent = savedInstanceState == null ? (TravelExpenseReimburseContent) getArguments().getSerializable(ARG_KEY) : (TravelExpenseReimburseContent) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mContent);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("差旅费报销详情");
        mMoneyFormat.applyPattern("###,##0.00元");
    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("TravelCostId", mContent.getTravelCostId());
        requestParams.put("AuditStatus", mContent.getAuditStatus());
        requestParams.put("StepNumber", mContent.getStepNumber());
        startFormRequest(ApiUrls.TRAVEL_EXPENSE_DETAIL, requestParams, new BaseHttpRequestTask<TravelExpenseReimburseDetailsResponseBean>() {
            @Override
            public TravelExpenseReimburseDetailsResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, TravelExpenseReimburseDetailsResponseBean.class);
            }

            @Override
            public String verifyResponseResult(TravelExpenseReimburseDetailsResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(TravelExpenseReimburseDetailsResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了
                if (result != null && result.getEntityInfo() != null) {
                    populateView(result);
                }

            }

        }, HttpRequestUtils.RequestType.POST);
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
    private void populateView(TravelExpenseReimburseDetailsResponseBean result) {
        ArrayList<DetailItem> detailItems = new ArrayList<>();
        if (result.getEntityInfo().getDetail() != null) {
            for (TravelExpenseReimburseDetailsResponseBean.EntityInfoBean.DetailBean bean : result.getEntityInfo().getDetail()) {
                DetailItem detailItem = new DetailItem();
                detailItem.TravelPaymentId = bean.getTravelPaymentId();
                detailItem.BeginDate = bean.getBeginDate();
                detailItem.EndDate = bean.getEndDate();
                detailItem.TravelDays = bean.getTravelDays();
                detailItem.HotelDays = bean.getHotelDays();
                detailItem.Origin = bean.getOrigin();
                detailItem.Destination = bean.getDestination();
                detailItem.Transport = bean.getTransport();
                detailItem.IsGoBack = bean.isIsGoBack();
                detailItem.TrainTicket = bean.getTrainTicket();
                detailItem.Allowance = bean.getAllowance();
                detailItem.OilFuel = bean.getOilFuel();
                detailItem.LocalTravel = bean.getLocalTravel();
                detailItem.CrossTravel = bean.getCrossTravel();
                detailItem.Hotel = bean.getHotel();
                detailItem.Travel = bean.getTravel();
                detailItem.HotelSubsidy = bean.getHotelSubsidy();
                detailItem.MealSubsidy = bean.getMealSubsidy();
                detailItem.CarSubsidy = bean.getCarSubsidy();
                detailItem.Other = bean.getOther();
                detailItem.IsDiscount = bean.isIsDiscount();
                detailItem.DiscountRate = bean.getDiscountRate();
                detailItem.Remark = bean.getRemark();
                detailItem.OwnerId = bean.getOwnerId();
                detailItem.OwnerName = bean.getOwnerName();
                detailItem.CreatedOn = bean.getCreatedOn();
                detailItem.PersonalImage = bean.getPersonalImage();

                detailItems.add(detailItem);
            }
        }

        ArrayList<ApprovalItem> approvalItems = new ArrayList<>();
        if(result.getEntityInfo().getApproval() != null){
            for (TravelExpenseReimburseDetailsResponseBean.EntityInfoBean.ApprovalBean bean : result.getEntityInfo().getApproval()) {
                ApprovalItem approvalItem = new ApprovalItem();
                approvalItem.StepNumber = bean.getStepNumber();
                approvalItem.ApprovalTime = bean.getApprovalTime();
                approvalItem.ApprovalPrice = bean.getApprovalPrice();
                approvalItem.Opinion = bean.getOpinion();
                approvalItem.Result = bean.getResult();
                approvalItem.ApproverId = bean.getApproverId();
                approvalItem.Approver = bean.getApprover();

                approvalItems.add(approvalItem);
            }
        }

        mListViewApproval.setAdapter(new ApprovalAdapter(approvalItems, getActivity()));
        mTravelAdapter=new TravelAdapter(detailItems, getActivity());
        mListViewTravel.setAdapter(mTravelAdapter);
    }

    private class ApprovalItem{
        String StepNumber;
        String ApprovalTime;
        int ApprovalPrice;
        String Opinion;
        String Result;
        String ApproverId;
        String Approver;
    }

    private class DetailItem{
        boolean expand=false;
        String TravelPaymentId;
        String BeginDate;
        String EndDate;
        String TravelDays;
        String HotelDays;
        String Origin;
        String Destination;
        int Transport;
        boolean IsGoBack;
        Object TrainTicket;
        Object Allowance;
        Object OilFuel;
        String LocalTravel;
        Object CrossTravel;
        String Hotel;
        double Travel;
        double HotelSubsidy;
        double MealSubsidy;
        double CarSubsidy;
        double Other;
        boolean IsDiscount;
        String DiscountRate;
        String Remark;
        String OwnerId;
        String OwnerName;
        String CreatedOn;
        Object PersonalImage;
    }

    private class TravelAdapter extends ABaseAdapter<DetailItem> {

        public TravelAdapter(ArrayList<DetailItem> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<DetailItem> newItemView() {
            return new TravelItemView();
        }
    }

    private class TravelItemView extends ABaseAdapter.AbstractItemView<DetailItem> {
        @ViewInject(id = R.id.headPortrait)
        CircleImageView headPortrait;

        @ViewInject(id = R.id.return_address)
        TextView mAddress;

        @ViewInject(id = R.id.travel_time)
        TextView mTravelTime;

        @ViewInject(id = R.id.travel_tool)
        TextView mTravelTool;

        @ViewInject(id = R.id.ll_travel_yincang)
        LinearLayout mTravelYIncNG ;

        @ViewInject(id = R.id.travel_indicator)
        ImageView mIndicator ;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_travel;
        }

        @Override
        public void bindingData(View convertView, final DetailItem data) {
            //ImageLoader.getInstance().displayImage(data.ApprovalTime, headPortrait, Tools.buildDisplayImageOptionsForAvatar());
            mAddress.setText("往返地址："+data.Origin+"-"+data.Destination);
            mTravelTime.setText("出差时间："+data.TravelDays+"天");
            mTravelTool.setText("交通工具：" + data.TrainTicket + "|交通费：" + data.Travel + "");

            if(data.expand){
                mTravelYIncNG.setVisibility(View.VISIBLE);
                mIndicator.setImageResource(R.drawable.icon_yellow_up);
            }else{
                mTravelYIncNG.setVisibility(View.GONE);
                mIndicator.setImageResource(R.drawable.icon_yellow_down);
            }

            mIndicator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.expand=!data.expand;
                    mTravelAdapter.notifyDataSetChanged();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mListViewTravel.requestLayout();
                        }
                    }, 50);
                }
            });
        }
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
