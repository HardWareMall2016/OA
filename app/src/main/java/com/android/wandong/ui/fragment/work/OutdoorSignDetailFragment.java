package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.OutDoorSignDetailResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.PixelUtils;

/**
 * 作者：伍岳 on 2016/7/21 13:52
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
public class OutdoorSignDetailFragment extends ABaseFragment implements TextWatcher {
    private final static String ARG_KEY = "arg_key";
    private String mSignId;

    @ViewInject(id = R.id.location)
    TextView mViewLocation;

    @ViewInject(id = R.id.relative_customer)
    TextView mViewRelativeCustomer;

    @ViewInject(id = R.id.word_tips)
    TextView mViewWordTips;

    @ViewInject(id = R.id.remark)
    EditText mViewRemark;

    @ViewInject(id = R.id.img_content)
    LinearLayout mViewContentImgs;

    public static void launch(Activity activity, String signId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, signId);
        FragmentContainerActivity.launch(activity, OutdoorSignDetailFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSignId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mSignId);
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("外勤签到");
        mViewRemark.addTextChangedListener(this);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_outdoor_sign_detail;
    }


    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("signId", mSignId);
        startFormRequest(ApiUrls.OUTDOOR_SIGN_DETAIL, requestParams, new BaseHttpRequestTask<OutDoorSignDetailResponseBean>() {
            @Override
            public OutDoorSignDetailResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, OutDoorSignDetailResponseBean.class);
            }

            @Override
            public String verifyResponseResult(OutDoorSignDetailResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(OutDoorSignDetailResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了
                if (result != null && result.getEntityInfo() != null && result.getEntityInfo().getSignInfo() != null) {
                    Tools.setTextView(mViewLocation, result.getEntityInfo().getSignInfo().getAddress());
                    Tools.setTextView(mViewRelativeCustomer, result.getEntityInfo().getSignInfo().getAccountName());
                    Tools.setTextView(mViewRemark, result.getEntityInfo().getSignInfo().getRemarks());
                    mViewWordTips.setText(String.format("(%d/200)", mViewRemark.getText().length()));
                }

                mViewContentImgs.removeAllViews();

                if (result != null && result.getEntityInfo() != null && result.getEntityInfo().getAttachmentInfo() != null) {
                    for (String imgUrl : result.getEntityInfo().getAttachmentInfo()) {
                        ImageView imageView = new ImageView(getActivity());
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ImageLoader.getInstance().displayImage(imgUrl, imageView, Tools.buildDefDisplayImgOptions());
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(PixelUtils.dp2px(90), PixelUtils.dp2px(90));
                        lp.leftMargin = PixelUtils.dp2px(8);
                        mViewContentImgs.addView(imageView, lp);
                    }
                }

                ImageView imageView = new ImageView(getActivity());
                imageView.setImageResource(R.drawable.def_pic);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(PixelUtils.dp2px(90), PixelUtils.dp2px(90));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                lp.leftMargin = PixelUtils.dp2px(8);
                mViewContentImgs.addView(imageView, lp);
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        mViewWordTips.setText(String.format("(%d/200)",mViewRemark.getText().length()));
    }
}
