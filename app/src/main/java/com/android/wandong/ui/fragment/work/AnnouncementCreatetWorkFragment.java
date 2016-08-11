package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.AnnouncementCreateWorkListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;
import com.zhan.framework.utils.PixelUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${keke} on 16/8/11.
 */
public class AnnouncementCreatetWorkFragment extends APullToRefreshListFragment<AnnouncementCreatetWorkFragment.DepartlistInfo> {


    public static void launch(FragmentActivity activity) {
        FragmentContainerActivity.launch(activity, AnnouncementCreatetWorkFragment.class, null);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("按工作岗位查看");
    }

    @Override
    protected void setInitPullToRefresh(ListView listView, PullToRefreshListView pullToRefreshListView, Bundle savedInstanceState) {
        super.setInitPullToRefresh(listView, pullToRefreshListView, savedInstanceState);
        listView.setDividerHeight(getListDividerHeight());
        View searchHeader = getActivity().getLayoutInflater().inflate(R.layout.layout_work_search_header, null);
        if (getListDividerHeight() != 0) {
            searchHeader.setPadding(PixelUtils.dp2px(8), PixelUtils.dp2px(0), PixelUtils.dp2px(8), PixelUtils.dp2px(0));
        }
        mPullToRefreshListView.getRefreshableView().addHeaderView(searchHeader);
    }

    public int getListDividerHeight(){
        return 0;
    }

    @Override
    protected void configRefresh(RefreshConfig config) {
        config.minResultSize=20;
    }

    @Override
    protected void requestData(RefreshMode mode) {
        HttpRequestParams requestParams= Tools.createHttpRequestParams();
        startFormRequest(ApiUrls.CONTACTS_WORKROLES, requestParams, new PagingTask<AnnouncementCreateWorkListResponseBean>(mode) {
            @Override
            public AnnouncementCreateWorkListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, AnnouncementCreateWorkListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(AnnouncementCreateWorkListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<DepartlistInfo> parseResult(AnnouncementCreateWorkListResponseBean baseResponseBean) {
                List<DepartlistInfo> items = new ArrayList<>();
                if (baseResponseBean != null && baseResponseBean.getEntityInfo() != null && baseResponseBean.getEntityInfo() != null) {
                    for (AnnouncementCreateWorkListResponseBean.EntityInfoBean bean : baseResponseBean.getEntityInfo()) {
                        DepartlistInfo reportDataItem = new DepartlistInfo();
                        reportDataItem.RoleId = bean.getRoleId();
                        reportDataItem.Name = bean.getName();
                        reportDataItem.type = bean.getType();
                        items.add(reportDataItem);
                    }
                }
                return items;
            }
        }, HttpRequestUtils.RequestType.POST);
    }
    @Override
    protected ABaseAdapter.AbstractItemView<AnnouncementCreatetWorkFragment.DepartlistInfo> newItemView() {
        return new WorklistItemView();
    }

    private class WorklistItemView extends ABaseAdapter.AbstractItemView<DepartlistInfo>{
        @ViewInject(id = R.id.tv_department_name)
        TextView mViewDepartName ;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_department;
        }

        @Override
        public void bindingData(View convertView, DepartlistInfo data) {
            mViewDepartName.setText("   "+data.Name);
        }
    }

    public class DepartlistInfo{
        int type;
        String RoleId;
        String Name;
    }

}
