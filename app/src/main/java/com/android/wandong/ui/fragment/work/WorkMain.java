package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.ui.fragment.work.Tools.WorkTabUtils;
import com.android.wandong.ui.widget.FixGridView;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.AStripTabsFragment;

import java.io.Serializable;
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
public class WorkMain extends AStripTabsFragment<WorkMain.WorkCategoryItem> implements AdapterView.OnItemClickListener {

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
    private ArrayList<WorkMain.WorkCategoryItem> mTabs = new ArrayList<>();

    private CategoryAdapter mAdapter;

    private WorkCreateNewWorkDialogHelper mWorkCreateNewWorkDialogHelper;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_main;
    }

    @Override
    protected ArrayList<WorkMain.WorkCategoryItem> generateTabs() {
        WorkTabUtils workTabUtils=new WorkTabUtils();
        mTabs= workTabUtils.generateTabs();
        return mTabs;
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mAdapter = new CategoryAdapter(mTabs, getActivity());
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);
        mWorkCreateNewWorkDialogHelper = new WorkCreateNewWorkDialogHelper(getActivity(), mTabs);
    }

    @Override
    protected Fragment newFragment(WorkCategoryItem bean) {
        try {
            return bean.fragmentClass.newInstance();
        } catch (Exception ignored) {

        }
        return new TempFragment();
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.nav_add:
                mWorkCreateNewWorkDialogHelper.showDialog();
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

    private class CategoryAdapter extends ABaseAdapter<WorkMain.WorkCategoryItem> {

        public CategoryAdapter(ArrayList<WorkCategoryItem> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<WorkCategoryItem> newItemView() {
            return new CategoryViewTime();
        }
    }

    private class CategoryViewTime extends ABaseAdapter.AbstractItemView<WorkCategoryItem> {
        @ViewInject(id = R.id.category)
        TextView mViewCategory;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_work_category;
        }

        @Override
        public void bindingData(View convertView, WorkCategoryItem data) {
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

    public static class WorkCategoryItem extends AStripTabsFragment.StripTabItem implements Serializable{

        private static final long serialVersionUID = 4445471397225331685L;

        private int categoryDrawableRes;

        private Class<? extends Fragment> fragmentClass;

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        public void setFragmentClass(Class<? extends Fragment> fragmentClass) {
            this.fragmentClass = fragmentClass;
        }

        public int getCategoryDrawableRes() {
            return categoryDrawableRes;
        }

        public void setCategoryDrawableRes(int categoryDrawableRes) {
            this.categoryDrawableRes = categoryDrawableRes;
        }
    }

}
