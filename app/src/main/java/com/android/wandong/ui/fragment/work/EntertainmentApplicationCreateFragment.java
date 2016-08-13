package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.ui.widget.timePicker.TimePickerView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

import java.util.Calendar;
import java.util.Date;

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

    @ViewInject(id = R.id.tainment_creat_chang_data,click = "OnClick")
    TextView mChangeData ;

    private long mOverdueTime=0;

    private TimePickerView mViewTimePicker;

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
        }
    }


}
