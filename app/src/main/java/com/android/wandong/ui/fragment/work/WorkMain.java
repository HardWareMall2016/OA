package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.ui.widget.FixGridView;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
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
public class WorkMain extends AStripTabsFragment implements AdapterView.OnItemClickListener {

    @ViewInject(id = R.id.nav_add, click = "OnClick")
    View mViewNavAdd;

    @ViewInject(id = R.id.filter, click = "OnClick")
    View mViewFilter;

    @ViewInject(id = R.id.cover, click = "OnClick")
    View mViewCover;

    @ViewInject(id = R.id.category_menu, click = "OnClick")
    View mViewCategoryMenu;

    @ViewInject(id = R.id.gridView)
    FixGridView mGridView;

    //data
    private ArrayList<AStripTabsFragment.StripTabItem> mTabs = new ArrayList<>();

    private CategoryAdapter mAdapter;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_main;
    }

    @Override
    protected ArrayList generateTabs() {

        mTabs.clear();

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

        mTabs.add(item1);
        mTabs.add(item2);
        mTabs.add(item3);
        mTabs.add(item4);
        mTabs.add(item5);
        mTabs.add(item6);
        mTabs.add(item7);
        mTabs.add(item8);
        mTabs.add(item9);
        mTabs.add(item10);
        mTabs.add(item11);
        mTabs.add(item12);
        mTabs.add(item13);
        mTabs.add(item14);

        return mTabs;
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mAdapter = new CategoryAdapter(mTabs, getActivity());
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);
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
        } else if (bean.getType().equals(InspectionReceptionApplicationFragment.TAB_TYPE)) {
            return new InspectionReceptionApplicationFragment();
        } else if (bean.getType().equals(EntertainmentApplicationFragment.TAB_TYPE)) {
            return new EntertainmentApplicationFragment();
        } else if (bean.getType().equals(MarketActivityApplicationFragment.TAB_TYPE)) {
            return new MarketActivityApplicationFragment();
        } else if (bean.getType().equals(TravelExpenseReimbursementFragment.TAB_TYPE)) {
            return new TravelExpenseReimbursementFragment();
        } else if (bean.getType().equals(SpecialDuesReimbursementFragment.TAB_TYPE)) {
            return new SpecialDuesReimbursementFragment();
        } else if (bean.getType().equals(EntertainmentReimbursementFragment.TAB_TYPE)) {
            return new EntertainmentReimbursementFragment();
        } else if (bean.getType().equals(MarketActivityReimbursementFragment.TAB_TYPE)) {
            return new MarketActivityReimbursementFragment();
        }
        return new TempFragment();
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.nav_add:
                break;
            case R.id.filter:
                break;
            case R.id.cover:
                hideCategoryMenu();
                break;
            case R.id.category_menu:
                if (mGridView.getVisibility() == View.GONE) {
                    showCategoryMenu();
                } else {
                    hideCategoryMenu();
                }
                break;
        }
    }

    private void showCategoryMenu() {
        if (mGridView.getVisibility() == View.GONE) {
            mAdapter.notifyDataSetChanged();
            mGridView.setVisibility(View.VISIBLE);
            mViewCover.setVisibility(View.VISIBLE);
        }
    }

    private void hideCategoryMenu() {
        if (mGridView.getVisibility() == View.VISIBLE) {
            mGridView.setVisibility(View.GONE);
            mViewCover.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        hideCategoryMenu();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        getViewPager().setCurrentItem(position);
    }

    private class CategoryAdapter extends ABaseAdapter<AStripTabsFragment.StripTabItem> {

        public CategoryAdapter(ArrayList<StripTabItem> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<StripTabItem> newItemView() {
            return new CategoryViewTime();
        }
    }

    private class CategoryViewTime extends ABaseAdapter.AbstractItemView<StripTabItem> {
        @ViewInject(id = R.id.category)
        TextView mViewCategory;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_work_category;
        }

        @Override
        public void bindingData(View convertView, StripTabItem data) {
            mViewCategory.setText(data.getTitle());

            if (getPosition() == getViewPager().getCurrentItem()) {
                mViewCategory.setBackgroundResource(R.drawable.bg_work_category_checked_selector);
                mViewCategory.setTextColor(Color.WHITE);
            } else {
                mViewCategory.setBackgroundResource(R.drawable.bg_work_category_unchecked_selector);
                mViewCategory.setTextColor(0xff333333);
            }
        }
    }
}
