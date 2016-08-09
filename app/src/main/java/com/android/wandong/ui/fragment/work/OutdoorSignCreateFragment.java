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
import android.widget.EditText;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.App;
import com.android.wandong.utils.Tools;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.ui.fragment.AStripTabsFragment;
import com.zhan.framework.ui.widget.ActionSheetDialog;

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
public class OutdoorSignCreateFragment extends ABaseFragment implements TextWatcher {

    private static final int REQUEST_CODE_CUSTOMER=100;

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

    @ViewInject(id = R.id.imgAddPhoto, click = "OnClick")
    View mBtnAddPhoto;

    //Data
    private String mCustomerId;


    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

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
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_outdoor_sign_create;
    }

    @Override
    public void onDestroyView() {
        if(mLocationClient.isStarted()){
            mLocationClient.stop();
        }
        mLocationClient.unRegisterLocationListener(myListener);
        mLocationClient=null;
        super.onDestroyView();
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.address_content:
                break;
            case R.id.customer_content:
                AccountListFragment.launchForResult(this,REQUEST_CODE_CUSTOMER);
                break;
            case R.id.imgAddPhoto:
                ActionSheetDialog actionSheetDialog=new ActionSheetDialog(getActivity());
                actionSheetDialog.builder();
                actionSheetDialog.addSheetItem("拍照", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener(){
                    @Override
                    public void onClick(int which) {

                    }
                });
                actionSheetDialog.addSheetItem("相册", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener(){
                    @Override
                    public void onClick(int which) {

                    }
                });

                actionSheetDialog.show();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CUSTOMER && resultCode == Activity.RESULT_OK) {
            mViewSignInCustomer.setText(data.getStringExtra(AccountListFragment.KEY_ACCOUNT_NAME));
            mViewSignInCustomer.setTextColor(0xff333333);
            mCustomerId=data.getStringExtra(AccountListFragment.KEY_ACCOUNT_ID);
        }
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
                mViewSignInAddress.setText(list.get(0).getName());
                mViewSignInAddress.setTextColor(0xff333333);
                if(mLocationClient!=null&&mLocationClient.isStarted()){
                    mLocationClient.stop();
                }
            }
        }
    }
}
