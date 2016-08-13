package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.ui.widget.timePicker.TimePickerView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.ui.fragment.ARefreshFragment;
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

    @ViewInject(id = R.id.mylesson_picker_view)
    LoopView mPickView;

    private View mChangLessonPopMenuContent;
    private long mOverdueTime=0;
    private TimePickerView mViewTimePicker;
    private PopupWindow mPopupWindow;

    private List<String> province_list = new ArrayList<>();
    private  int type = 1 ;

    public static void launch(Activity activity) {
        FragmentArgs args = new FragmentArgs();
        //args.add(ARG_KEY, signId);
        FragmentContainerActivity.launch(activity, EntertainmentApplicationCreateFragment.class, args);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_enter_tainment_create;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mSignId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putSerializable(ARG_KEY, mSignId);
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
        }
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
           // mCustomerId=data.getStringExtra(AccountListFragment.KEY_ACCOUNT_ID);
        }
    }
}
