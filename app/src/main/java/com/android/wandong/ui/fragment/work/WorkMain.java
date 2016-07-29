package com.android.wandong.ui.fragment.work;

import android.support.v4.app.Fragment;

import com.android.wandong.R;
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
        ArrayList<AStripTabsFragment.StripTabItem> tabs = new ArrayList<AStripTabsFragment.StripTabItem>();

        AStripTabsFragment.StripTabItem item1 = new AStripTabsFragment.StripTabItem();
        item1.setTitle(OutdoorSignInFragment.TAB_NAME);
        item1.setType(OutdoorSignInFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item2 = new AStripTabsFragment.StripTabItem();
        item2.setTitle(WorkReportListFragment.TAB_NAME);
        item2.setType(WorkReportListFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item3 = new AStripTabsFragment.StripTabItem();
        item3.setTitle(AnnouncementFragment.TAB_NAME);
        item3.setType(AnnouncementFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item4 = new AStripTabsFragment.StripTabItem();
        item4.setTitle(NoticeFragment.TAB_NAME);
        item4.setType(NoticeFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item5 = new AStripTabsFragment.StripTabItem();
        item5.setTitle(ReportFormListFragment.TAB_NAME);
        item5.setType(ReportFormListFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item6 = new AStripTabsFragment.StripTabItem();
        item6.setTitle(ContractApplicationFragment.TAB_NAME);
        item6.setType(ContractApplicationFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item7 = new AStripTabsFragment.StripTabItem();
        item7.setTitle(TenderApplicationFragment.TAB_NAME);
        item7.setType(TenderApplicationFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item8 = new AStripTabsFragment.StripTabItem();
        item8.setTitle(InspectionReceptionApplicationFragment.TAB_NAME);
        item8.setType(InspectionReceptionApplicationFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item9 = new AStripTabsFragment.StripTabItem();
        item9.setTitle(EntertainmentApplicationFragment.TAB_NAME);
        item9.setType(EntertainmentApplicationFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item10 = new AStripTabsFragment.StripTabItem();
        item10.setTitle(MarketActivityApplicationFragment.TAB_NAME);
        item10.setType(MarketActivityApplicationFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item11 = new AStripTabsFragment.StripTabItem();
        item11.setTitle(TravelExpenseReimbursementFragment.TAB_NAME);
        item11.setType(TravelExpenseReimbursementFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item12 = new AStripTabsFragment.StripTabItem();
        item12.setTitle(SpecialDuesReimbursementFragment.TAB_NAME);
        item12.setType(SpecialDuesReimbursementFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item13 = new AStripTabsFragment.StripTabItem();
        item13.setTitle(EntertainmentReimbursementFragment.TAB_NAME);
        item13.setType(EntertainmentReimbursementFragment.TAB_TYPE);

        AStripTabsFragment.StripTabItem item14 = new AStripTabsFragment.StripTabItem();
        item14.setTitle(MarketActivityReimbursementFragment.TAB_NAME);
        item14.setType(MarketActivityReimbursementFragment.TAB_TYPE);

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
        tabs.add(item12);
        tabs.add(item13);
        tabs.add(item14);

        return tabs;
    }

    @Override
    protected Fragment newFragment(StripTabItem bean) {
        if (bean.getType().equals(OutdoorSignInFragment.TAB_TYPE)) {
            return new OutdoorSignInFragment();
        } else if (bean.getType().equals(WorkReportListFragment.TAB_TYPE)) {
            return new WorkReportListFragment();
        } else if (bean.getType().equals(AnnouncementFragment.TAB_TYPE)) {
            return new AnnouncementFragment();
        } else if (bean.getType().equals(NoticeFragment.TAB_TYPE)) {
            return new NoticeFragment();
        } else if (bean.getType().equals(ReportFormListFragment.TAB_TYPE)) {
            return new ReportFormListFragment();
        } else if (bean.getType().equals(ContractApplicationFragment.TAB_TYPE)) {
            return new ContractApplicationFragment();
        } else if (bean.getType().equals(TenderApplicationFragment.TAB_TYPE)) {
            return new TenderApplicationFragment();
        }else if (bean.getType().equals(InspectionReceptionApplicationFragment.TAB_TYPE)) {
            return new InspectionReceptionApplicationFragment();
        }else if (bean.getType().equals(EntertainmentApplicationFragment.TAB_TYPE)) {
            return new EntertainmentApplicationFragment();
        }else if (bean.getType().equals(MarketActivityApplicationFragment.TAB_TYPE)) {
            return new MarketActivityApplicationFragment();
        }else if (bean.getType().equals(TravelExpenseReimbursementFragment.TAB_TYPE)) {
            return new TravelExpenseReimbursementFragment();
        }else if (bean.getType().equals(SpecialDuesReimbursementFragment.TAB_TYPE)) {
            return new SpecialDuesReimbursementFragment();
        }else if (bean.getType().equals(EntertainmentReimbursementFragment.TAB_TYPE)) {
            return new EntertainmentReimbursementFragment();
        }else if (bean.getType().equals(MarketActivityReimbursementFragment.TAB_TYPE)) {
            return new MarketActivityReimbursementFragment();
        }
        return new TempFragment();
    }
}
