package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

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
import com.zhan.framework.view.pickerview.LoopView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 作者：keke on 16/8/4 15:32
 //
 //         .............................................
 //                  美女坐镇                  BUG辟易
 //         .............................................
 //
 //                       .::::.
 //                     .::::::::.
 //                    :::::::::::
 //                 ..:::::::::::'
 //              '::::::::::::'
 //                .::::::::::
 //           '::::::::::::::..
 //                ..::::::::::::.
 //              ``::::::::::::::::
 //               ::::``:::::::::'        .:::.
 //              ::::'   ':::::'       .::::::::.
 //            .::::'      ::::     .:::::::'::::.
 //           .:::'       :::::  .:::::::::' ':::::.
 //          .::'        :::::.:::::::::'      ':::::.
 //         .::'         ::::::::::::::'         ``::::.
 //     ...:::           ::::::::::::'              ``::.
 //    ```` ':.          ':::::::::'                  ::::..
 //                       '.:::::'                    ':'````..
 //
 */
public class EntertainmentApplicationCreateFragment extends ABaseFragment{
    private static final int REQUEST_CODE_CUSTOMER=100;

    @ViewInject(id = R.id.tainment_creat_chang_data,click = "OnClick")
    TextView mChangeData ;
    @ViewInject(id = R.id.market_change_province,click = "OnClick")
    TextView mProvince ;
    @ViewInject(id = R.id.create_enter_customer,click = "OnClick")
    TextView mCustomer ;

    @ViewInject(id = R.id.enter_tainment_peopleNum)
    EditText mEtTainPeopleNum ;
    @ViewInject(id = R.id.et_entertainment_reason)
    EditText mEtTainMentReason;
    @ViewInject(id = R.id.tv_enter_tainment_unit)
    TextView mTainmentUnit;
    @ViewInject(id = R.id.et_entertainment_meals)
    EditText mEtTainMentMeals ;
    @ViewInject(id = R.id.et_entertainment_conference_fee)
    EditText mEtTainMentConferenceFee ;
    @ViewInject(id = R.id.et_entertainment_office_fee)
    EditText mEtTainMentOfficeFee ;
    @ViewInject(id = R.id.et_entertainment_traffice_fee)
    EditText mEtTainMentTrafficeFee ;
    @ViewInject(id = R.id.et_entertainment_gift_fee)
    EditText mEtTainMentGiftFee;

    @ViewInject(id = R.id.mylesson_picker_view)
    LoopView mPickView;
    @ViewInject(id = R.id.enter_tainment_finalprice)
    TextView mFinalPrice ;

    @ViewInject(id = R.id.btn_submit,click = "OnClick")
    Button mBtnSubmit ;

    private View mChangLessonPopMenuContent;
    private long mOverdueTime=0;
    private TimePickerView mViewTimePicker;
    private PopupWindow mPopupWindow;

    private List<String> province_list = new ArrayList<>();
    private  int type = 1 ;
    private String mCustomerId ;

    private String mPeopleNum ;
    private String mTainMentReason;
    private String mTainMentMeals;
    private String mTainMentConferenceFee ;
    private String mTainMentOfficeFee;
    private String mTainMentTrafficeFee ;
    private String mTainMentGiftFee;

    public static void launch(Activity activity) {
        FragmentContainerActivity.launch(activity, EntertainmentApplicationCreateFragment.class, null);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_enter_tainment_create;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("招待费申请");

        province_list.add("北京市");
        province_list.add("天津市");
        province_list.add("上海市");
        province_list.add("重庆市");
        province_list.add("河北省");
        province_list.add("山西省");
        province_list.add("内蒙古自治区");
        province_list.add("辽宁省");
        province_list.add("吉林省");
        province_list.add("黑龙江省");
        province_list.add("江苏省");
        province_list.add("浙江省");
        province_list.add("安徽省");
        province_list.add("福建省");
        province_list.add("江西省");
        province_list.add("山东省");
        province_list.add("河南省");
        province_list.add("湖北省");
        province_list.add("湖南省");
        province_list.add("广东省");
        province_list.add("广西壮族自治区");
        province_list.add("海南省");
        province_list.add("四川省");
        province_list.add("贵州省");
        province_list.add("云南省");
        province_list.add("西藏自治区");
        province_list.add("陕西省");
        province_list.add("甘肃省");
        province_list.add("青海省");
        province_list.add("宁夏回族自治区");
        province_list.add("新疆维吾尔自治区");
        province_list.add("台湾省");
        province_list.add("香港特别行政区");
        province_list.add("澳门特别行政区");
        intiPopMenu();
        initTimePicker();

        mEtTainMentMeals.addTextChangedListener(mTextWatcher);
        mEtTainMentConferenceFee.addTextChangedListener(mTextWatcher);
        mEtTainMentOfficeFee.addTextChangedListener(mTextWatcher);
        mEtTainMentTrafficeFee.addTextChangedListener(mTextWatcher);
        mEtTainMentGiftFee.addTextChangedListener(mTextWatcher);
    }



    TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean Sign1 = mEtTainMentMeals.getText().length() > 0;
            boolean Sign2 = mEtTainMentConferenceFee.getText().length() > 0;
            boolean Sign3 = mEtTainMentOfficeFee.getText().length() > 0;
            boolean Sign4 = mEtTainMentTrafficeFee.getText().length() > 0;
            boolean Sign5 = mEtTainMentGiftFee.getText().length() > 0;

            if (Sign1&Sign2&Sign3&Sign4&Sign5) {
                int i1= Integer.parseInt(mEtTainMentMeals.getText().toString());
                int i2= Integer.parseInt(mEtTainMentConferenceFee.getText().toString());
                int i3= Integer.parseInt(mEtTainMentOfficeFee.getText().toString());
                int i4= Integer.parseInt(mEtTainMentTrafficeFee.getText().toString());
                int i5= Integer.parseInt(mEtTainMentGiftFee.getText().toString());


                int fialprice = i1+i2+i3+i4+i5;
                mFinalPrice.setText(fialprice+"");
            }
        }
    };

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
                    mChangeData.setText(Tools.parseTimeToDateStr(mOverdueTime));
                }
            }
        });
    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.tainment_creat_chang_data:
                Tools.hideSoftInputFromWindow(mChangeData);
                mViewTimePicker.show();
                break;
            case R.id.market_change_province:
                showChooseMenu();
                break;
            case R.id.create_enter_customer:
                EntertainmentApplicationListFragment.launchForResult(this, REQUEST_CODE_CUSTOMER);
                break;
            case R.id.btn_submit:
                if (!checkInput()) {
                    return;
                }
                Submit();
                break;
        }
    }

    private void Submit(){
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
        requestBean.setEntityName("new_entertain");
        requestBean.setApprovalPrice(mFinalPrice.getText().toString());//总计费用

        MarketActivityCreateRequestBean.WorkflowFormInfoBean workflowFormInfoBean = new MarketActivityCreateRequestBean.WorkflowFormInfoBean();
        workflowFormInfoBean.setAuditStatus("");
        workflowFormInfoBean.setOpinion("");
        workflowFormInfoBean.setStepNumber("");
        requestBean.setWorkflowFormInfo(workflowFormInfoBean);

        ArrayList<MarketActivityCreateRequestBean.FormInfoBean> arrayList = new ArrayList<>();
        MarketActivityCreateRequestBean.FormInfoBean formInfoBean1 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean1.setFieldValue(mCustomerId);
        formInfoBean1.setFieldName("new_accountid");
        formInfoBean1.setFieldType("4");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean2 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean2.setFieldValue(mPeopleNum);
        formInfoBean2.setFieldName("new_number");
        formInfoBean2.setFieldType("6");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean3 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean3.setFieldValue(mChangeData.getText().toString());
        formInfoBean3.setFieldName("new_entertaindate");
        formInfoBean3.setFieldType("5");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean4 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean4.setFieldValue(mEtTainMentReason.getText().toString());
        formInfoBean4.setFieldName("new_reason");
        formInfoBean4.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean5 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean5.setFieldValue(mTainMentMeals);
        formInfoBean5.setFieldName("new_estimate_meals");
        formInfoBean5.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean6 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean6.setFieldValue(mTainMentConferenceFee);
        formInfoBean6.setFieldName("new_estimate_hotel");
        formInfoBean6.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean7 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean7.setFieldValue(mTainMentOfficeFee);
        formInfoBean7.setFieldName("new_estimate_office");
        formInfoBean7.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean8 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean8.setFieldValue(mTainMentTrafficeFee);
        formInfoBean8.setFieldName("new_estimate_traffic");
        formInfoBean8.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean9 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean9.setFieldValue(mTainMentGiftFee);
        formInfoBean9.setFieldName("new_estimate_gift");
        formInfoBean9.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean10 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean10.setFieldValue(mFinalPrice.getText().toString());
        formInfoBean10.setFieldName("new_estimate_total");
        formInfoBean10.setFieldType("3");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean11 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean11.setFieldValue(mProvince.getText().toString());
        formInfoBean11.setFieldName("new_province");
        formInfoBean11.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean12 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean12.setFieldValue(mTainmentUnit.getText().toString());
        formInfoBean12.setFieldName("new_applyunit");
        formInfoBean12.setFieldType("2");

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

    private boolean checkInput() {
        mPeopleNum = mEtTainPeopleNum.getText().toString();
        mTainMentReason = mEtTainMentReason.getText().toString();
        mTainMentMeals = mEtTainMentMeals.getText().toString();
        mTainMentConferenceFee = mEtTainMentConferenceFee.getText().toString();
        mTainMentOfficeFee = mEtTainMentOfficeFee.getText().toString();
        mTainMentTrafficeFee = mEtTainMentTrafficeFee.getText().toString();
        mTainMentGiftFee = mEtTainMentGiftFee.getText().toString();

        if("请选择客户单位".equals(mCustomer.getText().toString())){
            ToastUtils.toast("请选择客户单位");
            return false;
        }
        if (TextUtils.isEmpty(mPeopleNum)) {
            ToastUtils.toast("请填写招待人数");
            return false;
        }
        if("请选择招待时间".equals(mChangeData.getText().toString())){
            ToastUtils.toast("请选择招待时间");
            return false;
        }

        if(TextUtils.isEmpty(mTainMentReason)){
            ToastUtils.toast("请填写招待事由");
            return false;
        }

        if("请选择省份".equals(mProvince.getText().toString())){
            ToastUtils.toast("请选择省份");
            return false;
        }

        if("请选择单元".equals(mTainmentUnit.getText().toString())){
            ToastUtils.toast("请选择单元");
            return false;
        }

        return true;
    }

    private void showChooseMenu() {
        mChangLessonPopMenuContent = getActivity().getLayoutInflater().inflate(R.layout.pop_memu_create_entertain, null);
        mPopupWindow.setContentView(mChangLessonPopMenuContent);
        View btnCancel = mChangLessonPopMenuContent.findViewById(R.id.mylesson_exam_time_cancel_time);
        btnCancel.setOnClickListener(mOnExamTimeClickListener);
        View btnFinish = mChangLessonPopMenuContent.findViewById(R.id.mylesson_exam_time_finish_time);
        btnFinish.setOnClickListener(mOnExamTimeClickListener);
        mPickView = (LoopView) mChangLessonPopMenuContent.findViewById(R.id.mylesson_picker_view);
        mPickView.setNotLoop();
        mPickView.setArrayList((ArrayList) province_list);
        mPickView.setInitPosition(0);

        showPopMenu();
    }

    private View.OnClickListener mOnExamTimeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.mylesson_exam_time_cancel_time:
                    closePopWin();
                    break;
                case R.id.mylesson_exam_time_finish_time:
                    type = mPickView.getSelectedItem();
                    if (type >= 0 && type < province_list.size()) {
                        mProvince.setText(province_list.get(type));
                        closePopWin();
                    }
                    break;
            }
        }
    };

    public boolean closePopWin() {
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
            return true;
        }
        return false;
    }

    private void showPopMenu() {
        if (mPopupWindow != null && !mPopupWindow.isShowing()) {
            mPopupWindow.showAtLocation(getActivity().getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
            backgroundAlpha(0.7f);
            mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    backgroundAlpha(1f);
                }
            });
        }
    }

    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha;
        getActivity().getWindow().setAttributes(lp);
    }

    private void intiPopMenu() {
        mPopupWindow = new PopupWindow(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        int bgColor = getResources().getColor(com.zhan.framework.R.color.main_background);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(bgColor));
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setAnimationStyle(R.style.pop_menu_animation);
        mPopupWindow.update();
        mPopupWindow.setTouchable(true);
        mPopupWindow.setFocusable(true);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CUSTOMER && resultCode == Activity.RESULT_OK) {
            mCustomer.setText(data.getStringExtra(EntertainmentApplicationListFragment.KEY_ACCOUNT_NAME));
            mCustomer.setTextColor(0xff333333);
            mCustomerId =data.getStringExtra(EntertainmentApplicationListFragment.KEY_ACCOUNT_ID);
        }
    }
}
