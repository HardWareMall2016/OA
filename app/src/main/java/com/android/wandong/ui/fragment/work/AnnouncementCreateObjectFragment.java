package com.android.wandong.ui.fragment.work;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.AccountObjectListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import java.util.ArrayList;

/**
 * Created by ${keke} on 16/8/10.
 */
public class AnnouncementCreateObjectFragment extends ABaseFragment implements AdapterView.OnItemClickListener {

    @ViewInject(id = R.id.lv_object_listview)
    ListView mObjectListView;
    @ViewInject(id = R.id.announcement_object_departments,click = "OnClick")
    RelativeLayout mDepartMent;
    @ViewInject(id = R.id.announcement_object_workRole,click = "OnClick")
    RelativeLayout mWorkRole ;

    private ArrayList<AccountInfo> mObjectList = new ArrayList<>();
    private AnnouncementCreateObjectAdapter mAdapter;
    private int mSelectedPos = -1;

    public static void launch(AnnouncementCreateFragment activity,int requestCode) {
        FragmentContainerActivity.launchForResult(activity, AnnouncementCreateObjectFragment.class, null, requestCode);
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

    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("公告对象");
        mSelectedPos = -1;

        mObjectListView.setOnItemClickListener(this);
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
                                mObjectList.add(accountInfo);
                            }
                            mAdapter = new AnnouncementCreateObjectAdapter(mObjectList, getActivity());
                            mObjectListView.setAdapter(mAdapter);
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
            if(mSelectedPos == getPosition()){
                mViewStatus.setImageResource(R.drawable.checkbox_sel);
            }else{
                mViewStatus.setImageResource(R.drawable.checkbox_unsel);
            }
        }
    }

    void OnClick(View view){
        switch (view.getId()){
            case R.id.announcement_object_departments:
                AnnouncementCreatetDepartFragment.launch(getActivity());
                break;
            case R.id.announcement_object_workRole:
                AnnouncementCreatetWorkFragment.launch(getActivity());
                break;
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mSelectedPos!=id){
            mSelectedPos= (int) id;
            mAdapter.notifyDataSetChanged();
        }
    }

    public class AccountInfo{
        String userid;
        String fullname;
        String new_departmentid;
        String new_departmentname;
        String new_hyphenateid;
        String new_headportrait;
    }

}
