package com.android.wandong.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.android.wandong.R;
import com.zhan.framework.utils.PixelUtils;

/**
 * 作者：伍岳 on 2016/7/22 20:59
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
public class CircleView extends View {
    /**
     * 画笔对象的引用
     */
    private Paint mPaint;

    private int mDrawColor;
    private int mRoundWidth;

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,R.styleable.CircleView);
        mDrawColor = mTypedArray.getColor(R.styleable.CircleView_draw_color, Color.RED);
        mRoundWidth = mTypedArray.getDimensionPixelSize(R.styleable.CircleView_round_width, PixelUtils.dp2px(10));
        mTypedArray.recycle();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mDrawColor);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public CircleView(Context context) {
        super(context);
        mDrawColor = Color.RED;
        mRoundWidth = PixelUtils.dp2px(10);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mDrawColor);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public void setRoundWidth(int width){
        mRoundWidth = width;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /*setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int childWidthSize = getMeasuredWidth();
        int childHeightSize = getMeasuredHeight();*/
        //高度和宽度一样
        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(mRoundWidth, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mRoundWidth/2, mRoundWidth/2, mRoundWidth/2, mPaint);
    }

    public int getDrawColor() {
        return mDrawColor;
    }

    public void setDrawColor(int drawColor) {
        this.mDrawColor = drawColor;
        mPaint.setColor(mDrawColor);
        invalidate();
    }
}
