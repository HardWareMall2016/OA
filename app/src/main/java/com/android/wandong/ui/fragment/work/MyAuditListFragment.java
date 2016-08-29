package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.android.wandong.R;
import com.android.wandong.beans.MyAuditListResponseBean;
import com.android.wandong.beans.MyAuditResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/8/28 14:42
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
public class MyAuditListFragment extends BaseWorkPageFragment<MyAuditListFragment.MyAuditItem, MyAuditResponseBean> {

    public static final String TAB_TYPE = "myAudit";
    public static final String TAB_NAME = "待我审批";

    private final int SUB_LIST_SIZE =20;


    @ViewInject(idStr = "sub_content")
    protected LinearLayout mViewContentSub;

    @ViewInject(id = R.id.sub_header, click = "OnClick")
    protected View mViewContentSubHeader;

    @ViewInject(id = R.id.icon)
    protected ImageView mHeaderImgIcon;

    @ViewInject(id = R.id.title)
    protected TextView mHeaderTvTitle;

    @ViewInject(id = R.id.number)
    protected TextView mHeaderTvNumber;

    @ViewInject(idStr = "my_audit_detail_list")
    protected PullToRefreshListView mListViewMyAuditDetails;

    private Handler mHandler = new Handler();

    private boolean mShowSubList=false;

    private ArrayList<SubItem> mSubItems =new ArrayList<>();

    private SubAdapter mSubAdapter;
    private MyAuditItem mCurrentAuditItem;

    private boolean mCanSubListLoadMore=false;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_my_audit_list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mHandler.removeCallbacks(mRefreshCompleteRunnable);
    }

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {

    }

    @Override
    public boolean showSearchHeader() {
        return false;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mShowSubList=false;

        initPullDownLable();
        initPullUpLable(true);
        mListViewMyAuditDetails.setMode(PullToRefreshBase.Mode.BOTH);
        mListViewMyAuditDetails.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉刷新
                initPullUpLable(true);

                querySubList(1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上拉加载更多
                if (!mCanSubListLoadMore) {
                    refreshViewComplete();
                    return;
                }

                querySubList(getNextSubPage());
            }
        });
        mSubAdapter=new SubAdapter(mSubItems,getActivity());
        mListViewMyAuditDetails.setAdapter(mSubAdapter);
    }

    @Override
    protected void setInitPullToRefresh(ListView listView, PullToRefreshListView pullToRefreshListView, Bundle savedInstanceState) {
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        super.setInitPullToRefresh(listView, pullToRefreshListView, savedInstanceState);
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.MY_AUDIT_NUMBER;
    }

    @Override
    protected void parseResponseBeanToItemDataList(MyAuditResponseBean baseResponseBean, List<MyAuditItem> items) {
        if (baseResponseBean != null && baseResponseBean.getEntityInfo() != null) {
            for (MyAuditResponseBean.EntityInfoBean bean : baseResponseBean.getEntityInfo()) {
                MyAuditItem item = new MyAuditItem();
                item.entityName = bean.getEntityName();
                item.name = bean.getName();
                item.number = bean.getNumber();
                items.add(item);
            }
        }
    }

    private void refreshViewVisible(){
        if(mShowSubList){
            mViewContentSub.setVisibility(View.VISIBLE);
            mPullToRefreshListView.setVisibility(View.GONE);
        }else{
            mViewContentSub.setVisibility(View.GONE);
            mPullToRefreshListView.setVisibility(View.VISIBLE);
        }
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.sub_header:
                mShowSubList=false;
                refreshViewVisible();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mCurrentAuditItem=getAdapterItems().get((int)id);
        mShowSubList=true;

        mHeaderTvTitle.setText(mCurrentAuditItem.name);
        mHeaderTvNumber.setText(String.valueOf(mCurrentAuditItem.number));
        setIcon(mHeaderImgIcon, mCurrentAuditItem);

        mSubItems.clear();
        mSubAdapter.notifyDataSetChanged();
        
        refreshViewVisible();
        showRotateProgressDialog("请求中...",false);
        querySubList(1);
    }

    @Override
    protected ABaseAdapter.AbstractItemView<MyAuditItem> newItemView() {
        return new MyAuditViewItem();
    }

    private class MyAuditViewItem extends ABaseAdapter.AbstractItemView<MyAuditItem> {
        @ViewInject(id = R.id.icon)
        ImageView mImgIcon;

        @ViewInject(id = R.id.title)
        TextView mTvTitle;

        @ViewInject(id = R.id.number)
        TextView mTvNumber;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_my_audit;
        }

        @Override
        public void bindingData(View convertView, MyAuditItem data) {
            mTvTitle.setText(data.name);
            mTvNumber.setText(String.valueOf(data.number));
            setIcon(mImgIcon,data);
        }
    }

    private void setIcon(ImageView mImgIcon,MyAuditItem data){
        if("new_campaign".equals(data.entityName)){
            //市场活动费申请审批
            mImgIcon.setImageResource(R.drawable.icon_category_schdfsq);
        }else if("new_campaigncost".equals(data.entityName)){
            //市场活动费报销审批
            mImgIcon.setImageResource(R.drawable.icon_category_schdfbx);
        }else if("new_contract".equals(data.entityName)){
            //合同申请审批
            mImgIcon.setImageResource(R.drawable.icon_category_htsq);
        }else if("new_entertain".equals(data.entityName)){
            //招待费申请审批
            mImgIcon.setImageResource(R.drawable.icon_category_zdfsq);
        }else if("new_entertaincost".equals(data.entityName)){
            //招待费报销审批
            mImgIcon.setImageResource(R.drawable.icon_category_zdfbx);
        }else if("new_reception".equals(data.entityName)){
            //考察接待申请审批
            mImgIcon.setImageResource(R.drawable.icon_category_kcjdsq);
        }else if("new_special_payment".equals(data.entityName)){
            //专项费用报销审批
            mImgIcon.setImageResource(R.drawable.icon_category_zxfbx);
        }else if("new_tenderauthorization".equals(data.entityName)){
            //投标授权申请审批
            mImgIcon.setImageResource(R.drawable.icon_category_ztbsq);
        }else if("new_travelcost".equals(data.entityName)){
            //差旅费报销审批
            mImgIcon.setImageResource(R.drawable.icon_category_clfbx);
        }else {
            mImgIcon.setImageResource(R.drawable.icon_category_bb);
        }
    }

    public static class MyAuditItem {
        public int number;
        public String entityName;
        public String name;
    }

    private int getNextSubPage(){
        int page=mSubItems.size()/SUB_LIST_SIZE+1;
        return page;
    }

    private void querySubList(int pageIndex){
        if(pageIndex==1){
            mSubItems.clear();
        }

        HttpRequestParams requestParams= Tools.createHttpRequestParams();
        requestParams.put("EntityName",mCurrentAuditItem.entityName);
        requestParams.put("OwnerId","");
        requestParams.put("PageIndex",pageIndex);
        requestParams.put("PageNumber", SUB_LIST_SIZE);

        startFormRequest(ApiUrls.MY_AUDIT_LIST, requestParams, new HttpRequestHandler(this){
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                closeRotateProgressDialog();
                refreshViewComplete();
                switch (resultCode){
                    case success:
                        MyAuditListResponseBean responseBean=Tools.parseJsonTostError(result,MyAuditListResponseBean.class);
                        if(responseBean!=null){
                            if(responseBean.getEntityInfo()!=null){
                                mCanSubListLoadMore=responseBean.getEntityInfo().size()>=SUB_LIST_SIZE;
                                for(MyAuditListResponseBean.EntityInfoBean bean:responseBean.getEntityInfo()){
                                    SubItem subItem=new SubItem();
                                    subItem.ContractId=bean.getContractId();
                                    subItem.ApplyNo=bean.getApplyNo();
                                    subItem.ContractName=bean.getContractName();
                                    subItem.Status=bean.getStatus();
                                    subItem.ContracTotal=bean.getContracTotal();
                                    subItem.OwnerName=bean.getOwnerName();
                                    subItem.CreatedOn=bean.getCreatedOn();
                                    mSubItems.add(subItem);
                                }
                                mSubAdapter.notifyDataSetChanged();
                            }
                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                        break;
                }
            }
        }, HttpRequestUtils.RequestType.POST );
    }

    private class SubAdapter extends ABaseAdapter<SubItem>{

        public SubAdapter(ArrayList<SubItem> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<SubItem> newItemView() {
            return new SubItemView();
        }
    }

    private class SubItemView extends ABaseAdapter.AbstractItemView<SubItem>{
        @Override
        public int inflateViewId() {
            return R.layout.list_item_sub_my_audit;
        }

        @Override
        public void bindingData(View convertView, SubItem data) {

        }
    }


    private class SubItem{
        String ContractId;
        String ApplyNo;
        String ContractName;
        String Status;
        String ContracTotal;
        String OwnerName;
        String CreatedOn;
    }


    private void initPullDownLable() {
        mListViewMyAuditDetails.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新");
        mListViewMyAuditDetails.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
        mListViewMyAuditDetails.getLoadingLayoutProxy(true, false).setReleaseLabel("释放开始刷新");
    }

    private void initPullUpLable(boolean canLoadMore) {
        if (canLoadMore) {
            mListViewMyAuditDetails.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载");
            mListViewMyAuditDetails.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载更多");
            mListViewMyAuditDetails.getLoadingLayoutProxy(false, true).setReleaseLabel("释放开始加载");
        } else {
            mListViewMyAuditDetails.getLoadingLayoutProxy(false, true).setRefreshingLabel("没有更多数据了");
            mListViewMyAuditDetails.getLoadingLayoutProxy(false, true).setPullLabel("没有更多数据了");
            mListViewMyAuditDetails.getLoadingLayoutProxy(false, true).setReleaseLabel("没有更多数据了");
        }
    }

    public void refreshViewComplete() {
        mHandler.removeCallbacks(mRefreshCompleteRunnable);
        mHandler.postDelayed(mRefreshCompleteRunnable, 50);
    }

    private Runnable mRefreshCompleteRunnable = new Runnable() {
        @Override
        public void run() {
            mListViewMyAuditDetails.onRefreshComplete();
        }
    };
}
