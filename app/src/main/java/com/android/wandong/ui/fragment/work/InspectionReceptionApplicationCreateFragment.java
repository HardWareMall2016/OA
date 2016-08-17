package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.MarketActivityCreateRequestBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.FixGridView;
import com.android.wandong.ui.widget.timePicker.TimePickerView;
import com.android.wandong.utils.ExtendMediaPicker;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.ui.widget.ActionSheetDialog;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ${keke} on 16/8/13.
 */
public class InspectionReceptionApplicationCreateFragment extends ABaseFragment implements ExtendMediaPicker.OnMediaPickerListener, AdapterView.OnItemClickListener {
    private static final int REQUEST_CODE_CUSTOMER = 100;

    @ViewInject(id = R.id.photos)
    FixGridView mFixGridView;

    @ViewInject(id = R.id.inspection_company_name, click = "OnClick")
    TextView mCompanyName;
    @ViewInject(id = R.id.et_inspection_phone)
    EditText mEtIspectionPhone;
    @ViewInject(id = R.id.inspection_visiting_time, click = "OnClick")
    TextView mVisitingTime;
    @ViewInject(id = R.id.inspection_finish_time, click = "OnClick")
    TextView mFinishTime;
    @ViewInject(id = R.id.et_inspection_content)
    EditText mEtInspectionContent;
    @ViewInject(id = R.id.et_inspection_peopleNum)
    EditText mEtInspectionPeopleNum;
    @ViewInject(id = R.id.btn_commit, click = "OnClick")
    Button mCommit;

    private ExtendMediaPicker mExtendMediaPicker;
    private LayoutInflater mInflater;
    private ArrayList<String> mMeidaUri = new ArrayList<>();
    private AttachmentAdapter mAdapter;

    private long mOverdueTime = 0;

    private String mCustomerId ;
    private TimePickerView mViewTimePicker;
    private TimePickerView mViewTimePickerFinish;
    private String mInspectionContent;
    private String mIspectionPhone;
    private String mInspectionPeopleNum;


    @Override
    protected int inflateContentView() {
        return R.layout.frag_inspection_reception_create;
    }

    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, InspectionReceptionApplicationCreateFragment.class, null);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("考察接待申请");
        initTimePickerVisiting();
        initTimePickerfinish();

        mExtendMediaPicker = new ExtendMediaPicker(getActivity());
        mExtendMediaPicker.setOnMediaPickerListener(this);

        mInflater=inflater;
        //图片,最后一个表示添加
        mMeidaUri.clear();
        mMeidaUri.add("add_new");
        mAdapter = new AttachmentAdapter(mMeidaUri,getActivity());
        mFixGridView.setAdapter(mAdapter);
        mFixGridView.setOnItemClickListener(this);
    }

    private void initTimePickerVisiting() {
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
                    mVisitingTime.setText(Tools.parseTimeToDateStr(mOverdueTime));
                }
            }
        });
    }

    private void initTimePickerfinish() {
        mViewTimePickerFinish = new TimePickerView(getActivity(), TimePickerView.Type.YEAR_MONTH_DAY);
        Calendar calendar = Calendar.getInstance();
        mViewTimePickerFinish.setRange(calendar.get(Calendar.YEAR), calendar.get(Calendar.YEAR) + 100);
        mViewTimePickerFinish.setTime(new Date());
        mViewTimePickerFinish.setCyclic(false);
        mViewTimePickerFinish.setCancelable(true);
        //时间选择后回调
        mViewTimePickerFinish.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date) {
                Date curDate = new Date();
                boolean beforeDate = date.before(curDate);
                if (beforeDate) {
                    ToastUtils.toast("请选择晚于今天的日期");
                } else {
                    mOverdueTime = date.getTime();
                    mFinishTime.setText(Tools.parseTimeToDateStr(mOverdueTime));
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CUSTOMER && resultCode == Activity.RESULT_OK) {
            mCompanyName.setText(data.getStringExtra(AccountListFragment.KEY_ACCOUNT_NAME));
            mCompanyName.setTextColor(0xff333333);
            mCustomerId=data.getStringExtra(AccountListFragment.KEY_ACCOUNT_ID);
        }

        mExtendMediaPicker.onActivityResult(requestCode, resultCode, data);
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.inspection_company_name:
                InspectionReceptionListFragment.launchForResult(this, REQUEST_CODE_CUSTOMER);
                break;
            case R.id.inspection_visiting_time:
                Tools.hideSoftInputFromWindow(mVisitingTime);
                mViewTimePicker.show();
                break;
            case R.id.inspection_finish_time:
                Tools.hideSoftInputFromWindow(mFinishTime);
                mViewTimePickerFinish.show();
                break;
            case R.id.btn_commit:
                if (!checkInput()) {
                    return;
                }
                Commit();
                break;
        }
    }

    @Override
    public void onSelectedMediaChanged(String mediaUri) {
        mMeidaUri.add(0, mediaUri);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mMeidaUri.size()-1==position){
            ActionSheetDialog actionSheetDialog = new ActionSheetDialog(getActivity());
            actionSheetDialog.builder();
            actionSheetDialog.addSheetItem("拍照", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                @Override
                public void onClick(int which) {
                    mExtendMediaPicker.openSystemCamera(InspectionReceptionApplicationCreateFragment.this);
                }
            });
            actionSheetDialog.addSheetItem("相册", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                @Override
                public void onClick(int which) {
                    mExtendMediaPicker.openSystemPickImage(InspectionReceptionApplicationCreateFragment.this);
                }
            });
            actionSheetDialog.show();
        }
    }

    private class AttachmentAdapter extends ABaseAdapter<String> {
        public AttachmentAdapter(ArrayList<String> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<String> newItemView() {
            return new AttachmentItemView();
        }
    }

    private class AttachmentItemView extends ABaseAdapter.AbstractItemView<String> {
        @ViewInject(id = R.id.attachment)
        ImageView mViewAttachment;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_common_attachment;
        }

        @Override
        public void bindingData(View convertView, String data) {
            if(getPosition()==getSize()-1){
                ImageLoader.getInstance().displayImage("drawable://" + R.drawable.icon_sign_in_add_photo, mViewAttachment, Tools.buildDefDisplayImgOptions());
            } else {
                ImageLoader.getInstance().displayImage("file://"+data, mViewAttachment, Tools.buildDefDisplayImgOptions());
            }
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
        requestBean.setEntityName("new_reception");
        requestBean.setApprovalPrice("0");

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
        formInfoBean2.setFieldValue(mInspectionContent);
        formInfoBean2.setFieldName("new_visitname");
        formInfoBean2.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean3 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean3.setFieldValue(mIspectionPhone);
        formInfoBean3.setFieldName("new_visittelephone");
        formInfoBean3.setFieldType("2");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean4 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean4.setFieldValue(mVisitingTime.getText().toString());
        formInfoBean4.setFieldName("new_cometime");
        formInfoBean4.setFieldType("5");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean5 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean5.setFieldValue(mFinishTime.getText().toString());
        formInfoBean5.setFieldName("new_leavetime");
        formInfoBean5.setFieldType("5");

        MarketActivityCreateRequestBean.FormInfoBean formInfoBean6 = new MarketActivityCreateRequestBean.FormInfoBean();
        formInfoBean6.setFieldValue(mInspectionPeopleNum);
        formInfoBean6.setFieldName("new_visitnumber");
        formInfoBean6.setFieldType("6");


        arrayList.add(formInfoBean1);
        arrayList.add(formInfoBean2);
        arrayList.add(formInfoBean3);
        arrayList.add(formInfoBean4);
        arrayList.add(formInfoBean5);
        arrayList.add(formInfoBean6);

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
        mInspectionContent = mEtInspectionContent.getText().toString();
        mIspectionPhone = mEtIspectionPhone.getText().toString();
        mInspectionPeopleNum = mEtInspectionPeopleNum.getText().toString();


        if ("请选择客户名称".equals(mCompanyName.getText().toString())) {
            ToastUtils.toast("请选择客户名称");
            return false;
        }
        if (TextUtils.isEmpty(mInspectionContent)) {
            ToastUtils.toast("请填写来访者姓名");
            return false;
        }

        if (TextUtils.isEmpty(mIspectionPhone)) {
            ToastUtils.toast("请填写电话");
            return false;
        }

        if ("请选择到访时间".equals(mVisitingTime.getText().toString())) {
            ToastUtils.toast("请选择到访时间");
            return false;
        }
        if ("请选择结束时间".equals(mFinishTime.getText().toString())) {
            ToastUtils.toast("请选择结束时间");
            return false;
        }

        if (TextUtils.isEmpty(mInspectionPeopleNum)) {
            ToastUtils.toast("请填写来访人数");
            return false;
        }

        return true;
    }


    }
