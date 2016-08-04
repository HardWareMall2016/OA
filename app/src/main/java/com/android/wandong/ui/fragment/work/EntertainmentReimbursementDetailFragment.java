package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;

import com.android.wandong.R;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.ui.fragment.ABaseFragment;

/**
 * Created by ${keke} on 16/8/4.
 */
public class EntertainmentReimbursementDetailFragment extends ABaseFragment {

    public static void launch(FragmentActivity activity) {
        FragmentArgs args = new FragmentArgs();
        //args.add(ARG_KEY, signId);
        FragmentContainerActivity.launch(activity, EntertainmentReimbursementDetailFragment.class, args);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_enter_tainment_reimburse_detail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mSignId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putSerializable(ARG_KEY, mSignId);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("招待费报销");
    }


}
