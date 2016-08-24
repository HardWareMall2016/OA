package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.beans.OutDoorSignDetailResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.FixGridView;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.PixelUtils;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/7/21 13:52
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
public class OutdoorSignDetailFragment extends ABaseFragment {
    private final static String ARG_KEY = "arg_key";
    private String mSignId;

    @ViewInject(id = R.id.relative_customer)
    TextView mViewRelativeCustomer;

    @ViewInject(id = R.id.sign_in_time)
    TextView mViewSignInTime;

    @ViewInject(id = R.id.sign_in_address)
    TextView mViewSignInAddress;

    @ViewInject(id = R.id.sign_out_time)
    TextView mViewSignOutTime;

    @ViewInject(id = R.id.sign_out_address)
    TextView mViewSignOutAddress;

    @ViewInject(id = R.id.remark)
    TextView mViewRemark;

    @ViewInject(id = R.id.attachment_info)
    FixGridView mViewAttachmentInfo;

    private LayoutInflater mInflater;

    public static void launch(Activity activity, String signId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, signId);
        FragmentContainerActivity.launch(activity, OutdoorSignDetailFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSignId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mSignId);
    }


    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mInflater=inflater;
        getActivity().setTitle("外勤签到详情");
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_outdoor_sign_detail;
    }


    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("signId", mSignId);
        startFormRequest(ApiUrls.OUTDOOR_SIGN_DETAIL, requestParams, new BaseHttpRequestTask<OutDoorSignDetailResponseBean>() {
            @Override
            public OutDoorSignDetailResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, OutDoorSignDetailResponseBean.class);
            }

            @Override
            public String verifyResponseResult(OutDoorSignDetailResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(final OutDoorSignDetailResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了
                if (result != null && result.getEntityInfo() != null && result.getEntityInfo().getSignInfo() != null) {
                    Tools.setTextView(mViewSignInAddress, result.getEntityInfo().getSignInfo().getAddress());
                    Tools.setTextView(mViewSignOutAddress, result.getEntityInfo().getSignInfo().getSignOutAddress());
                    Tools.setTextView(mViewRelativeCustomer, result.getEntityInfo().getSignInfo().getAccountName());
                    Tools.setTextView(mViewRemark, result.getEntityInfo().getSignInfo().getRemarks());

                    long signInTime=Tools.parseDateStrToLong(result.getEntityInfo().getSignInfo().getSignInTime());
                    mViewSignInTime.setText(Tools.parseTimeToMinutes(signInTime));

                    long signOutTime=Tools.parseDateStrToLong(result.getEntityInfo().getSignInfo().getSignOutTime());
                    mViewSignOutTime.setText(Tools.parseTimeToMinutes(signOutTime));

                    if(result.getEntityInfo().getAttachmentInfo().size()==0){
                        mViewAttachmentInfo.setVisibility(View.GONE);
                    }else {
                        mViewAttachmentInfo.setVisibility(View.VISIBLE);
                        mViewAttachmentInfo.setAdapter(new GridViewAdapter(result.getEntityInfo().getAttachmentInfo()));
                        mViewAttachmentInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                OutdoorSignAttachmentsFragment.ParamsBean paramsBean=new OutdoorSignAttachmentsFragment.ParamsBean();
                                paramsBean.photos=result.getEntityInfo().getAttachmentInfo();
                                paramsBean.showPos=position;
                                paramsBean.address=result.getEntityInfo().getSignInfo().getAddress();
                                long signTime=Tools.parseDateStrToLong(result.getEntityInfo().getSignInfo().getSignOutTime());
                                paramsBean.time=signTime;
                                OutdoorSignAttachmentsFragment.launch(getActivity(), paramsBean);
                            }
                        });
                    }
                }


                /*mViewContentImgs.removeAllViews();

                if (result != null && result.getEntityInfo() != null && result.getEntityInfo().getAttachmentInfo() != null) {
                    for (String imgUrl : result.getEntityInfo().getAttachmentInfo()) {
                        ImageView imageView = new ImageView(getActivity());
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ImageLoader.getInstance().displayImage(imgUrl, imageView, Tools.buildDefDisplayImgOptions());
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(PixelUtils.dp2px(90), PixelUtils.dp2px(90));
                        lp.leftMargin = PixelUtils.dp2px(8);
                        mViewContentImgs.addView(imageView, lp);
                    }
                }*/
            }
        }, HttpRequestUtils.RequestType.POST);
    }


    private class GridViewAdapter extends BaseAdapter {
        List<String> mAttachmentInfo=new ArrayList<>();
        public GridViewAdapter( List<String> attachmentInfo){
            mAttachmentInfo=attachmentInfo;
        }

        @Override
        public int getCount() {
            return mAttachmentInfo.size();
        }

        @Override
        public Object getItem(int position) {
            return mAttachmentInfo.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            GridViewHolder holder;
            if(convertView==null){
                convertView=mInflater.inflate(R.layout.list_item_common_attachment,null);
                holder=new GridViewHolder(convertView);
            }else{
                holder= (GridViewHolder)convertView.getTag();
            }

            ImageLoader.getInstance().displayImage(mAttachmentInfo.get(position), holder.viewAttachment, Tools.buildDefDisplayImgOptions());

            return convertView;
        }
    }

    private class GridViewHolder{
        public ImageView viewAttachment;
        public GridViewHolder(View convertView){
            viewAttachment=(ImageView)convertView.findViewById(R.id.attachment);
            convertView.setTag(this);
        }
    }
}
