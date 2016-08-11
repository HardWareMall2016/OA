package com.android.wandong.ui.fragment.work;

/**
 * Created by ${keke} on 16/8/11.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.ui.widget.timePicker.TimePickerView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

import java.util.Calendar;
import java.util.Date;


public class MarketActivityCreateFragment extends ABaseFragment {

    @ViewInject(id = R.id.market_change_data,click = "OnClick")
    TextView mRlChangData;

    private long mOverdueTime=0;

    private TimePickerView mViewTimePicker;


    @Override
    protected int inflateContentView() {
        return R.layout.frag_market_activity_create;
    }

    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, MarketActivityCreateFragment.class, null);
    }
    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("市场活动费申请");

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
                    mOverdueTime=date.getTime();
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
        }
    }

}
