package com.android.wandong.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * 作者：伍岳 on 2016/7/28 21:28
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
public class CHScrollView extends HorizontalScrollView {
    private OnScrollChangedListener mOnScrollChangedListener;
    private static CHScrollView sTouchedView;

    public CHScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if(sTouchedView==this){
            if (mOnScrollChangedListener != null) {
                mOnScrollChangedListener.onScrollChanged(l, t, oldl, oldt,this);
            }
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public void setOnCHScrollChangedListener(OnScrollChangedListener listener) {
        mOnScrollChangedListener=listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //进行触摸赋值
        sTouchedView=this;
        return super.onTouchEvent(ev);
    }

    /*
     * 当发生了滚动事件时
     */
    public interface OnScrollChangedListener {
        void onScrollChanged(int l, int t, int oldl, int oldt,CHScrollView scrollView);
    }
}
