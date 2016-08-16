package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.App;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/8/10 23:17
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
public class ChooseLocationFragment extends ABaseFragment implements OnGetGeoCoderResultListener ,AdapterView.OnItemClickListener {
    public static String KEY_LATITUDE="Latitude";
    public static String KEY_LONGITUDE="Longitude";
    public static String KEY_ADDRESS="Address";

    @ViewInject(id = R.id.bmapView)
    MapView mMapView;

    private BaiduMap mBaiduMap = null;

    @ViewInject(id = R.id.addressList)
    ListView mViewAddressList;

    ArrayList<PoiInfo> mAddressInfoList = new ArrayList<>();


    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    boolean isFirstLoc = true;

    GeoCoder mSearch = null; // 搜索模块，也可去掉地图模块独立使用

    public static void launchForResult(ABaseFragment from, int requestCode) {
        FragmentContainerActivity.launchForResult(from, ChooseLocationFragment.class, null, requestCode);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_choose_location;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);

        getActivity().setTitle("选择地址");

        mAddressInfoList.clear();
        mViewAddressList.setOnItemClickListener(this);

        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);

        mLocationClient = new LocationClient(App.getInstance());     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数
        mLocationClient.start();
        initLocation();
        mSearch = GeoCoder.newInstance();
        mSearch.setOnGetGeoCodeResultListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mLocationClient.isStarted()) {
            mLocationClient.stop();
        }
        mLocationClient.unRegisterLocationListener(myListener);
        mLocationClient = null;

        mBaiduMap.setMyLocationEnabled(false);
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();

        //释放该地理编码查询对象
        mSearch.destroy();
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
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

    }

    @Override
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
            ToastUtils.toast("抱歉，未能找到结果");
            return;
        }
        if (reverseGeoCodeResult.getPoiList() != null && reverseGeoCodeResult.getPoiList().size() > 0) {
            mAddressInfoList.clear();
            mAddressInfoList.addAll(reverseGeoCodeResult.getPoiList());
            mViewAddressList.setAdapter(new AddressAdapter(mAddressInfoList, getActivity()));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PoiInfo poiInfo=mAddressInfoList.get(position);
        Intent intent=new Intent();
        intent.putExtra(KEY_LATITUDE,poiInfo.location.latitude);
        intent.putExtra(KEY_LONGITUDE,poiInfo.location.longitude);
        intent.putExtra(KEY_ADDRESS,poiInfo.name);
        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();
    }

    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            Log.i("BaiduLocationApiDem", "onReceiveLocation");
            if (mMapView == null) {
                return;
            }

            if(location==null){
                return;
            }
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null && list.size() > 0 && !TextUtils.isEmpty(list.get(0).getName())) {

                MyLocationData locData = new MyLocationData.Builder().accuracy(location.getRadius()).direction(100).latitude(location.getLatitude()).longitude(location.getLongitude()).build();
                LatLng curLatLng = new LatLng(location.getLatitude(), location.getLongitude());
                if (isFirstLoc) {
                    isFirstLoc = false;

                    MapStatus mMapStatus = new MapStatus.Builder().target(curLatLng).zoom(15).build();
                    MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
                    mBaiduMap.animateMapStatus(mMapStatusUpdate);
                }

                mBaiduMap.setMyLocationData(locData);

                if (mLocationClient != null && mLocationClient.isStarted()) {
                    mLocationClient.stop();
                }
                mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(curLatLng));
            }
        }
    }

    private class AddressAdapter extends ABaseAdapter<PoiInfo> {

        public AddressAdapter(ArrayList<PoiInfo> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<PoiInfo> newItemView() {
            return new PosItemView();
        }

        private class PosItemView extends AbstractItemView<PoiInfo> {
            @ViewInject(id = R.id.name)
            TextView mViewName;

            @ViewInject(id = R.id.address)
            TextView mViewAddress;

            @Override
            public int inflateViewId() {
                return R.layout.list_item_location_address;
            }

            @Override
            public void bindingData(View convertView, PoiInfo data) {
                mViewName.setText(data.name);
                mViewAddress.setText(data.address);
            }
        }
    }
}
