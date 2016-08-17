package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.wandong.R;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

/**
 * Created by ${keke} on 16/8/16.
 */
public class ContractApplicationNextFragment extends ABaseFragment{

    private static final int REQUEST_CODE_CUSTOMER = 100;
    private static final int REQUEST_CODE_CUSTOMER_MODE = 101;
    private static final int REQUEST_CODE_CUSTOMER_TYPE = 102;

    @ViewInject(id = R.id.tv_container_next_allocation_price,click = "OnClick")
    TextView mAllocationPrice ;
    @ViewInject(id = R.id.tv_container_next_commission_mode,click = "OnClick")
    TextView mCommissionmode;
    @ViewInject(id = R.id.tv_container_next_shipping_type,click = "OnClick")
    TextView mShippingType ;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_container_next;
    }

    public static void launch(FragmentActivity activity) {
        FragmentContainerActivity.launch(activity, ContractApplicationNextFragment.class, null);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("合同申请");

    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.tv_container_next_allocation_price:
                ContractApplicationNextAllocationListFragment.launchForResult(this, REQUEST_CODE_CUSTOMER);
                break;
            case R.id.tv_container_next_commission_mode:
                ContractApplicationNextCommissionListFragment.launchForResult(this, REQUEST_CODE_CUSTOMER_MODE);
                break;
            case R.id.tv_container_next_shipping_type:
                ContractApplicationNextShippingListFragment.launchForResult(this, REQUEST_CODE_CUSTOMER_TYPE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CUSTOMER && resultCode == Activity.RESULT_OK) {
            mAllocationPrice.setText(data.getStringExtra(ContractApplicationNextAllocationListFragment.KEY_ACCOUNT_NAME));
            mAllocationPrice.setTextColor(0xff333333);
        }

        if (requestCode == REQUEST_CODE_CUSTOMER_MODE && resultCode == Activity.RESULT_OK) {
            mCommissionmode.setText(data.getStringExtra(ContractApplicationNextCommissionListFragment.KEY_COMMISSION_NAME));
            mCommissionmode.setTextColor(0xff333333);
        }

        if (requestCode == REQUEST_CODE_CUSTOMER_TYPE && resultCode == Activity.RESULT_OK) {
            mShippingType.setText(data.getStringExtra(ContractApplicationNextShippingListFragment.KEY_ACCOUNT_SHIPPINGNAME));
            mShippingType.setTextColor(0xff333333);
        }
    }

}
