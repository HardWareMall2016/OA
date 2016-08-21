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
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.AccountObjectListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.CharacterParser;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 作者：伍岳 on 16/8/10 11:18
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
public class AnnouncementCreateObjectFragment extends ABaseFragment implements AdapterView.OnItemClickListener {
    public final static int REQUEST_CODE_DEPARTMENT =101;
    public final static int REQUEST_CODE_WORK_ROLE=102;

    public final static String EXT_DATA_KEY="ext_data";

    @ViewInject(id = R.id.lv_object_listview)
    ListView mObjectListView;
    @ViewInject(id = R.id.announcement_object_departments,click = "OnClick")
    View mDepartMent;
    @ViewInject(id = R.id.announcement_object_workRole,click = "OnClick")
    View mWorkRole ;

    @ViewInject(id = R.id.confirm, click = "OnClick")
    View mViewConfirm;

    private ArrayList<AccountInfo> mObjectList = new ArrayList<>();
    private AnnouncementCreateObjectAdapter mAdapter;

    public static void launchForResult(Fragment fragment,int requestCode) {
        FragmentContainerActivity.launchForResult(fragment, AnnouncementCreateObjectFragment.class, null, requestCode);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_announcement_create_object;
    }

    public void onPrepareActionbarMenu(TextView menu,Activity activity) {
        menu.setText("全选");
    }

    @Override
    public void onActionBarMenuClick() {
        for(AccountInfo info:mObjectList){
            info.selected=true;
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("公告对象");
        mObjectListView.setOnItemClickListener(this);
        mAdapter = new AnnouncementCreateObjectAdapter(mObjectList, getActivity());
        mObjectListView.setAdapter(mAdapter);
    }

    private AnnouncementCreateObjectFragment.AnnounceObjectInfo getSelectObjects(){
        AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo=new AnnouncementCreateObjectFragment.AnnounceObjectInfo();
        for(AccountInfo itemInfo:mObjectList){
            if(!itemInfo.selected){
                continue;
            }
            selectInfo.users.add(itemInfo.userid);
        }

        return selectInfo;
    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = new HttpRequestParams();
        requestParams.put("PassWord", UserInfo.getCurrentUser().getPassword());
        requestParams.put("UserName",UserInfo.getCurrentUser().getUserName());

        startFormRequest(ApiUrls.NOTICE_CONTACTS_USERS, requestParams, new BaseHttpRequestTask<BaseResponseBean>() {
            @Override
            public AccountObjectListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, AccountObjectListResponseBean.class);
            }

            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                CharacterParser characterParser=CharacterParser.getInstance();
                super.onRequestFinished(resultCode, result);
                switch (resultCode) {
                    case success:
                        AccountObjectListResponseBean bean = Tools.parseJsonTostError(result, AccountObjectListResponseBean.class);
                        if (bean != null && bean.getEntityInfo() != null) {
                            mObjectList.clear();
                            for (AccountObjectListResponseBean.EntityInfoBean entityInfoBean : bean.getEntityInfo()) {
                                AccountInfo accountInfo = new AccountInfo();

                                accountInfo.userid = entityInfoBean.getUserid();
                                accountInfo.fullname = entityInfoBean.getFullname();
                                accountInfo.new_departmentid = entityInfoBean.getNew_departmentid();
                                accountInfo.new_departmentname = entityInfoBean.getNew_departmentname();
                                accountInfo.new_hyphenateid = entityInfoBean.getNew_hyphenateid();
                                accountInfo.new_headportrait = entityInfoBean.getNew_headportrait();

                                //汉字转换成拼音
                                String pinyin = characterParser.getSelling(accountInfo.fullname);
                                String sortString = pinyin.substring(0, 1).toUpperCase();
                                // 正则表达式，判断首字母是否是英文字母
                                if(sortString.matches("[A-Z]")){
                                    accountInfo.sortLetter=sortString.toUpperCase();
                                }else{
                                    accountInfo.sortLetter="#";
                                }

                                mObjectList.add(accountInfo);
                            }

                            Collections.sort(mObjectList, new PinyinComparator());

                            mAdapter.notifyDataSetChanged();
                        }
                        break;
                    default:
                        break;
                }
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    private class AnnouncementCreateObjectAdapter extends ABaseAdapter<AccountInfo> {

        public AnnouncementCreateObjectAdapter(ArrayList<AccountInfo> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<AccountInfo> newItemView() {
            return new ItemView();
        }
    }

    private class ItemView extends ABaseAdapter.AbstractItemView<AccountInfo>{
        @ViewInject(id = R.id.AccountName)
        TextView mViewAccountName ;

        @ViewInject(id = R.id.imgStatus)
        ImageView mViewStatus ;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_object;
        }

        @Override
        public void bindingData(View convertView, AccountInfo data) {
            Tools.setTextView(mViewAccountName,data.fullname);
            if(data.selected){
                mViewStatus.setImageResource(R.drawable.checkbox_sel);
            }else{
                mViewStatus.setImageResource(R.drawable.checkbox_unsel);
            }
        }
    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.announcement_object_departments:
                AnnouncementCreatetDepartFragment.launchForResult(this, REQUEST_CODE_DEPARTMENT,"按组织结构查看","58BC13E5-C132-E611-9C1B-085700E64E0F");
                break;
            case R.id.announcement_object_workRole:
                AnnouncementCreatetWorkFragment.launchForResult(this, REQUEST_CODE_WORK_ROLE, "按组织结构查看", null);
                break;
            case R.id.confirm:
                AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo= getSelectObjects();
                if(selectInfo.users.size()==0){
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
        if (requestCode == REQUEST_CODE_DEPARTMENT && resultCode == Activity.RESULT_OK) {
            AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo=(AnnouncementCreateObjectFragment.AnnounceObjectInfo)data.getSerializableExtra(AnnouncementCreatetWorkFragment.EXT_DATA_KEY);
            Intent intent=new Intent();
            intent.putExtra(AnnouncementCreateObjectFragment.EXT_DATA_KEY,selectInfo);
            getActivity().setResult(Activity.RESULT_OK, intent);
            getActivity().finish();
        }else if (requestCode == REQUEST_CODE_WORK_ROLE && resultCode == Activity.RESULT_OK) {
            AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo=(AnnouncementCreateObjectFragment.AnnounceObjectInfo)data.getSerializableExtra(AnnouncementCreatetDepartFragment.EXT_DATA_KEY);
            Intent intent=new Intent();
            intent.putExtra(AnnouncementCreateObjectFragment.EXT_DATA_KEY,selectInfo);
            getActivity().setResult(Activity.RESULT_OK, intent);
            getActivity().finish();
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AccountInfo accountInfo=mObjectList.get(position);
        accountInfo.selected=!accountInfo.selected;
        mAdapter.notifyDataSetChanged();

    }

    public class AccountInfo{
        boolean selected=false;
        String sortLetter;
        String userid;
        String fullname;
        String new_departmentid;
        String new_departmentname;
        String new_hyphenateid;
        String new_headportrait;
    }

    public class PinyinComparator implements Comparator<AccountInfo> {

        public int compare(AccountInfo o1, AccountInfo o2) {
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


    public static class AnnounceObjectInfo implements Serializable{
        private static final long serialVersionUID = -4579645433683409149L;

        public List<String> departs=new ArrayList<>();
        public List<String> roles=new ArrayList<>();
        public List<String> users=new ArrayList<>();
    }

}
