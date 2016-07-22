package com.android.wandong.ui.fragment.work;
import android.support.v4.app.Fragment;

import com.android.wandong.R;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.ui.fragment.AStripTabsFragment;

import java.util.ArrayList;

/**
 * 作者：伍岳 on 2016/7/9 21:46
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
public class WorkMain extends AStripTabsFragment {

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_main;
    }

    @Override
    protected ArrayList generateTabs() {
        ArrayList<AStripTabsFragment.StripTabItem> tabs=new ArrayList<AStripTabsFragment.StripTabItem>();

        AStripTabsFragment.StripTabItem item1=new AStripTabsFragment.StripTabItem();
        item1.setTitle(OutdoorSignInFragment.TAB_NAME);
        item1.setType(OutdoorSignInFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item2=new AStripTabsFragment.StripTabItem();
        item2.setTitle(WorkReportListFragment.TAB_NAME);
        item2.setType(WorkReportListFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item3=new AStripTabsFragment.StripTabItem();
        item3.setTitle(AnnouncementFragment.TAB_NAME);
        item3.setType(AnnouncementFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item4=new AStripTabsFragment.StripTabItem();
        item4.setTitle(NoticeFragment.TAB_NAME);
        item4.setType(NoticeFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item5=new AStripTabsFragment.StripTabItem();
        item5.setTitle(ReportListFragment.TAB_NAME);
        item5.setType(ReportListFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item6=new AStripTabsFragment.StripTabItem();
        item6.setTitle("合同申请");
        item6.setType("Type6");

        AStripTabsFragment.StripTabItem item7=new AStripTabsFragment.StripTabItem();
        item7.setTitle("招投标申请");
        item7.setType("Type7");

        AStripTabsFragment.StripTabItem item8=new AStripTabsFragment.StripTabItem();
        item8.setTitle("考察接待申请");
        item8.setType("Type8");

        AStripTabsFragment.StripTabItem item9=new AStripTabsFragment.StripTabItem();
        item9.setTitle("考招待费申请");
        item9.setType("Type9");

        AStripTabsFragment.StripTabItem item10=new AStripTabsFragment.StripTabItem();
        item10.setTitle("考招待费申请");
        item10.setType("Type9");

        AStripTabsFragment.StripTabItem item11=new AStripTabsFragment.StripTabItem();
        item11.setTitle("考招待费申请");
        item11.setType("Type9");

        tabs.add(item1);
        tabs.add(item2);
        tabs.add(item3);
        tabs.add(item4);
        tabs.add(item5);
        tabs.add(item6);
        tabs.add(item7);
        tabs.add(item8);
        tabs.add(item9);
        tabs.add(item10);
        tabs.add(item11);

        return tabs;
    }

    @Override
    protected Fragment newFragment(StripTabItem bean) {
        if(bean.getType().equals(OutdoorSignInFragment.TAB_TYPE)){
            return new OutdoorSignInFragment();
        }else  if(bean.getType().equals(WorkReportListFragment.TAB_TYPE)){
            return new WorkReportListFragment();
        } else  if(bean.getType().equals(AnnouncementFragment.TAB_TYPE)){
            return new AnnouncementFragment();
        }else  if(bean.getType().equals(NoticeFragment.TAB_TYPE)){
            return new NoticeFragment();
        }else  if(bean.getType().equals(ReportListFragment.TAB_TYPE)){
            return new ReportListFragment();
        }
        return new TempFragment();
    }
}
