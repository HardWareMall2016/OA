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
import com.android.wandong.beans.InspectionReceptionApplicationContent;
import com.android.wandong.beans.MyAuditListResponseBean;
import com.android.wandong.beans.MyAuditResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.work.Tools.AuditStatusHelper;
import com.android.wandong.ui.fragment.work.Tools.MarketActivityApplicationDetailsFragment;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.utils.ToastUtils;

import java.text.DecimalFormat;
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

    private DecimalFormat mMoneyDf = new DecimalFormat();

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
        mMoneyDf.applyPattern("###,###.##元");

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
        mListViewMyAuditDetails.setOnItemClickListener(mOnSubListClick);
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

    private AdapterView.OnItemClickListener mOnSubListClick=new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            SubItem data=mSubItems.get((int) id);

            if("new_campaign".equals(data.entityName)){
                //市场活动费申请审批
                MarketActivityApplicationDetailsFragment.launch(getActivity(), data.CampaignId);
            }else if("new_campaigncost".equals(data.entityName)){
                //市场活动费报销审批
                MarketActivityReimbursementDetailsFragment.launch(getActivity(), data.CampaignId);
            }else if("new_contract".equals(data.entityName)){
                //合同申请审批
                //ContractApplicationDetailsFragment
            }else if("new_entertain".equals(data.entityName)){
                //招待费申请审批
                EntertainmentApplicationDetailsFragment.launch(getActivity(),data.EntertainId);
            }else if("new_entertaincost".equals(data.entityName)){
                //招待费报销审批
                EntertainmentReimbursementDetailFragment.launch(getActivity(),data.Id);
            }else if("new_reception".equals(data.entityName)){
                //考察接待申请审批
                //InspectionReceptionApplicationDetailsFragment
            }else if("new_special_payment".equals(data.entityName)){
                //专项费用报销审批
                SpecialDuesReimbursementDetailsFragment.launch(getActivity(),data.Id);
            }else if("new_tenderauthorization".equals(data.entityName)){
                //投标授权申请审批
                TenderApplicationDetailsFragment.launch(getActivity(), data.TenderAuthorizationId);
            }else if("new_travelcost".equals(data.entityName)){
                //差旅费报销审批
                //TravelExpenseReimbursementDetailsFragment.launch(getActivity(), content);
            }
        }
    };

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

        startFormRequest(ApiUrls.MY_AUDIT_LIST, requestParams, new HttpRequestHandler(this,mCurrentAuditItem.entityName){
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

                                    //招待费申请审批
                                    subItem.EntertainId=bean.getEntertainId();
                                    //private String ApplyNo;
                                    //private String AccountName;
                                    subItem.EstimateTotal=bean.getEstimateTotal();
                                    //private String Status;

                                    //招待费报销审批
                                    //private String Id;
                                    //private String ApplyNo;
                                    subItem.AccountName=bean.getAccountName();
                                    //private String Amount;
                                    //private String Status;


                                    //市场活动费申请审批
                                    subItem.CampaignId=bean.getCampaignId();
                                    //private String ApplyNo;
                                    //private String Name;
                                    subItem.CostTypeName=bean.getCostTypeName();
                                    //private String Status;
                                    subItem.OccurTime=bean.getOccurTime();
                                    //private String Amount;

                                    //专项费用报销审批
                                    subItem.Id=bean.getId();
                                    //private String ApplyNo;
                                    subItem.Amount=bean.getAmount();
                                    //private String Status;

                                    //考察接待申请审批
                                    subItem.ReceptionId=bean.getReceptionId();
                                    //private String AccountName;
                                    subItem.VisitName=bean.getVisitName();
                                    subItem.VisitNumber=bean.getVisitNumber();
                                    subItem.ComeTime=bean.getComeTime();
                                    //private String Status;
                                    //private String OwnerName;
                                    subItem.ApplyTime=bean.getApplyTime();

                                    //差旅费报销
                                    subItem.TravelCostId=bean.getTravelCostId();
                                    subItem.Name=bean.getName();
                                    subItem.ApprovalPrice=bean.getApprovalPrice();
                                    subItem.StepNumber=bean.getStepNumber();
                                    subItem.AuditStatus=bean.getAuditStatus();

                                    //投标授权申请审批
                                    subItem.TenderAuthorizationId=bean.getTenderAuthorizationId();
                                    //private String Name;
                                    subItem.ProjectName=bean.getProjectName();
                                    subItem.OpenTendersTime=bean.getOpenTendersTime();
                                    //private String Status;
                                    subItem.Quantity=bean.getQuantity();
                                    //private String OwnerName;

                                    //公共部分
                                    subItem.OwnerName=bean.getOwnerName();
                                    subItem.CreatedOn=bean.getCreatedOn();
                                    subItem.entityName= (String) getTag();

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
        @ViewInject(id = R.id.icon)
        ImageView mImgIcon ;

        @ViewInject(id = R.id.title_1)
        TextView mTitle1 ;

        @ViewInject(id = R.id.title_2)
        TextView mTitle2 ;

        @ViewInject(id = R.id.name)
        TextView mName ;

        @ViewInject(id = R.id.number)
        TextView mViewNumber ;

        @ViewInject(id = R.id.time)
        TextView mViewTime ;

        @ViewInject(id = R.id.img_status)
        ImageView mImgStatus ;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_sub_my_audit;
        }

        @Override
        public void bindingData(View convertView, SubItem data) {
            if("new_campaign".equals(data.entityName)){
                //市场活动费申请审批
                mImgIcon.setImageResource(R.drawable.icon_campaign);
                mTitle1.setText(data.ApplyNo);
                mTitle2.setText(String.format("%s(%s)",data.Name,data.CostTypeName));
                mName.setText(data.OwnerName);
                mViewTime.setText(data.OccurTime);
                double cost=0;
                try{
                    cost=Double.parseDouble(data.Amount);
                }catch (Exception ignored){

                }
                mViewNumber.setText(mMoneyDf.format(cost));
                AuditStatusHelper.setImageViewByStatus(mImgStatus, Integer.parseInt(data.Status));
            }else if("new_campaigncost".equals(data.entityName)){
                //市场活动费报销审批
                mImgIcon.setImageResource(R.drawable.icon_campaigncost);
                mTitle1.setText(data.ApplyNo);
                mTitle2.setText(String.format("%s(%s)",data.Name,data.CostTypeName));
                mName.setText(data.OwnerName);
                mViewTime.setText(data.OccurTime);
                double cost=0;
                try{
                    cost=Double.parseDouble(data.Amount);
                }catch (Exception ignored){

                }
                mViewNumber.setText(mMoneyDf.format(cost));
                AuditStatusHelper.setImageViewByStatus(mImgStatus, Integer.parseInt(data.Status));
            }else if("new_contract".equals(data.entityName)){
                //合同申请审批
                mImgIcon.setImageResource(R.drawable.icon_new_contract);
                mTitle1.setText(data.ContractName);
                mTitle2.setText(data.ApplyNo);
                mName.setText(data.OwnerName);
                mViewTime.setText(data.CreatedOn);
                double cost=0;
                try{
                    cost=Double.parseDouble(data.ContracTotal);
                }catch (Exception ignored){

                }
                mViewNumber.setText(mMoneyDf.format(cost));
                AuditStatusHelper.setImageViewByStatus(mImgStatus, Integer.parseInt(data.Status));
            }else if("new_entertain".equals(data.entityName)){
                //招待费申请审批
                mImgIcon.setImageResource(R.drawable.head_portrait_entertain_apply);
                mTitle1.setText(data.ApplyNo);
                mTitle2.setText(data.AccountName);
                mName.setText(data.OwnerName);
                mViewTime.setText(data.CreatedOn);
                double cost=0;
                try{
                    cost=Double.parseDouble(data.EstimateTotal);
                }catch (Exception ignored){

                }
                mViewNumber.setText(mMoneyDf.format(cost));
                AuditStatusHelper.setImageViewByStatus(mImgStatus, Integer.parseInt(data.Status));
            }else if("new_entertaincost".equals(data.entityName)){
                //招待费报销审批
                mImgIcon.setImageResource(R.drawable.icon_entertaincost);
                mTitle1.setText(data.ApplyNo);
                mTitle2.setText(data.AccountName);
                mName.setText(data.OwnerName);
                mViewTime.setText(data.CreatedOn);
                double cost=0;
                try{
                    cost=Double.parseDouble(data.Amount);
                }catch (Exception ignored){

                }
                mViewNumber.setText(mMoneyDf.format(cost));
                AuditStatusHelper.setImageViewByStatus(mImgStatus, Integer.parseInt(data.Status));
            }else if("new_reception".equals(data.entityName)){
                //考察接待申请审批
                mImgIcon.setImageResource(R.drawable.icon_reception);
                mTitle1.setVisibility(View.GONE);
                mTitle2.setText(data.AccountName);
                mName.setText(data.OwnerName);
                mViewTime.setText(data.ComeTime);
                double num=0;
                try{
                    num=Integer.parseInt(data.VisitNumber);
                }catch (Exception ignored){

                }
                mViewNumber.setText(String.format("%s人", num));
                AuditStatusHelper.setImageViewByStatus(mImgStatus, Integer.parseInt(data.Status));
            }else if("new_special_payment".equals(data.entityName)){
                //专项费用报销审批
                mImgIcon.setImageResource(R.drawable.icon_special);
                mTitle1.setVisibility(View.GONE);
                mTitle2.setText(data.ApplyNo);
                mName.setText(data.OwnerName);
                mViewTime.setText(data.CreatedOn);
                double cost=0;
                try{
                    cost=Double.parseDouble(data.Amount);
                }catch (Exception ignored){

                }
                mViewNumber.setText(mMoneyDf.format(cost));
                AuditStatusHelper.setImageViewByStatus(mImgStatus, Integer.parseInt(data.Status));
            }else if("new_tenderauthorization".equals(data.entityName)){
                //投标授权申请审批
                mImgIcon.setImageResource(R.drawable.icon_tenderauthorization);
                mTitle1.setVisibility(View.GONE);
                mTitle2.setText(data.Name);
                mName.setText(data.OwnerName);
                mViewTime.setText(data.OpenTendersTime);
                mViewNumber.setText(data.Quantity);
                AuditStatusHelper.setImageViewByStatus(mImgStatus, Integer.parseInt(data.Status));
            }else if("new_travelcost".equals(data.entityName)){
                //差旅费报销审批
                mImgIcon.setImageResource(R.drawable.icon_travel);
                mTitle1.setVisibility(View.GONE);
                mTitle2.setText(data.Name);
                mName.setText(data.OwnerName);
                mViewTime.setText(data.CreatedOn);
                double cost=0;
                try{
                    cost=Double.parseDouble(data.ApprovalPrice);
                }catch (Exception ignored){

                }
                mViewNumber.setText(mMoneyDf.format(cost));
                AuditStatusHelper.setImageViewByStatus(mImgStatus,Integer.parseInt(data.AuditStatus));
            }else {
                mImgIcon.setImageResource(R.drawable.icon_category_bb);
            }
        }
    }


    private class SubItem{
        //合同申请审批
        String ContractId;
        String ApplyNo;
        String ContractName;
        String Status;
        String ContracTotal;

        //市场活动费申请审批
        String CampaignId;
        //private String ApplyNo;
        //private String Name;
        String CostTypeName;
        //private String Status;
        String OccurTime;
        //private String Amount;

        //招待费申请审批
        String EntertainId;
        //private String ApplyNo;
        //private String AccountName;
        String EstimateTotal;
        //private String Status;

        //招待费报销审批
        //private String Id;
        //private String ApplyNo;
        String AccountName;
        //private String Amount;
        //private String Status;

        //考察接待申请审批
        String ReceptionId;
        //private String AccountName;
        String VisitName;
        String VisitNumber;
        String ComeTime;
        //private String Status;
        //private String OwnerName;
        String ApplyTime;

        //专项费用报销审批
        String Id;
        //private String ApplyNo;
        String Amount;
        //private String Status;

        //差旅费报销
        String TravelCostId;
        String Name;
        String ApprovalPrice;
        String StepNumber;
        String AuditStatus;

        //投标授权申请审批
        String TenderAuthorizationId;
        //private String Name;
        String ProjectName;
        String OpenTendersTime;
        //private String Status;
        String Quantity;
        //private String OwnerName;

        //公共部分
        String OwnerName;
        String CreatedOn;
        String entityName;
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
