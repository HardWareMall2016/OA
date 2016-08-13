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
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.FixGridView;
import com.android.wandong.utils.ExtendMediaPicker;
import com.android.wandong.utils.Tools;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.ui.widget.ActionSheetDialog;
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
public class OutdoorSignCreateFragment extends ABaseFragment implements TextWatcher, ExtendMediaPicker.OnMediaPickerListener ,AdapterView.OnItemClickListener {

    private static final int REQUEST_CODE_CUSTOMER = 100;

    //View
    @ViewInject(id = R.id.sign_in_time)
    TextView mViewSignInTime;

    @ViewInject(id = R.id.address_content, click = "OnClick")
    View mViewAddressContent;

    @ViewInject(id = R.id.sign_in_address)
    TextView mViewSignInAddress;

    @ViewInject(id = R.id.customer_content, click = "OnClick")
    View mViewCustomerContent;

    @ViewInject(id = R.id.customer)
    TextView mViewSignInCustomer;

    @ViewInject(id = R.id.remark)
    EditText mViewRemark;

    @ViewInject(id = R.id.remark_length_info)
    TextView mViewRemarkLength;

    @ViewInject(id = R.id.btn_sign_in, click = "OnClick")
    View mBtnSignIn;

    /*@ViewInject(id = R.id.imgAddPhoto, click = "OnClick")
    View mBtnAddPhoto;*/

    @ViewInject(id = R.id.photos)
    protected FixGridView mFixGridView;

    //Data
    private String mCustomerId;
    private AddressInfo mAddressInfo;
    private ArrayList<String> mMeidaUri = new ArrayList<>();

    private ExtendMediaPicker mExtendMediaPicker;

    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    private AttachmentAdapter mAdapter;

    private LayoutInflater mInflater;

    public static void launch(Activity activity) {
        FragmentContainerActivity.launch(activity, OutdoorSignCreateFragment.class, null);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("外勤签到");
        mViewRemark.addTextChangedListener(this);
        mViewSignInTime.setText(Tools.parseTimeToMintues(System.currentTimeMillis()));

        mLocationClient = new LocationClient(App.getInstance());     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数

        mLocationClient.start();
        initLocation();

        mExtendMediaPicker = new ExtendMediaPicker(getActivity());
        mExtendMediaPicker.setOnMediaPickerListener(this);

        mInflater=inflater;
        //图片,最后一个表示添加
        mMeidaUri.clear();
        mMeidaUri.add("add_new");
        mAdapter = new AttachmentAdapter(mMeidaUri,getActivity());
        mFixGridView.setAdapter(mAdapter);
        mFixGridView.setOnItemClickListener(this);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_outdoor_sign_create;
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
                ChooseLocationFragment.launch(getActivity());
                break;
            case R.id.customer_content:
                AccountListFragment.launchForResult(this, REQUEST_CODE_CUSTOMER);
                break;
            case R.id.btn_sign_in:
                signInRequest();
                break;
        }
    }

    private void signInRequest() {
        if (isRequestProcessing(ApiUrls.MYSIGN_SIGNIN)) {
            return;
        }
        HttpRequestParams requestParams = Tools.createHttpRequestParams();

        //DistanceUtil.getDistance()

        requestParams.put("Abnormal", 1);
        requestParams.put("AbnormalDistance", 21337.287181);
        requestParams.put("AccountId", mCustomerId);
        requestParams.put("Address", mAddressInfo.address);
        requestParams.put("AttaRelationId", "");
        requestParams.put("Latitude", mAddressInfo.Latitude);
        requestParams.put("LocTime", Tools.parseTimeToMintues(System.currentTimeMillis()));
        requestParams.put("Longitude", mAddressInfo.Longitude);
        requestParams.put("Remarks", mViewRemark.getText().toString());

        startFormRequest(ApiUrls.MYSIGN_SIGNIN, requestParams, new HttpRequestHandler(this) {
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                switch (resultCode) {
                    case success:
                        BaseResponseBean responseBean = Tools.parseJsonTostError(result, BaseResponseBean.class);
                        if (responseBean != null) {
                            ToastUtils.toast("签入成功！");
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CUSTOMER && resultCode == Activity.RESULT_OK) {
            mViewSignInCustomer.setText(data.getStringExtra(AccountListFragment.KEY_ACCOUNT_NAME));
            mViewSignInCustomer.setTextColor(0xff333333);
            mCustomerId = data.getStringExtra(AccountListFragment.KEY_ACCOUNT_ID);
        }

        mExtendMediaPicker.onActivityResult(requestCode, resultCode, data);
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

    @Override
    public void onSelectedMediaChanged(String mediaUri) {
        mMeidaUri.add(0, mediaUri);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mMeidaUri.size()-1==position){
            ActionSheetDialog actionSheetDialog = new ActionSheetDialog(getActivity());
            actionSheetDialog.builder();
            actionSheetDialog.addSheetItem("拍照", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                @Override
                public void onClick(int which) {
                    mExtendMediaPicker.openSystemCamera(OutdoorSignCreateFragment.this);
                }
            });
            actionSheetDialog.addSheetItem("相册", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                @Override
                public void onClick(int which) {
                    mExtendMediaPicker.openSystemPickImage(OutdoorSignCreateFragment.this);
                }
            });
            actionSheetDialog.show();
        }
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

                mViewSignInAddress.setText(mAddressInfo.address);
                mViewSignInAddress.setTextColor(0xff333333);

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

    private class AttachmentAdapter extends ABaseAdapter<String> {
        public AttachmentAdapter(ArrayList<String> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<String> newItemView() {
            return new AttachmentItemView();
        }
    }

    private class AttachmentItemView extends ABaseAdapter.AbstractItemView<String> {
        @ViewInject(id = R.id.attachment)
        ImageView mViewAttachment;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_common_attachment;
        }

        @Override
        public void bindingData(View convertView, String data) {
            if(getPosition()==getSize()-1){
                ImageLoader.getInstance().displayImage("drawable://" + R.drawable.icon_sign_in_add_photo, mViewAttachment, Tools.buildDefDisplayImgOptions());
            } else {
                ImageLoader.getInstance().displayImage("file://"+data, mViewAttachment, Tools.buildDefDisplayImgOptions());
            }
        }
    }

}
