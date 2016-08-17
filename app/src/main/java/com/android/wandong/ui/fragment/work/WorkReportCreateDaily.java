package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.ui.widget.FixGridView;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

import java.util.ArrayList;

/**
 * 作者：伍岳 on 2016/8/14 16:22
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
public class WorkReportCreateDaily extends ABaseFragment {
    private static final int REQUEST_CODE_CUSTOMER = 100;

    @ViewInject(id = R.id.people)
    protected FixGridView mFixGridView;

    private ArrayList<PeopleInfo> mPeopleList = new ArrayList<>();

    private PeopleAdapter mAdapter;

    @ViewInject(id = R.id.layout_relative_customer_and_today_summary)
    protected LinearLayout mLayoutHeader;

    //默认的关联客户和工作总结项
    @ViewInject(id = R.id.def_item)
    protected View mLayoutDefItem;

    private LayoutInflater mInflate;

    private ViewHolder mCurrentViewHolder;

    public static void launch(Activity activity){
        /*FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, productId);*/
        FragmentContainerActivity.launch(activity, WorkReportCreateDaily.class, null);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_create_daily;
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("写日报");

        mInflate=inflater;

        mPeopleList.clear();
        mPeopleList.add(new PeopleInfo());
        mAdapter = new PeopleAdapter(mPeopleList,getActivity());
        mFixGridView.setAdapter(mAdapter);

        setViewHolder(mLayoutDefItem, true);
    }

    public class PeopleInfo{

    }

    private class PeopleAdapter extends ABaseAdapter<PeopleInfo> {
        public PeopleAdapter(ArrayList<PeopleInfo> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<PeopleInfo> newItemView() {
            return new PeopleItemView();
        }
    }

    private class PeopleItemView extends ABaseAdapter.AbstractItemView<PeopleInfo> {
        @ViewInject(id = R.id.attachment)
        ImageView mViewAttachment;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_attached_people;
        }

        @Override
        public void bindingData(View convertView, PeopleInfo data) {
            if(getPosition()==getSize()-1){
                //ImageLoader.getInstance().displayImage("drawable://" + R.drawable.icon_sign_in_add_photo, mViewAttachment, Tools.buildDefDisplayImgOptions());
            } else {
                //ImageLoader.getInstance().displayImage("file://"+data, mViewAttachment, Tools.buildDefDisplayImgOptions());
            }
        }
    }

    private class ViewHolder{
        boolean isDefItem;
        String relativeCusName;
        String relativeCusId;

        View itemView;
        TextView relativeCustomerTitle;
        TextView relativeCustomerValue;
        EditText todayWorkSummary;
    }

    private void setViewHolder(View itemView,boolean isDefItem){
        ViewHolder viewHolder=new ViewHolder();
        viewHolder.isDefItem=isDefItem;
        viewHolder.itemView=itemView;
        viewHolder.relativeCustomerTitle=(TextView)itemView.findViewById(R.id.relative_customer_title);
        viewHolder.relativeCustomerTitle.setOnClickListener(mOnRelativeCustomerClickListener);
        viewHolder.relativeCustomerTitle.setTag(viewHolder);
        if(isDefItem){
            viewHolder.relativeCustomerTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_add_small, 0, 0, 0);
        }else{
            viewHolder.relativeCustomerTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_delete_small,0,0,0);
        }

        viewHolder.relativeCustomerValue=(TextView)itemView.findViewById(R.id.relative_customer_value);
        viewHolder.relativeCustomerValue.setOnClickListener(mOnRelativeCustomerClickListener);
        viewHolder.relativeCustomerValue.setTag(viewHolder);

        viewHolder.todayWorkSummary=(EditText)itemView.findViewById(R.id.today_work_summary);

        itemView.setTag(viewHolder);
    }

    private View.OnClickListener mOnRelativeCustomerClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            ViewHolder viewHolder=(ViewHolder)v.getTag();
            switch (v.getId()){
                case R.id.relative_customer_title:
                    if(viewHolder.isDefItem){
                        View itemView=mInflate.inflate(R.layout.item_create_daily_report_header,null);
                        setViewHolder(itemView,false);
                        mLayoutHeader.addView(itemView,0);
                    }else{
                        mLayoutHeader.removeView(viewHolder.itemView);
                    }
                    break;
                case R.id.relative_customer_value:
                    mCurrentViewHolder=viewHolder;
                    AccountListFragment.launchForResult(WorkReportCreateDaily.this, REQUEST_CODE_CUSTOMER);
                    break;
            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CUSTOMER && resultCode == Activity.RESULT_OK) {
            if(mCurrentViewHolder!=null){
                mCurrentViewHolder.relativeCusId=data.getStringExtra(AccountListFragment.KEY_ACCOUNT_ID);
                mCurrentViewHolder.relativeCusName=data.getStringExtra(AccountListFragment.KEY_ACCOUNT_NAME);

                mCurrentViewHolder.relativeCustomerValue.setText(mCurrentViewHolder.relativeCusName);
                mCurrentViewHolder.relativeCustomerValue.setTextColor(0xff333333);
            }
        }
    }
}
