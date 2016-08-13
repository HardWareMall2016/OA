package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.ui.widget.timePicker.TimePickerView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.ui.widget.ActionSheetDialog;
import com.zhan.framework.utils.ToastUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ${keke} on 16/8/13.
 */
public class InspectionReceptionApplicationCreateFragment extends ABaseFragment {
    private static final int REQUEST_CODE_CUSTOMER=100;

    @ViewInject(id = R.id.imgAddPhoto,click = "OnClick")
    ImageView mAddPhoto ;
    @ViewInject(id = R.id.inspection_company_name,click = "OnClick")
    TextView mCompanyName;
    @ViewInject(id = R.id.inspection_visiting_time,click = "OnClick")
    TextView mVisitingTime ;
    @ViewInject(id = R.id.inspection_finish_time,click = "OnClick")
    TextView mFinishTime ;

    private long mOverdueTime=0;
    private TimePickerView mViewTimePicker;
    private TimePickerView mViewTimePickerFinish;

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
            //mCustomerId=data.getStringExtra(AccountListFragment.KEY_ACCOUNT_ID);
        }
    }
    void OnClick(View v) {
        switch (v.getId()){
            case R.id.imgAddPhoto:
                ActionSheetDialog actionSheetDialog=new ActionSheetDialog(getActivity());
                actionSheetDialog.builder();
                actionSheetDialog.addSheetItem("拍照", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener(){
                    @Override
                    public void onClick(int which) {

                    }
                });
                actionSheetDialog.addSheetItem("相册", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener(){
                    @Override
                    public void onClick(int which) {

                    }
                });

                actionSheetDialog.show();
                break;
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
        }
    }

}
