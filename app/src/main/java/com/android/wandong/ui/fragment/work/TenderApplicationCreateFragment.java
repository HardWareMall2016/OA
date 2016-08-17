package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
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
import com.zhan.framework.view.pickerview.LoopView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ${keke} on 16/8/13.
 */
public class TenderApplicationCreateFragment extends ABaseFragment {
    private static final int REQUEST_CODE_CUSTOMER=100;
    private static final int REQUEST_CODE_PRODUCT=101;
    private static final int REQUEST_CODE_BIDPRODUCT=102;

    @ViewInject(id = R.id.inspection_project_name)
    EditText mEtProjectName;
    @ViewInject(id = R.id.et_tender_code)
    EditText mEtTenderCode ;
    @ViewInject(id = R.id.et_tender_city)
    EditText mEtTenderCity;
    @ViewInject(id = R.id.et_tender_equipment_number)
    EditText mEtTenderEquipmentNumber;
    @ViewInject(id = R.id.et_tender_agency_agency)
    EditText mEtTenderAgency;
    @ViewInject(id = R.id.et_tender_company_name)
    EditText mEtCompanyName;
    @ViewInject(id = R.id.et_tender_websit)
    EditText mEtWebSit;

    @ViewInject(id = R.id.tender_customer,click = "OnClick")
    TextView mCustomer ;
    @ViewInject(id = R.id.tender_change_province,click = "OnClick")
    TextView mProvince;
    @ViewInject(id = R.id.tender_change_bidtime,click = "OnClick")
    TextView mBidTime;
    @ViewInject(id = R.id.mylesson_picker_view)
    LoopView mPickView;
    @ViewInject(id = R.id.tender_change_product,click = "OnClick")
    TextView mProduct;
    @ViewInject(id = R.id.tender_change_bidproduct,click = "OnClick")
    TextView mBidProduct;
    @ViewInject(id = R.id.btn_commit,click = "OnClick")
    Button mCommit ;

    private List<String> province_list = new ArrayList<>();
    private  int type = 1 ;
    private long mOverdueTime=0;
    private View mChangLessonPopMenuContent;
    private TimePickerView mViewTimePicker;
    private PopupWindow mPopupWindow;

    private String mCustomerId ;
    private String mProductId ;
    private String mBidProductId;

    private String mProjectName;
    private String mTenderCode;
    private String mTenderCity;
    private String mTenderEquipmentNumber;
    private String mTenderAgency;
    private String mCompanyName;
    private String mWebSit;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_tender_application_create;
    }


    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, TenderApplicationCreateFragment.class, null);
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("招投标申请");

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
                    mBidTime.setText(Tools.parseTimeToDateStr(mOverdueTime));
                }
            }
        });
    }


    void OnClick(View view){
        switch (view.getId()){
            case R.id.tender_customer:
                TenderApplicationListFragment.launchForResult(this, REQUEST_CODE_CUSTOMER);
                break;
            case R.id.tender_change_province:
                showChooseMenu();
                break;
            case R.id.tender_change_bidtime:
                Tools.hideSoftInputFromWindow(mBidTime);
                mViewTimePicker.show();
                break;
            case R.id.tender_change_product:
                TenderApplicationProductListFragment.launchForResult(this, REQUEST_CODE_PRODUCT);
                break;
            case R.id.tender_change_bidproduct:
                TenderApplicationBidProductListFragment.launchForResult(this, REQUEST_CODE_BIDPRODUCT);
                break;
            case R.id.btn_commit:
                if (!checkInput()) {
                    return;
                }

                Commit();
                break;
        }
    }

    private void Commit(){
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
        requestBean.setEntityName("new_tenderauthorization");
        requestBean.setApprovalPrice("0");

        MarketActivityCreateRequestBean.WorkflowFormInfoBean workflowFormInfoBean = new MarketActivityCreateRequestBean.WorkflowFormInfoBean();
        workflowFormInfoBean.setAuditStatus("");
        workflowFormInfoBean.setOpinion("");
        workflowFormInfoBean.setStepNumber("");
        requestBean.setWorkflowFormInfo(workflowFormInfoBean);

        ArrayList<MarketActivityCreateRequestBean.FormInfoBean> arrayList = new ArrayList<>();
        MarketActivityCreateRequestBean.FormInfoBean formInfoBean1 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean1.setFieldValue(mProjectName);
        formInfoBean1.setFieldName("new_projectname");
        formInfoBean1.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean2 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean2.setFieldValue(mTenderCode);
        formInfoBean2.setFieldName("new_number");
        formInfoBean2.setFieldType("4");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean3 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean3.setFieldValue(mCustomerId);
        formInfoBean3.setFieldName("new_accountid");
        formInfoBean3.setFieldType("4");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean4 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean4.setFieldValue(mProvince.getText().toString());
        formInfoBean4.setFieldName("new_province");
        formInfoBean4.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean5 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean5.setFieldValue(mTenderCity);
        formInfoBean5.setFieldName("new_city");
        formInfoBean5.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean6 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean6.setFieldValue(mProductId);
        formInfoBean6.setFieldName("new_productclassifyid");
        formInfoBean6.setFieldType("4");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean7 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean7.setFieldValue(mBidProductId);
        formInfoBean7.setFieldName("new_productid");
        formInfoBean7.setFieldType("4");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean8 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean8.setFieldValue(mTenderEquipmentNumber);
        formInfoBean8.setFieldName("new_quantity");
        formInfoBean8.setFieldType("6");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean9 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean9.setFieldValue(mBidTime.getText().toString());
        formInfoBean9.setFieldName("new_opentenderstime");
        formInfoBean9.setFieldType("5");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean10 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean10.setFieldValue(mTenderAgency);
        formInfoBean10.setFieldName("new_tenderagency");
        formInfoBean10.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean11 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean11.setFieldValue(mCompanyName);
        formInfoBean11.setFieldName("new_empoweredname");
        formInfoBean11.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean12 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean12.setFieldValue(mWebSit);
        formInfoBean12.setFieldName("new_website");
        formInfoBean12.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean13 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean13.setFieldValue("");
        formInfoBean13.setFieldName("new_remark");
        formInfoBean13.setFieldType("2");

        arrayList.add(formInfoBean1);
        arrayList.add(formInfoBean2);
        arrayList.add(formInfoBean3);
        arrayList.add(formInfoBean4);
        arrayList.add(formInfoBean5);
        arrayList.add(formInfoBean6);
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
    private boolean checkInput() {
        mProjectName = mEtProjectName.getText().toString();
        mTenderCode = mEtTenderCode.getText().toString();
        mTenderCity = mEtTenderCity.getText().toString();
        mTenderEquipmentNumber = mEtTenderEquipmentNumber.getText().toString();
        mTenderAgency = mEtTenderAgency.getText().toString();
        mCompanyName = mEtCompanyName.getText().toString();
        mWebSit = mEtWebSit.getText().toString();

        if (TextUtils.isEmpty(mProjectName)) {
            ToastUtils.toast("请填写项目名称");
            return false;
        }

        if (TextUtils.isEmpty(mTenderCode)) {
            ToastUtils.toast("请填写招标编号");
            return false;
        }

        if("请选择客户".equals(mCustomer.getText().toString())){
            ToastUtils.toast("请选择客户");
            return false;
        }

        if("请选择省份".equals(mProvince.getText().toString())){
            ToastUtils.toast("请选择省份");
            return false;
        }

        if (TextUtils.isEmpty(mTenderCity)) {
            ToastUtils.toast("请填写地级市");
            return false;
        }

        if("请选择产品线".equals(mProduct.getText().toString())){
            ToastUtils.toast("请选择产品线");
            return false;
        }
        if("请选择投标产品".equals(mBidProduct.getText().toString())){
            ToastUtils.toast("请选择投标产品");
            return false;
        }
        if (TextUtils.isEmpty(mTenderEquipmentNumber)) {
            ToastUtils.toast("请填写设备数");
            return false;
        }

        if("请选择开标时间".equals(mBidTime.getText().toString())){
            ToastUtils.toast("请选择开标时间");
            return false;
        }

        if (TextUtils.isEmpty(mTenderAgency)) {
            ToastUtils.toast("请填写招标代理机构");
            return false;
        }

        if (TextUtils.isEmpty(mCompanyName)) {
            ToastUtils.toast("请填写单位名称");
            return false;
        }

        if (TextUtils.isEmpty(mWebSit)) {
            ToastUtils.toast("请填写网站");
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
            mCustomer.setText(data.getStringExtra(AccountListFragment.KEY_ACCOUNT_NAME));
            mCustomer.setTextColor(0xff333333);
            mCustomerId=data.getStringExtra(AccountListFragment.KEY_ACCOUNT_ID);
        }
        if(requestCode == REQUEST_CODE_PRODUCT && resultCode == Activity.RESULT_OK){
            mProduct.setText(data.getStringExtra(TenderApplicationProductListFragment.KEY_PRODUCT_NAME));
            mProduct.setTextColor(0xff333333);
            mProductId = data.getStringExtra(TenderApplicationProductListFragment.KEY_PRODUCT_ID);
        }
        if(requestCode == REQUEST_CODE_BIDPRODUCT && resultCode == Activity.RESULT_OK){
            mBidProduct.setText(data.getStringExtra(TenderApplicationBidProductListFragment.KEY_BIDPRODUCT_NAME));
            mBidProduct.setTextColor(0xff333333);
            mBidProductId = data.getStringExtra(TenderApplicationBidProductListFragment.KEY_BIDPRODUCT_ID);
        }

    }
}
