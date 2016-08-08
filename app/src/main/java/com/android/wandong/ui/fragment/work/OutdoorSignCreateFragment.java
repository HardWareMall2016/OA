package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

/**
 * 作者：伍岳 on 2016/8/8 20:44
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
public class OutdoorSignCreateFragment extends ABaseFragment implements TextWatcher {

    @ViewInject(id = R.id.sign_in_time)
    TextView mViewSignInTime;

    @ViewInject(id = R.id.address_content, click = "OnClick")
    View mViewAddressContent;

    @ViewInject(id = R.id.sign_in_address)
    TextView mViewSignInAddress;

    @ViewInject(id = R.id.customer_content, click = "OnClick")
    View mViewCustomerContent;

    @ViewInject(id = R.id.customer)
    TextView mViewSignInCustomer;

    @ViewInject(id = R.id.remark)
    EditText mViewRemark;

    @ViewInject(id = R.id.remark_length_info)
    TextView mViewRemarkLength;

    @ViewInject(id = R.id.btn_sign_in, click = "OnClick")
    View mBtnSignIn;

    public static void launch(Activity activity) {
        FragmentContainerActivity.launch(activity, OutdoorSignCreateFragment.class, null);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("外勤签到");
        mViewRemark.addTextChangedListener(this);
        mViewSignInTime.setText(Tools.parseTimeToMintues(System.currentTimeMillis()));
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_outdoor_sign_create;
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.address_content:
                break;
            case R.id.customer_content:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        mViewRemarkLength.setText(String.format("%d/200", 200 - mViewRemark.length()));
    }
}
