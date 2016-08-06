package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.EntertainApplyDetailResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.work.Tools.AuditStatusHelper;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

import java.text.DecimalFormat;

/**
 * 作者：伍岳 on 16/8/4 15:32
 * 邮箱：wuyue8512@163.com
 * //
 * //         .............................................
 * //                  美女坐镇                  BUG辟易
 * //         .............................................
 * //
 * //                       .::::.
 * //                     .::::::::.
 * //                    :::::::::::
 * //                 ..:::::::::::'
 * //              '::::::::::::'
 * //                .::::::::::
 * //           '::::::::::::::..
 * //                ..::::::::::::.
 * //              ``::::::::::::::::
 * //               ::::``:::::::::'        .:::.
 * //              ::::'   ':::::'       .::::::::.
 * //            .::::'      ::::     .:::::::'::::.
 * //           .:::'       :::::  .:::::::::' ':::::.
 * //          .::'        :::::.:::::::::'      ':::::.
 * //         .::'         ::::::::::::::'         ``::::.
 * //     ...:::           ::::::::::::'              ``::.
 * //    ```` ':.          ':::::::::'                  ::::..
 * //                       '.:::::'                    ':'````..
 * //
 */
public class EntertainmentApplicationDetailsFragment extends ABaseFragment {
    private final static String ARG_KEY = "arg_key";

    @ViewInject(id = R.id.ApplyNo)
    private TextView mViewApplyNo;//申请单号
    @ViewInject(id = R.id.AccountName)
    private TextView mViewAccountName;//客户名称
    @ViewInject(id = R.id.OwnerName)
    private TextView mViewOwnerName;//创建人名称
    @ViewInject(id = R.id.number)
    private TextView mViewNumber;//数量
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

    @ViewInject(id = R.id.ApprovalInformation)
    private TextView mViewApprovalInformation;//审批信息

    private String mEntertainApplyId;


    private DecimalFormat mMoneyFormat = new DecimalFormat();


    public static void launch(FragmentActivity activity, String entertainApplyId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, entertainApplyId);
        FragmentContainerActivity.launch(activity, EntertainmentApplicationDetailsFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEntertainApplyId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mEntertainApplyId);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("招待费申请");
        mMoneyFormat.applyPattern("###,##0.00元");
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_enter_tainment_details;
    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("EntertainApplyId", mEntertainApplyId);
        startFormRequest(ApiUrls.ENTERTAIN_APPLY_DETAIL, requestParams, new BaseHttpRequestTask<EntertainApplyDetailResponseBean>() {
            @Override
            public EntertainApplyDetailResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, EntertainApplyDetailResponseBean.class);
            }

            @Override
            public String verifyResponseResult(EntertainApplyDetailResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(EntertainApplyDetailResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了
                if (result != null && result.getEntityInfo() != null) {
                    populateView(result);
                }

            }
        }, HttpRequestUtils.RequestType.POST);

    }

    private void populateView(EntertainApplyDetailResponseBean result) {
        if (result.getEntityInfo().getDetail() != null) {
            Tools.setTextView(mViewApplyNo, result.getEntityInfo().getDetail().getName());
            Tools.setTextView(mViewAccountName, result.getEntityInfo().getDetail().getAccountName());
            Tools.setTextView(mViewOwnerName, result.getEntityInfo().getDetail().getOwnerName());
            Tools.setTextView(mViewNumber, String.valueOf(result.getEntityInfo().getDetail().getNumber()));
            AuditStatusHelper.setImageViewByStatus(mViewStatus, result.getEntityInfo().getDetail().getAuditStatus());

            Tools.setTextView(mViewCustomerNum, String.format("%d人", result.getEntityInfo().getDetail().getNumber()));
            Tools.setTextView(mViewReasonContent, String.valueOf(result.getEntityInfo().getDetail().getReason()));


            Tools.setTextView(mViewApplyUnit, String.valueOf(result.getEntityInfo().getDetail().getApplyUnit()));

            populateEstimateView(mViewEstimateMeals, result.getEntityInfo().getDetail().getEstimateMeals());
            populateEstimateView(mViewEstimateOffice, result.getEntityInfo().getDetail().getEstimateOffice());
            populateEstimateView(mViewEstimateTraffic, result.getEntityInfo().getDetail().getEstimateTraffic());
            populateEstimateView(mViewEstimateGift, result.getEntityInfo().getDetail().getEstimateGift());
            populateEstimateView(mViewEstimateHotel, result.getEntityInfo().getDetail().getEstimateHotel());

            Tools.setTextView(mViewEstimateTotal, mMoneyFormat.format(result.getEntityInfo().getDetail().getEstimateTotal()));
        }
    }

    private void populateEstimateView(TextView estimateView, double value) {
        if (value == 0) {
            View parent = (View) estimateView.getParent();
            parent.setVisibility(View.GONE);
        } else {
            Tools.setTextView(estimateView, mMoneyFormat.format(value));
        }
    }
}
