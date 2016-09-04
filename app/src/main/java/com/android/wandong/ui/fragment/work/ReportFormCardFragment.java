package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.CircleView;
import com.android.wandong.ui.widget.RoundProgressBar;
import com.android.wandong.utils.Tools;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.PixelUtils;

import java.text.DecimalFormat;

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
public class ReportFormCardFragment extends ABaseFragment {
    /*@ViewInject(id = R.id.roundProgressBar)
    protected RoundProgressBar mRoundProgressBar;*/

    @ViewInject(id = R.id.card_container)
    protected LinearLayout mContainerCard;

    private LayoutInflater mInflater;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_report_form_card;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mInflater=inflater;
    }


    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("PageIndex", 1);
        requestParams.put("PageNumber",10);
        requestParams.put("new_kind", 1);//类别（1为公告、2为通知）

        //Temp 数据
        startFormRequest(ApiUrls.SHARE_LIST, requestParams, new BaseHttpRequestTask<BaseResponseBean>() {
            @Override
            public BaseResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, BaseResponseBean.class);
            }

            @Override
            public String verifyResponseResult(BaseResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(BaseResponseBean result) {
                super.onSuccess(result);

                CardInfo cardInfo=new CardInfo();
                cardInfo.categoryName="报销进度";
                cardInfo.title1="待审批";
                cardInfo.title2="已完成";
                cardInfo.title3="已审批";
                cardInfo.figure1=5631.36f;
                cardInfo.figure2=3531.50f;
                cardInfo.figure3=7531.60f;
                cardInfo.color1=0xffFC694D;
                cardInfo.color2=0xffF7C300;
                cardInfo.color3=0xff78C750;
                populateCard(cardInfo);

                cardInfo=new CardInfo();
                cardInfo.categoryName="费用额度";
                cardInfo.title1="剩余额度";
                cardInfo.title2="已用额度";
                cardInfo.figure1=5000.52f;
                cardInfo.figure2=3531.50f;
                cardInfo.color1=0xffF7C300;
                cardInfo.color2=0xff78C750;
                populateCard(cardInfo);

                cardInfo=new CardInfo();
                cardInfo.categoryName="费用类型";
                cardInfo.title1="招待费";
                cardInfo.title2="差旅费";
                cardInfo.title3="市场活动费";
                cardInfo.figure1=3000.36f;
                cardInfo.figure2=9000.50f;
                cardInfo.figure3=5000.60f;
                cardInfo.color1=0xffFC694D;
                cardInfo.color2=0xffF7C300;
                cardInfo.color3=0xff78C750;
                populateCard(cardInfo);
            }
        },HttpRequestUtils.RequestType.POST);
    }

    private void populateCard(CardInfo cardInfo){
        DecimalFormat figureFormat = new DecimalFormat();
        figureFormat.applyPattern("###,###.00元");

        View cardLayout=mInflater.inflate(R.layout.item_report_form_card,null);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.topMargin= PixelUtils.dp2px(16);
        cardLayout.setLayoutParams(lp);
        mContainerCard.addView(cardLayout);

        TextView category=(TextView)cardLayout.findViewById(R.id.category);
        category.setText(cardInfo.categoryName);

        CircleView indicator_1=(CircleView)cardLayout.findViewById(R.id.indicator_1);
        TextView title_1=(TextView)cardLayout.findViewById(R.id.title_1);
        TextView summary_1=(TextView)cardLayout.findViewById(R.id.summary_1);

        indicator_1.setDrawColor(cardInfo.color1);
        title_1.setText(cardInfo.title1);
        summary_1.setText(figureFormat.format(cardInfo.figure1));


        CircleView indicator_2=(CircleView)cardLayout.findViewById(R.id.indicator_2);
        TextView title_2=(TextView)cardLayout.findViewById(R.id.title_2);
        TextView summary_2=(TextView)cardLayout.findViewById(R.id.summary_2);

        indicator_2.setDrawColor(cardInfo.color2);
        title_2.setText(cardInfo.title2);
        summary_2.setText(figureFormat.format(cardInfo.figure2));

        CircleView indicator_3=(CircleView)cardLayout.findViewById(R.id.indicator_3);
        TextView title_3=(TextView)cardLayout.findViewById(R.id.title_3);
        TextView summary_3=(TextView)cardLayout.findViewById(R.id.summary_3);

        int reachedProgress[];
        int reachedBarColor[];
        if(TextUtils.isEmpty(cardInfo.title3)){
            indicator_3.setVisibility(View.GONE);
            title_3.setVisibility(View.GONE);
            summary_3.setVisibility(View.GONE);

            int percentage1= (int) (100*(cardInfo.figure1/(cardInfo.figure1+cardInfo.figure2)));
            int percentage2=100-percentage1;
            reachedProgress=new int[]{percentage1,percentage2};
            reachedBarColor=new int[]{cardInfo.color1,cardInfo.color2};
        }else{
            indicator_3.setDrawColor(cardInfo.color3);
            title_3.setText(cardInfo.title3);
            summary_3.setText(figureFormat.format(cardInfo.figure3));

            int percentage1= (int) (100*(cardInfo.figure1/(cardInfo.figure1+cardInfo.figure2+cardInfo.figure3)));
            int percentage2=(int) (100*(cardInfo.figure2/(cardInfo.figure1+cardInfo.figure2+cardInfo.figure3)));
            int percentage3=100-percentage1-percentage2;
            reachedProgress=new int[]{percentage1,percentage2,percentage3};
            reachedBarColor=new int[]{cardInfo.color1,cardInfo.color2,cardInfo.color3};
        }


        RoundProgressBar roundProgressBar=(RoundProgressBar)cardLayout.findViewById(R.id.roundProgressBar);
        roundProgressBar.setProgress(reachedProgress,reachedBarColor);
    }

    private class CardInfo{
        String categoryName;

        String title1;
        String title2;
        String title3;

        float figure1;
        float figure2;
        float figure3;

        int color1;
        int color2;
        int color3;
    }

}
