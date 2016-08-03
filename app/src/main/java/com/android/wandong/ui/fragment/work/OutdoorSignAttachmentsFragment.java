package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.ui.widget.CircleView;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.internal.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.activity.BaseActivity;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.PixelUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * 作者：伍岳 on 2016/7/23 12:13
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
public class OutdoorSignAttachmentsFragment extends ABaseFragment implements PhotoViewAttacher.OnPhotoTapListener {
    private final static String ARG_KEY = "arg_key";
    //private final static String ARG_KEY_POS = "arg_key_pos";

    @ViewInject(id = R.id.view_pager)
    ViewPager mViewPager;

    @ViewInject(id = R.id.indicator)
    LinearLayout mContainerIndicator;

    @ViewInject(id = R.id.location)
    TextView mViewTime;

    //data
    private ParamsBean mParamsBean;

    public static class ParamsBean implements Serializable{
        public List<String> photos;
        public int showPos;
        public long time;
        public String address;
    }

    public static void launch(Activity activity, ParamsBean bean) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, bean);
        FragmentContainerActivity.launch(activity, OutdoorSignAttachmentsFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParamsBean = savedInstanceState == null ? (ParamsBean) getArguments().getSerializable(ARG_KEY) : (ParamsBean) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mParamsBean);
    }

    @Override
    public void onPrepareSetContentView(BaseActivity activity) {
        activity.setOverlay(true);
        activity.showActionbar(false);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_outdoor_sign_attachments;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        mViewPager.setAdapter(new SamplePagerAdapter());

        Tools.setTextView(mViewTime,mParamsBean.address);

        if (mParamsBean.showPos < mParamsBean.photos.size() && mParamsBean.showPos >= 0) {
            mViewPager.setCurrentItem(mParamsBean.showPos);

            for(int i=0;i<mParamsBean.photos.size();i++){
                CircleView circleView=new CircleView(getActivity());
                if(mParamsBean.showPos==i){
                    circleView.setDrawColor(Color.WHITE);
                }else{
                    circleView.setDrawColor(0xff525252);
                }
                circleView.setRoundWidth(PixelUtils.dp2px(8));
                LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
                circleView.setLayoutParams(lp);
                if(i!=0){
                    lp.leftMargin=PixelUtils.dp2px(8);
                }
                mContainerIndicator.addView(circleView);
            }

            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    for(int i=0;i<mContainerIndicator.getChildCount();i++){
                        CircleView circleView= (CircleView) mContainerIndicator.getChildAt(i);
                        if(position==i){
                            circleView.setDrawColor(Color.WHITE);
                        }else{
                            circleView.setDrawColor(0xff525252);
                        }
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }

        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }


    @Override
    public void onPhotoTap(View view, float v, float v1) {

    }

    @Override
    public void onOutsidePhotoTap() {
        getActivity().finish();
    }

    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mParamsBean.photos.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            photoView.setScaleType(ImageView.ScaleType.FIT_XY);
            ImageLoader.getInstance().displayImage(mParamsBean.photos.get(position), photoView, Tools.buildDefDisplayImgOptions());
            photoView.setOnPhotoTapListener(OutdoorSignAttachmentsFragment.this);
            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}
