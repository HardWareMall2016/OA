package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.App;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.beans.OutDoorSignDetailResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.FixGridView;
import com.android.wandong.utils.Tools;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/8/8 20:44
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
public class OutdoorSignEditFragment extends ABaseFragment implements TextWatcher{
    private final static String ARG_KEY="arg_key";
    private static final int REQUEST_CODE_LOCATION = 102;

    //View
    @ViewInject(id = R.id.sign_out_time)
    TextView mViewSignOutTime;

    @ViewInject(id = R.id.address_content, click = "OnClick")
    View mViewAddressContent;

    @ViewInject(id = R.id.sign_out_address)
    TextView mViewSignOutAddress;

    @ViewInject(id = R.id.customer)
    TextView mViewRelativeCustomer;

    @ViewInject(id = R.id.sign_in_time)
    TextView mViewSignInTime;

    @ViewInject(id = R.id.sign_in_address)
    TextView mViewSignInAddress;

    @ViewInject(id = R.id.remark)
    EditText mViewRemark;

    @ViewInject(id = R.id.remark_length_info)
    TextView mViewRemarkLength;

    @ViewInject(id = R.id.attachment_info)
    FixGridView mViewAttachmentInfo;

    @ViewInject(id = R.id.btn_sign_out, click = "OnClick")
    View mBtnSignOut;

    @ViewInject(id = R.id.sign_in_abnormal_title)
    TextView mViewSignInAdnormalTitle;

    @ViewInject(id = R.id.sign_in_abnormal)
    TextView mViewSignInAdnormal;

    //Data
    private String mSignId;
    private AddressInfo mAddressInfo;

    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    private LayoutInflater mInflater;

    public static void launch(Activity activity,String signId) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, signId);
        FragmentContainerActivity.launch(activity, OutdoorSignEditFragment.class, args);
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
        mViewRemark.addTextChangedListener(this);
        mViewSignOutTime.setText(Tools.parseTimeToMinutes(System.currentTimeMillis()));

        mLocationClient = new LocationClient(App.getInstance());     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数

        mLocationClient.start();
        initLocation();
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_outdoor_sign_edit;
    }

    @Override
    public void onDestroyView() {
        if (mLocationClient.isStarted()) {
            mLocationClient.stop();
        }
        mLocationClient.unRegisterLocationListener(myListener);
        mLocationClient = null;
        super.onDestroyView();
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.address_content:
                ChooseLocationFragment.launchForResult(this,REQUEST_CODE_LOCATION);
                break;
            case R.id.customer_content:
                break;
            case R.id.btn_sign_out:
                signOutRequest();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_LOCATION && resultCode == Activity.RESULT_OK) {
            mAddressInfo = new AddressInfo();
            mAddressInfo.Latitude = data.getDoubleExtra(ChooseLocationFragment.KEY_LATITUDE,0);
            mAddressInfo.Longitude = data.getDoubleExtra(ChooseLocationFragment.KEY_LONGITUDE, 0);
            mAddressInfo.address = data.getStringExtra(ChooseLocationFragment.KEY_ADDRESS);

            mViewSignInAddress.setText(mAddressInfo.address);
            mViewSignInAddress.setTextColor(0xff333333);
        }
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
                String errorMsg=Tools.verifyResponseResult(result);
                if(TextUtils.isEmpty(errorMsg)){
                    if(!TextUtils.isEmpty(result.getEntityInfo().getSignInfo().getSignOutAddress())){
                        errorMsg="已签出";
                    }
                }
                return errorMsg;
            }

            @Override
            protected void onSuccess(final OutDoorSignDetailResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了
                if (result != null && result.getEntityInfo() != null && result.getEntityInfo().getSignInfo() != null) {
                    long time=Tools.parseDateStrToLong(result.getEntityInfo().getSignInfo().getSignInTime());
                    Tools.setTextView(mViewSignInTime, Tools.parseTimeToMinutes(time));
                    Tools.setTextView(mViewSignInAddress, result.getEntityInfo().getSignInfo().getAddress());
                    Tools.setTextView(mViewRelativeCustomer, result.getEntityInfo().getSignInfo().getAccountName());
                    Tools.setTextView(mViewRemark, result.getEntityInfo().getSignInfo().getRemarks());

                    //签入异常
                    if(result.getEntityInfo().getSignInfo().getSignInAbnormal()==1){
                        mViewSignInAdnormalTitle.setVisibility(View.VISIBLE);
                        mViewSignInAdnormal.setVisibility(View.VISIBLE);
                        double distance=result.getEntityInfo().getSignInfo().getAbnormalDistance();
                        mViewSignInAdnormal.setText(Tools.parseDistance(distance));
                    }else{
                        mViewSignInAdnormalTitle.setVisibility(View.GONE);
                        mViewSignInAdnormal.setVisibility(View.GONE);
                    }

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
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    private void signOutRequest() {

        if(mAddressInfo==null||TextUtils.isEmpty(mAddressInfo.address)){
            ToastUtils.toast("请等待定位");
            return;
        }

        if (isRequestProcessing(ApiUrls.MYSIGN_SIGN_OUT)) {
            return;
        }

        HttpRequestParams requestParams = Tools.createHttpRequestParams();

        requestParams.put("Abnormal", 0);
        requestParams.put("Address", mAddressInfo.address);
        requestParams.put("signId", mSignId);
        requestParams.put("Remarks", mViewRemark.getText().toString());

        startFormRequest(ApiUrls.MYSIGN_SIGN_OUT, requestParams, new HttpRequestHandler(this) {
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                switch (resultCode) {
                    case success:
                        BaseResponseBean responseBean = Tools.parseJsonTostError(result, BaseResponseBean.class);
                        if (responseBean != null) {
                            ToastUtils.toast("签入出成功！");
                            getActivity().finish();
                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                        break;
                }
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        mViewRemarkLength.setText(String.format("%d/200", 200 - mViewRemark.length()));
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            Log.i("BaiduLocationApiDem", "onReceiveLocation");
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null && list.size() > 0 && !TextUtils.isEmpty(list.get(0).getName())) {

                mAddressInfo = new AddressInfo();
                mAddressInfo.Latitude = location.getLatitude();
                mAddressInfo.Longitude = location.getLongitude();
                mAddressInfo.address = list.get(0).getName();

                mViewSignOutAddress.setText(mAddressInfo.address);
                mViewSignOutAddress.setTextColor(0xff333333);

                if (mLocationClient != null && mLocationClient.isStarted()) {
                    mLocationClient.stop();
                }
            }
        }
    }

    private class AddressInfo {
        double Latitude;
        double Longitude;
        String address;
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
