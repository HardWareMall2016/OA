package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.EntertainApplyListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.work.Tools.AuditStatusHelper;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;

import java.text.DecimalFormat;
import java.util.List;

/**
 * 作者：伍岳 on 2016/7/29 16:20
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
public class EntertainmentApplicationFragment extends BaseWorkPageFragment<EntertainmentApplicationFragment.ItemData, EntertainApplyListResponseBean> {
    public static final String TAB_TYPE="ENTERTAINMENT_APPLICATION";
    public static final String TAB_NAME="招待费申请";

    private DecimalFormat mMoneyFormat = new DecimalFormat();

    private DisplayImageOptions mDisplayImageOptions=Tools.buildDisplayImgOptions(R.drawable.head_portrait_entertain_apply);

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);

        /*几个未传参数
        requestParams.put("IsJustLookOwner", "");//只看我的
        requestParams.put("Province", "");//省份
        requestParams.put("AuditStatus", "");//审批状态
        requestParams.put("BeginDate", "");//开始时间
        requestParams.put("EndDate", "");//结束时间
        */

        mMoneyFormat.applyPattern("###,##0.00元");
    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.ENTERTAIN_APPLY_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(EntertainApplyListResponseBean baseResponseBean, List<ItemData> items) {
        if(baseResponseBean.getEntityInfo()!=null){
            for(EntertainApplyListResponseBean.EntityInfoBean beanItem:baseResponseBean.getEntityInfo()){
                ItemData item=new ItemData();
                item.EntertainId=beanItem.getEntertainId();
                item.ApplyNo=beanItem.getApplyNo();
                item.EstimateTotal=beanItem.getEstimateTotal();
                item.AccountId=beanItem.getAccountId();
                item.AccountName=beanItem.getAccountName();
                item.Reason=beanItem.getReason();
                item.Number=beanItem.getNumber();
                item.PersonalImage=beanItem.getPersonalImage();
                item.OwnerName=beanItem.getOwnerName();
                item.CreatedOn=beanItem.getCreatedOn();
                item.Status=beanItem.getStatus();
                items.add(item);
            }
        }
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ItemData> newItemView() {
        return new ListItemView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EntertainmentApplicationDetailsFragment.launch(getActivity(),getAdapterItems().get((int)id).EntertainId);
    }

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData>{

        @ViewInject(id = R.id.headPortrait)
        protected ImageView mViewHeadPortrait;

        @ViewInject(id = R.id.ApplyNo)
        protected TextView mViewApplyNo;

        @ViewInject(id = R.id.AccountName)
        protected TextView mViewAccountNamet;

        @ViewInject(id = R.id.name)
        protected TextView mViewName;

        @ViewInject(id = R.id.money)
        protected TextView mViewMoney;

        @ViewInject(id = R.id.time)
        protected TextView mViewTime;

        @ViewInject(id = R.id.img_status)
        protected ImageView mViewImgStatus;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_entertainment_application;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            ImageLoader.getInstance().displayImage(data.PersonalImage, mViewHeadPortrait, mDisplayImageOptions);

            Tools.setTextView(mViewApplyNo, data.ApplyNo);
            Tools.setTextView(mViewAccountNamet,data.AccountName);
            Tools.setTextView(mViewName,data.OwnerName);
            Tools.setTextView(mViewMoney,  mMoneyFormat.format(data.EstimateTotal));
            //Tools.setTextView(mViewApplyNo,data.ApplyNo);
            AuditStatusHelper.setImageViewByStatus(mViewImgStatus,data.Status);
        }
    }

    public class ItemData {
        String EntertainId;
        String ApplyNo;
        double EstimateTotal;
        String AccountId;
        String AccountName;
        String Reason;
        int Number;
        String PersonalImage;
        String OwnerName;
        String CreatedOn;
        int Status;
    }
}
