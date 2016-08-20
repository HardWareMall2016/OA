package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.EntertainmentReimbursementCreateDetailContent;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

/**
 * * 作者：keke on 2016/8/20 14:15
 */
public class EntertainmentReimbursementCreateDetailFragment extends ABaseFragment{
    private final static String ARG_KEY = "enter_reimbursecreate_detail";

    //views
    @ViewInject(id = R.id.tv_enter_tainment_companyname)
    TextView mTvCompanyName;
    @ViewInject(id = R.id.tv_enter_tainment_peplenumber)
    TextView mTvPepNumber ;
    @ViewInject(id = R.id.tv_enter_tainment_time)
    TextView mTvTime;
    @ViewInject(id = R.id.reasonContent)
    TextView mTvReasonContent;
    @ViewInject(id = R.id.province)
    TextView mTvProvice;
    @ViewInject(id = R.id.ApplyUnit)
    TextView mTvApplyUnit ;

    @ViewInject(id = R.id.TrueEstimateMeals)
    EditText mEtTrueMeals ;
    @ViewInject(id = R.id.EstimateHotel)
    EditText mEtHotel ;
    @ViewInject(id = R.id.EstimateOffice)
    EditText mEtOffice ;
    @ViewInject(id = R.id.EstimateTraffic)
    EditText mEtTraffic;
    @ViewInject(id = R.id.EstimateGift)
    EditText mEtGift;

    @ViewInject(id = R.id.EstimateTotal)
    TextView mTvTotal;

    private EntertainmentReimbursementCreateDetailContent mContent;

    public static void launch(FragmentActivity activity, EntertainmentReimbursementCreateDetailContent content) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, content);
        FragmentContainerActivity.launch(activity, EntertainmentReimbursementCreateDetailFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContent = savedInstanceState == null ? (EntertainmentReimbursementCreateDetailContent) getArguments().getSerializable(ARG_KEY) : (EntertainmentReimbursementCreateDetailContent) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mContent);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_enter_tainment_reimburse_create_detail;
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("招待费报销");

        mTvCompanyName.setText(mContent.getAccountName());
        mTvPepNumber.setText(mContent.getNumber()+"");
        mTvTime.setText("2016-10-10");
        mTvReasonContent.setText(mContent.getReason());
        //mTvProvice.setText(mContent.get);
    }
}
