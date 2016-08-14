package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

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
public class WorkReportCreateWeekly extends ABaseFragment{

    @ViewInject(id = R.id.people)
    protected FixGridView mFixGridView;

    private ArrayList<PeopleInfo> mPeopleList = new ArrayList<>();

    private PeopleAdapter mAdapter;

    public static void launch(Activity activity){
        /*FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, productId);*/
        FragmentContainerActivity.launch(activity, WorkReportCreateWeekly.class, null);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_create_weekly;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("写周报");

        mPeopleList.clear();
        mPeopleList.add(new PeopleInfo());
        mAdapter = new PeopleAdapter(mPeopleList,getActivity());
        mFixGridView.setAdapter(mAdapter);
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
}
