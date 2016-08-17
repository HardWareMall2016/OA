package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.wandong.R;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

/**
 * Created by ${keke} on 16/8/16.
 */
public class ContractApplicationCreateFragment extends ABaseFragment{
    private static final int REQUEST_CODE_ONE = 100;
    private static final int REQUEST_CODE_TWO = 101;
    private static final int REQUEST_CODE_THREE = 102;

    @ViewInject(id = R.id.tv_container_product_line,click = "OnClick")
    TextView mProductLine ;
    @ViewInject(id = R.id.tv_container_product_model,click = "OnClick")
    TextView mProductModel;
    @ViewInject(id = R.id.tv_container_payment_method,click = "OnClick")
    TextView mPayMentMethod;
    @ViewInject(id = R.id.btn_submit_next,click = "OnClick")
    Button mSubmitNext;

    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, ContractApplicationCreateFragment.class, null);

    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_container_create;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("合同申请");

    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.tv_container_product_line:
                ContractApplicationProductLineListFragment.launchForResult(this, REQUEST_CODE_ONE);
                break;
            case R.id.tv_container_product_model:
                ContractApplicationProductModelListFragment.launchForResult(this, REQUEST_CODE_TWO);
                break;
            case R.id.tv_container_payment_method:
                ContractApplicationPayListFragment.launchForResult(this, REQUEST_CODE_THREE);
                break;
            case R.id.btn_submit_next:
                ContractApplicationNextFragment.launch(getActivity());
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ONE && resultCode == Activity.RESULT_OK) {
            mProductLine.setText(data.getStringExtra(ContractApplicationProductLineListFragment.KEY_ACCOUNT_NAME));
            mProductLine.setTextColor(0xff333333);
        }
        if (requestCode == REQUEST_CODE_TWO && resultCode == Activity.RESULT_OK) {
            mProductModel.setText(data.getStringExtra(ContractApplicationProductModelListFragment.KEY_ACCOUNT_NAME));
            mProductModel.setTextColor(0xff333333);
        }
        if (requestCode == REQUEST_CODE_THREE && resultCode == Activity.RESULT_OK) {
            mPayMentMethod.setText(data.getStringExtra(ContractApplicationPayListFragment.KEY_ACCOUNT_NAME));
            mPayMentMethod.setTextColor(0xff333333);
        }
    }
}
