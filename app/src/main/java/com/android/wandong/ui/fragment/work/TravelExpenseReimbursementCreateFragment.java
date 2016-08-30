package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

/**
 * Created by ${keke} on 16/8/13.
 */
public class TravelExpenseReimbursementCreateFragment extends ABaseFragment{

    @ViewInject(id = R.id.ll_travel_one)
    LinearLayout mLLTravelOne ;

    @ViewInject(id = R.id.travel_hide,click = "OnClick")
    ImageView mTravelHide;
    @ViewInject(id = R.id.ll_travel)
    LinearLayout mLlTravel;

    @ViewInject(id = R.id.rl_add_travel,click = "OnClick")
    RelativeLayout mViewAddTravel;

    @ViewInject(id = R.id.rl_travel_outwork_money,click = "OnClick")
    RelativeLayout mRlOutMoney;
    @ViewInject(id = R.id.rl_travel_other_money,click = "OnClick")
    RelativeLayout mRlOtherMoney;
    @ViewInject(id = R.id.travel_indicator)
    ImageView mIndicatorOut;
    @ViewInject(id = R.id.travel_otherindicator)
    ImageView mIndicatorOther;

    @ViewInject(id = R.id.travel_outwork_money)
    LinearLayout mViewOutMoney;
    @ViewInject(id = R.id.travel_other_money)
    LinearLayout mViewOtherMoney;

    private boolean expandView = true ;
    private boolean expandOut =true;
    private boolean expandOther =true;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_travel_reimburse_create;
    }

    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, TravelExpenseReimbursementCreateFragment.class, null);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("差旅费报销");

    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.rl_travel_outwork_money:
                if(expandOut){
                    mViewOutMoney.setVisibility(View.VISIBLE);
                    mIndicatorOut.setImageResource(R.drawable.icon_yellow_up);
                    expandOut = false;
                }else {
                    mViewOutMoney.setVisibility(View.GONE);
                    mIndicatorOut.setImageResource(R.drawable.icon_yellow_down);
                    expandOut = true;
                }
                break;
            case R.id.rl_travel_other_money:
                if(expandOther){
                    mViewOtherMoney.setVisibility(View.VISIBLE);
                    mIndicatorOther.setImageResource(R.drawable.icon_yellow_up);
                    expandOther = false;
                }else {
                    mViewOtherMoney.setVisibility(View.GONE);
                    mIndicatorOther.setImageResource(R.drawable.icon_yellow_down);
                    expandOther = true;
                }
                break;
            case R.id.travel_hide:
                if (expandView){
                    mLlTravel.setVisibility(View.VISIBLE);
                    expandView = false;
                }else{
                    mLlTravel.setVisibility(View.GONE);
                    expandView = true;
                }
                break;
            case R.id.rl_add_travel:


                break;
        }
    }

}
