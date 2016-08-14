package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.android.wandong.R;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.ui.fragment.ABaseFragment;

/**
 * Created by ${keke} on 16/8/13.
 */
public class SpecialDuesReimbursementCreateFragment extends ABaseFragment{


    @Override
    protected int inflateContentView() {
        return R.layout.frag_specialdues_reimburse_create;
    }

    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, SpecialDuesReimbursementCreateFragment.class, null);
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("专项费报销");
    }
}
