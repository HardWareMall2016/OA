package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

/**
 * Created by ${keke} on 16/8/28.
 */
public class ContractApplicationDetailsFragment extends ABaseFragment {
    private final static String ARG_KEY = "contract_detail";

    @ViewInject(id = R.id.ApplyNo)
    TextView mApplyNo ;
    @ViewInject(id = R.id.AccountName)
    TextView mAccountName;
    @ViewInject(id = R.id.create_on)
    TextView mCreateOn ;
    @ViewInject(id = R.id.Status)
    TextView mStatus;
    @ViewInject(id = R.id.OwnerName)
    TextView mOwnerName;
    @ViewInject(id = R.id.money)
    TextView money;
    @ViewInject(id = R.id.time)
    TextView mViewTime;
    @ViewInject(id = R.id.img_status)
    ImageView mIVStatus;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_contract_application_details;
    }

    public static void launch(FragmentActivity activity, String contractId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, contractId);
        FragmentContainerActivity.launch(activity, ContractApplicationDetailsFragment.class, args);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("合同申请详情");
    }

    @Override
    public void requestData() {

    }

}
