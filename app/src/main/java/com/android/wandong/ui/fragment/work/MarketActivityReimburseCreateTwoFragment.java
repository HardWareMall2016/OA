package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.MarketActivityCreateRequestBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.timePicker.TimePickerView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ${keke} on 16/8/12.
 */
public class MarketActivityReimburseCreateTwoFragment extends ABaseFragment{

    @ViewInject(id = R.id.market_change_data,click = "OnClick")
    TextView mRlChangData;
    @ViewInject(id = R.id.btn_true,click = "OnClick")
    TextView mSure;
    @ViewInject(id = R.id.market_create_money)
    TextView mCreateMoney;
    @ViewInject(id = R.id.market_campaignname)
    TextView mCampaignName ;
    @ViewInject(id = R.id.remark)
    EditText mRemark;

    private long mOverdueTime=0;

    private TimePickerView mViewTimePicker;


    @Override
    protected int inflateContentView() {
        return R.layout.frag_market_activity_reimburse_create;
    }

    public static void launch(FragmentActivity activity) {
        FragmentContainerActivity.launch(activity, MarketActivityReimburseCreateTwoFragment.class, null);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("市场活动费报销");

        initTimePicker();
    }

    private void initTimePicker() {
        mViewTimePicker = new TimePickerView(getActivity(), TimePickerView.Type.YEAR_MONTH_DAY);
        Calendar calendar = Calendar.getInstance();
        mViewTimePicker.setRange(calendar.get(Calendar.YEAR), calendar.get(Calendar.YEAR) + 100);
        mViewTimePicker.setTime(new Date());
        mViewTimePicker.setCyclic(false);
        mViewTimePicker.setCancelable(true);
        //时间选择后回调
        mViewTimePicker.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date) {
                Date curDate = new Date();
                boolean beforeDate = date.before(curDate);
                if (beforeDate) {
                    ToastUtils.toast("请选择晚于今天的日期");
                } else {
                    mOverdueTime = date.getTime();
                    mRlChangData.setText(Tools.parseTimeToDateStr(mOverdueTime));
                }
            }
        });
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.market_change_data:
                Tools.hideSoftInputFromWindow(mRlChangData);
                mViewTimePicker.show();
                break;
            case R.id.btn_true:
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
        requestBean.setEntityName("new_campaign");
        requestBean.setApprovalPrice(mCreateMoney.getText().toString());

        MarketActivityCreateRequestBean.WorkflowFormInfoBean workflowFormInfoBean = new MarketActivityCreateRequestBean.WorkflowFormInfoBean();
        workflowFormInfoBean.setAuditStatus("");
        workflowFormInfoBean.setOpinion("");
        workflowFormInfoBean.setStepNumber("");
        requestBean.setWorkflowFormInfo(workflowFormInfoBean);

        ArrayList<MarketActivityCreateRequestBean.FormInfoBean> arrayList = new ArrayList<>();
        MarketActivityCreateRequestBean.FormInfoBean formInfoBean1 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean1.setFieldValue(mCampaignName.getText().toString());
        formInfoBean1.setFieldName("new_campaignname");
        formInfoBean1.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean2 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean2.setFieldValue("2");
        formInfoBean2.setFieldName("new_costtype");
        formInfoBean2.setFieldType("1");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean3 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean3.setFieldValue(mCreateMoney.getText().toString());
        formInfoBean3.setFieldName("new_amount");
        formInfoBean3.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean4 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean4.setFieldValue(mRlChangData.getText().toString());
        formInfoBean4.setFieldName("new_occurtime");
        formInfoBean4.setFieldType("5");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean5 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean5.setFieldValue(mRemark.getText().toString());
        formInfoBean5.setFieldName("new_remark");
        formInfoBean5.setFieldType("2");

        arrayList.add(formInfoBean1);
        arrayList.add(formInfoBean2);
        arrayList.add(formInfoBean3);
        arrayList.add(formInfoBean4);
        arrayList.add(formInfoBean5);

        requestBean.setFormInfo(arrayList);

        startJsonRequest(ApiUrls.COMMON_SUBMIT_APPLY, requestBean, new HttpRequestHandler(this) {
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                switch (resultCode) {
                    case success:
                        BaseResponseBean responseBean = Tools.parseJsonTostError(result, BaseResponseBean.class);
                        if (responseBean != null) {
                            ToastUtils.toast("新增表单成功");
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
