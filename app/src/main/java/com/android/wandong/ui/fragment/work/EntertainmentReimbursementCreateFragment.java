package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.android.wandong.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;
import com.zhan.framework.utils.PixelUtils;

/**
 * Created by ${keke} on 16/8/14.
 */
public class EntertainmentReimbursementCreateFragment extends APullToRefreshListFragment<EntertainmentReimbursementCreateFragment.AccountInfo> {

    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, EntertainmentReimbursementCreateFragment.class, null);
    }

    @Override
    protected void setInitPullToRefresh(ListView listView, PullToRefreshListView pullToRefreshListView, Bundle savedInstanceState) {
        super.setInitPullToRefresh(listView, pullToRefreshListView, savedInstanceState);
        listView.setDividerHeight(getListDividerHeight());
        View searchHeader=getActivity().getLayoutInflater().inflate(R.layout.layout_work_search_header,null);
        if(getListDividerHeight()!=0){
            searchHeader.setPadding(PixelUtils.dp2px(8),PixelUtils.dp2px(0),PixelUtils.dp2px(8),PixelUtils.dp2px(0));
        }
        mPullToRefreshListView.getRefreshableView().addHeaderView(searchHeader);
    }

    public int getListDividerHeight(){
        return 0;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("选择招待费申请");
    }

    @Override
    protected ABaseAdapter.AbstractItemView<EntertainmentReimbursementCreateFragment.AccountInfo> newItemView() {
        return null;
    }

    @Override
    protected void requestData(RefreshMode mode) {

    }


    public class AccountInfo{

    }
}
