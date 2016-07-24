package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.android.wandong.R;
import com.android.wandong.ui.widget.calendar.CalendarCard;
import com.android.wandong.ui.widget.calendar.CardGridItem;
import com.android.wandong.ui.widget.calendar.OnCellItemClick;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 作者：伍岳 on 2016/7/23 23:32
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
public class WorkReportCalendarFragment extends ABaseFragment {

    /*@ViewInject(id = R.id.calendarCard1)
    protected CalendarCard mCalendarCard;*/

    public static void launch(Activity activity) {
        /*FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, id);*/
        FragmentContainerActivity.launch(activity, WorkReportCalendarFragment.class, null);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_report_calendar;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("日报详情");

        /*mCalendarCard.setOnCellItemClick(new OnCellItemClick() {
            @Override
            public void onCellClick(View v, CardGridItem item) {
                String dateStr= new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(item.getDate().getTime());
                ToastUtils.toast(dateStr);
            }
        });*/
    }

}
