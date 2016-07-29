package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.RoundProgressBar;
import com.android.wandong.utils.Tools;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

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
    @ViewInject(id = R.id.roundProgressBar)
    protected RoundProgressBar mRoundProgressBar;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_report_form_card;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
    }


    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("PageIndex", 1);
        requestParams.put("PageNumber",10);
        requestParams.put("new_kind", 1);//类别（1为公告、2为通知）

        //Temp 数据
        startFormRequest(ApiUrls.NOTICE_LIST, requestParams, new BaseHttpRequestTask<BaseResponseBean>() {
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
                int reachedProgress[]=new int[]{30,40,30};
                int reachedBarColor[]=new int[]{0xffFC694D,0xffF7C300,0xff78C750};
                mRoundProgressBar.setProgress(reachedProgress,reachedBarColor);
                //这里加正确处理的逻辑就好了
            }
        },HttpRequestUtils.RequestType.POST);
    }
}
