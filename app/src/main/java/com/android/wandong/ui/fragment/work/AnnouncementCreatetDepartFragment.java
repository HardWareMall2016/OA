package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.AnnouncementCreatetDepartListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.CharacterParser;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;
import com.zhan.framework.utils.PixelUtils;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 作者：伍岳 on 16/8/10 11:20
 * 邮箱：wuyue8512@163.com
 //
 //         .............................................
 //                  美女坐镇                  BUG辟易
 //         .............................................
 //
 //                       .::::.
 //                     .::::::::.
 //                    :::::::::::
 //                 ..:::::::::::'
 //              '::::::::::::'
 //                .::::::::::
 //           '::::::::::::::..
 //                ..::::::::::::.
 //              ``::::::::::::::::
 //               ::::``:::::::::'        .:::.
 //              ::::'   ':::::'       .::::::::.
 //            .::::'      ::::     .:::::::'::::.
 //           .:::'       :::::  .:::::::::' ':::::.
 //          .::'        :::::.:::::::::'      ':::::.
 //         .::'         ::::::::::::::'         ``::::.
 //     ...:::           ::::::::::::'              ``::.
 //    ```` ':.          ':::::::::'                  ::::..
 //                       '.:::::'                    ':'````..
 //
 */
public class AnnouncementCreatetDepartFragment extends APullToRefreshListFragment<AnnouncementCreatetDepartFragment.ItemInfo>  {
    public final static String EXT_DATA_KEY="ext_data";

    public final static int REQUEST_CODE=100;

    private final static String ARG_KEY_TITLE="ARG_KEY_TITLE";
    private final static String ARG_KEY_DEPT_ID="ARG_KEY_DEPT_ID";

    private String mTitle;
    private String mDepartmentId;
    private boolean mIsSelectMode =false;

    @ViewInject(id = R.id.confirm, click = "OnClick")
    View mViewConfirm;

    private TextView mRightMenu;

    public static void launchForResult(Fragment from,int requestCode,String title,String departmentId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY_TITLE, title);
        args.add(ARG_KEY_DEPT_ID, departmentId);
        FragmentContainerActivity.launchForResult(from, AnnouncementCreatetDepartFragment.class, args,requestCode);
    }

    @Override
    public boolean isContentEmpty() {
        return false;
    }

    @Override
    public void onActionBarMenuClick() {
        mIsSelectMode =!mIsSelectMode;
        mRightMenu.setText(mIsSelectMode?"取消":"选择");
        mViewConfirm.setVisibility(mIsSelectMode ?View.VISIBLE:View.GONE);
        notifyDataSetChanged();
    }

    @Override
    public void onPrepareActionbarMenu(TextView menu, Activity activity) {
        menu.setText("选择");
        mRightMenu=menu;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY_TITLE) : (String) savedInstanceState.getSerializable(ARG_KEY_TITLE);
        mDepartmentId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY_DEPT_ID) : (String) savedInstanceState.getSerializable(ARG_KEY_DEPT_ID);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY_TITLE, mTitle);
        outState.putSerializable(ARG_KEY_DEPT_ID, mDepartmentId);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle(mTitle);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_announcement_object_department;
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.confirm:
                AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo= getSelectObjects();
                if(selectInfo.users.size()==0&&selectInfo.departs.size()==0){
                    ToastUtils.toast("请选择");
                    return;
                }
                Intent intent=new Intent();
                intent.putExtra(EXT_DATA_KEY,selectInfo);
                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo=(AnnouncementCreateObjectFragment.AnnounceObjectInfo)data.getSerializableExtra(AnnouncementCreatetDepartFragment.EXT_DATA_KEY);
            Intent intent=new Intent();
            intent.putExtra(EXT_DATA_KEY,selectInfo);
            getActivity().setResult(Activity.RESULT_OK, intent);
            getActivity().finish();
        }
    }

    private AnnouncementCreateObjectFragment.AnnounceObjectInfo getSelectObjects(){
        AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo=new AnnouncementCreateObjectFragment.AnnounceObjectInfo();
        for(ItemInfo itemInfo:getAdapterItems()){
            if(!itemInfo.selected){
                continue;
            }
            if(itemInfo.type==1){
                selectInfo.users.add(itemInfo.idStr);
            }else{
                selectInfo.departs.add(itemInfo.idStr);
            }
        }

        return selectInfo;
    }

    @Override
    protected void setInitPullToRefresh(ListView listView, PullToRefreshListView pullToRefreshListView, Bundle savedInstanceState) {
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
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
        requestParams.put("departmentid", mDepartmentId);
        startFormRequest(ApiUrls.CONTACTS_DEPARTMENTS, requestParams, new PagingTask<AnnouncementCreatetDepartListResponseBean>(mode) {
            @Override
            public AnnouncementCreatetDepartListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, AnnouncementCreatetDepartListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(AnnouncementCreatetDepartListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<ItemInfo> parseResult(AnnouncementCreatetDepartListResponseBean baseResponseBean) {
                List<ItemInfo> items = new ArrayList<>();
                CharacterParser characterParser=CharacterParser.getInstance();
                if (baseResponseBean != null && baseResponseBean.getEntityInfo() != null) {
                    if(baseResponseBean.getEntityInfo().getDepartlist() != null){
                        for (AnnouncementCreatetDepartListResponseBean.EntityInfoBean.DepartlistBean bean : baseResponseBean.getEntityInfo().getDepartlist()) {
                            ItemInfo reportDataItem = new ItemInfo();
                            reportDataItem.idStr = bean.getNewDepartmentId();
                            reportDataItem.name = bean.getNewName();
                            reportDataItem.type = bean.getType();
                            //汉字转换成拼音
                            String pinyin = characterParser.getSelling(reportDataItem.name);
                            String sortString = pinyin.substring(0, 1).toUpperCase();
                            // 正则表达式，判断首字母是否是英文字母
                            if(sortString.matches("[A-Z]")){
                                reportDataItem.sortLetter=sortString.toUpperCase();
                            }else{
                                reportDataItem.sortLetter="#";
                            }
                            items.add(reportDataItem);
                        }

                        Collections.sort(items, new PinyinComparator());

                        for (AnnouncementCreatetDepartListResponseBean.EntityInfoBean.UserlistBean bean : baseResponseBean.getEntityInfo().getUserlist()) {
                            ItemInfo reportDataItem = new ItemInfo();
                            reportDataItem.idStr = bean.getSystemUserId();
                            reportDataItem.name = bean.getFullname();
                            reportDataItem.type = bean.getType();
                            items.add(reportDataItem);
                        }
                    }

                }

                return items;
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ItemInfo> newItemView() {
        return new DepartlistItemView();
    }

    private class DepartlistItemView extends ABaseAdapter.AbstractItemView<ItemInfo>{
        @ViewInject(id = R.id.imageLeft)
        ImageView mViewImageLeft ;

        @ViewInject(id = R.id.name)
        TextView mViewName ;

        @ViewInject(id = R.id.imageRight)
        ImageView mViewImageRight ;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_department;
        }

        @Override
        public void bindingData(View convertView, ItemInfo data) {
            if(data.type==1|| mIsSelectMode){
                if(data.selected){
                    mViewImageLeft.setImageResource(R.drawable.checkbox_sel);
                }else{
                    mViewImageLeft.setImageResource(R.drawable.checkbox_unsel);
                }
                mViewImageRight.setVisibility(View.GONE);
            }else{
                mViewImageLeft.setImageResource(R.drawable.icon_people);
                mViewImageRight.setVisibility(View.VISIBLE);
            }
            Tools.setTextView(mViewName,data.name);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemInfo itemInfo =getAdapterItems().get((int)id);
        if(itemInfo.type==1|| mIsSelectMode){
            itemInfo.selected=!itemInfo.selected;
            notifyDataSetChanged();
        }else{
            AnnouncementCreatetDepartFragment.launchForResult(this, REQUEST_CODE, itemInfo.name, itemInfo.idStr);
        }
    }

    public class ItemInfo {
        String sortLetter;
        boolean selected=false;
        int type;
        String idStr;
        String name;
    }
    
    public class PinyinComparator implements Comparator<ItemInfo> {

        public int compare(ItemInfo o1, ItemInfo o2) {
            //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
            if (o2.sortLetter.equals("#")) {
                return -1;
            } else if (o1.sortLetter.equals("#")) {
                return 1;
            } else {
                return o1.sortLetter.compareTo(o2.sortLetter);
            }
        }
    }
}
