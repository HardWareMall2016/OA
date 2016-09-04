package com.android.wandong.ui.fragment.work.Tools;

import android.text.TextUtils;

import com.android.wandong.R;
import com.android.wandong.model.work.WorkMenu;
import com.android.wandong.ui.fragment.work.AnnouncementFragment;
import com.android.wandong.ui.fragment.work.ContractApplicationFragment;
import com.android.wandong.ui.fragment.work.EntertainmentApplicationFragment;
import com.android.wandong.ui.fragment.work.EntertainmentReimbursementFragment;
import com.android.wandong.ui.fragment.work.InspectionReceptionApplicationFragment;
import com.android.wandong.ui.fragment.work.MarketActivityApplicationFragment;
import com.android.wandong.ui.fragment.work.MarketActivityReimbursementFragment;
import com.android.wandong.ui.fragment.work.MyAuditListFragment;
import com.android.wandong.ui.fragment.work.ShareFragment;
import com.android.wandong.ui.fragment.work.OutdoorSignInFragment;
import com.android.wandong.ui.fragment.work.SpecialDuesReimbursementFragment;
import com.android.wandong.ui.fragment.work.TenderApplicationFragment;
import com.android.wandong.ui.fragment.work.TravelExpenseReimbursementFragment;
import com.android.wandong.ui.fragment.work.WorkMain;
import com.android.wandong.ui.fragment.work.WorkReportListFragment;
import java.util.ArrayList;

/**
 * 作者：伍岳 on 2016/8/19 22:37
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
public class WorkTabUtils {

    private static String NEW_BACKLOG = "new_backlog";//待我审批
    private static String NEW_SIGNIN = "new_signin";//外勤签到
    private static String NEW_WORKREPORT = "new_workreport";//工作报告
    private static String NEW_NOTICEINFO = "new_noticeinfo";//公告
    private static String NEW_SHARE = "new_share";//分享
    private static String NEW_CONTRACT = "new_contract";//合同申请
    private static String NEW_TENDERAUTHORIZATION = "new_tenderauthorization";//招投标申请
    private static String NEW_RECEPTION = "new_reception";//考察接待申请
    private static String NEW_ENTERTAIN = "new_entertain";//招待费申请
    private static String NEW_CAMPAIGN = "new_campaign";//市场活动费申请
    private static String NEW_TRAVELCOST = "new_travelcost";//差旅费报销
    private static String NEW_SPECIAL_PAYMENT = "new_special_payment";//专项费报销
    private static String NEW_ENTERTAINCOST = "new_entertaincost";//招待费报销
    private static String NEW_CAMPAIGNCOST = "new_campaigncost";//市场活动费用报销

    //private static String new_backlog="new_backlog";//报表

    private ArrayList<WorkMain.WorkCategoryItem> mTabs = new ArrayList<>();

    public ArrayList<WorkMain.WorkCategoryItem> generateTabs() {
        WorkMenu workMenu = WorkMenu.getInstance();

        mTabs.clear();

        WorkMain.WorkCategoryItem item = null;

        for (WorkMenu.MenuItem menuItem : workMenu.getMenuItemList()) {
            if(TextUtils.isEmpty(menuItem.getEntityName())){
                continue;
            }

            if (menuItem.getEntityName().equals(NEW_BACKLOG)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(MyAuditListFragment.TAB_NAME);
                item.setType(MyAuditListFragment.TAB_TYPE);
                //item.setCategoryDrawableRes(R.drawable.icon_category_wqqd);
                item.setFragmentClass(MyAuditListFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_SIGNIN)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(OutdoorSignInFragment.TAB_NAME);
                item.setType(OutdoorSignInFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_wqqd);
                item.setFragmentClass(OutdoorSignInFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_WORKREPORT)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(WorkReportListFragment.TAB_NAME);
                item.setType(WorkReportListFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_gzbg);
                item.setFragmentClass(WorkReportListFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_NOTICEINFO)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(AnnouncementFragment.TAB_NAME);
                item.setType(AnnouncementFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_gg);
                item.setFragmentClass(AnnouncementFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_SHARE)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(ShareFragment.TAB_NAME);
                item.setType(ShareFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_tz);
                item.setFragmentClass(ShareFragment.class);
                mTabs.add(item);
            }

        /*if(workMenu.getMenuByEntityName(NEW_SIGNIN)!=null) {
            item = new WorkMain.WorkCategoryItem();
            item.setTitle(ReportFormListFragment.TAB_NAME);
            item.setType(ReportFormListFragment.TAB_TYPE);
            item.setCategoryDrawableRes(R.drawable.icon_category_bb);
            item.setFragmentClass(ReportFormListFragment.class);
            mTabs.add(item);
        }*/

            if (menuItem.getEntityName().equals(NEW_CONTRACT)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(ContractApplicationFragment.TAB_NAME);
                item.setType(ContractApplicationFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_htsq);
                item.setFragmentClass(ContractApplicationFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_TENDERAUTHORIZATION)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(TenderApplicationFragment.TAB_NAME);
                item.setType(TenderApplicationFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_ztbsq);
                item.setFragmentClass(TenderApplicationFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_RECEPTION)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(InspectionReceptionApplicationFragment.TAB_NAME);
                item.setType(InspectionReceptionApplicationFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_kcjdsq);
                item.setFragmentClass(InspectionReceptionApplicationFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_ENTERTAIN)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(EntertainmentApplicationFragment.TAB_NAME);
                item.setType(EntertainmentApplicationFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_zdfsq);
                item.setFragmentClass(EntertainmentApplicationFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_CAMPAIGN)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(MarketActivityApplicationFragment.TAB_NAME);
                item.setType(MarketActivityApplicationFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_schdfsq);
                item.setFragmentClass(MarketActivityApplicationFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_TRAVELCOST)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(TravelExpenseReimbursementFragment.TAB_NAME);
                item.setType(TravelExpenseReimbursementFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_clfbx);
                item.setFragmentClass(TravelExpenseReimbursementFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_SPECIAL_PAYMENT)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(SpecialDuesReimbursementFragment.TAB_NAME);
                item.setType(SpecialDuesReimbursementFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_zxfbx);
                item.setFragmentClass(SpecialDuesReimbursementFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_ENTERTAINCOST)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(EntertainmentReimbursementFragment.TAB_NAME);
                item.setType(EntertainmentReimbursementFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_zdfbx);
                item.setFragmentClass(EntertainmentReimbursementFragment.class);
                mTabs.add(item);
            }

            if (menuItem.getEntityName().equals(NEW_CAMPAIGNCOST)) {
                item = new WorkMain.WorkCategoryItem();
                item.setTitle(MarketActivityReimbursementFragment.TAB_NAME);
                item.setType(MarketActivityReimbursementFragment.TAB_TYPE);
                item.setCategoryDrawableRes(R.drawable.icon_category_schdfbx);
                item.setFragmentClass(MarketActivityReimbursementFragment.class);
                mTabs.add(item);
            }
        }

        return mTabs;
    }

}
