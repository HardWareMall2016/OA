package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.ui.widget.ScrollableViewPager;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.activity.BaseActivity;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.PixelUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/7/27 21:28
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
public class ReportFormReimbursement extends ABaseFragment implements ViewPager.OnPageChangeListener {

    @ViewInject(id = R.id.pager)
    protected ScrollableViewPager mViewPager;

    private TextView mTabCard;
    private TextView mTabDetails;

    private List<Fragment> mFragments;

    public static void launch(Activity activity) {
        FragmentContainerActivity.launch(activity, ReportFormReimbursement.class, null);
    }

    @Override
    public void onPrepareSetContentView(BaseActivity activity) {
        activity.setStatusbarBackgroundColor(Color.BLACK);
    }

    @Override
    public void onPrepareActionbarMenu(TextView menu, Activity activity) {
        super.onPrepareActionbarMenu(menu, activity);
        if(activity instanceof BaseActivity ){
            BaseActivity baseActivity=(BaseActivity)activity;
            baseActivity.setActionbarBackgroundColor(Color.WHITE);
        }
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_common_view_pager_layout;
    }

    @Override
    public void onCreateCustomActionbarBar(FrameLayout customerContent, Activity activity) {
        LayoutInflater layoutInflater =activity.getLayoutInflater();
        View viewHeader=layoutInflater.inflate(R.layout.header_reimbursement,null);
        viewHeader.findViewById(R.id.go_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        mTabCard=(TextView) viewHeader.findViewById(R.id.tab_card);
        mTabDetails=(TextView) viewHeader.findViewById(R.id.tab_details);
        mTabCard.setOnClickListener(mTabClick);
        mTabDetails.setOnClickListener(mTabClick);

        customerContent.addView(viewHeader);
    }

    private View.OnClickListener mTabClick=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tab_card:
                    mTabCard.setBackgroundResource(R.drawable.bg_left_rounded_selected_selector);
                    mTabDetails.setBackgroundResource(R.drawable.bg_right_rounded_unselected_selector);
                    mTabCard.setTextColor(Color.WHITE);
                    mTabDetails.setTextColor(0xff999999);
                    mViewPager.setCurrentItem(0);
                    break;
                case R.id.tab_details:
                    mTabCard.setBackgroundResource(R.drawable.bg_left_rounded_unselected_selector);
                    mTabDetails.setBackgroundResource(R.drawable.bg_right_rounded_selected_selector);
                    mTabCard.setTextColor(0xff999999);
                    mTabDetails.setTextColor(Color.WHITE);
                    mViewPager.setCurrentItem(1);
                    break;
            }
        }
    };


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);

        getRootView().setPadding(0, PixelUtils.dp2px(16),0,0);

        //mViewPager.setCanScroll(false);
        mFragments=new ArrayList<>();
        mFragments.add(new ReportFormCardFragment());
        mFragments.add(new ReportFormReimbursementDetails());
        MyViewPagerAdapter adapter=new MyViewPagerAdapter(getFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(this);
        //mViewPager.requestDisallowInterceptTouchEvent(true);?><
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==0){
            mTabCard.setBackgroundResource(R.drawable.bg_left_rounded_selected_selector);
            mTabDetails.setBackgroundResource(R.drawable.bg_right_rounded_unselected_selector);
            mTabCard.setTextColor(Color.WHITE);
            mTabDetails.setTextColor(0xff999999);
        }else{
            mTabCard.setBackgroundResource(R.drawable.bg_left_rounded_unselected_selector);
            mTabDetails.setBackgroundResource(R.drawable.bg_right_rounded_selected_selector);
            mTabCard.setTextColor(0xff999999);
            mTabDetails.setTextColor(Color.WHITE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter{

       public MyViewPagerAdapter(FragmentManager fm) {
           super(fm);
       }

       @Override
       public Fragment getItem(int position) {
           return mFragments.get(position);
       }

       @Override
       public int getCount() {
           return mFragments.size();
       }
   }

}
