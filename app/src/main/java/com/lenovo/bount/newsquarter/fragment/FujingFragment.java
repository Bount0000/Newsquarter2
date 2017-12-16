package com.lenovo.bount.newsquarter.fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MyLocationStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.GetNearAdapter;
import com.lenovo.bount.newsquarter.bean.GetNearVideoBean;
import com.lenovo.bount.newsquarter.presenter.GetNearVideosPresenter;
import com.lenovo.bount.newsquarter.view.GetNearVideosView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/1.
 */

public class FujingFragment extends Fragment implements GetNearVideosView,LocationSource,AMapLocationListener {
    private MapView mMapView;  //初始化地图控制器对象
    AMap aMap;
    //定位需要的数据
    LocationSource.OnLocationChangedListener mListener;
    AMapLocationClient mlocationClient;
    AMapLocationClientOption mLocationOption;
    //定位蓝点
    MyLocationStyle myLocationStyle;
    private int jingdu;
    private int weidu;
    private XRecyclerView near_rv;
    private int page=1;
    private GetNearVideosPresenter  nearpresenter;
    private GetNearAdapter adapter;
    private List<GetNearVideoBean.DataBean> list;
    private StaggeredGridLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.near_layout,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        initMap();
        nearpresenter=new GetNearVideosPresenter(this);
        nearpresenter.GetNearVideos(1,weidu+"",jingdu+"");
    }
    private void initView() {
        list = new ArrayList<>();
        near_rv= getView().findViewById(R.id.near_rv);
        manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        near_rv.setLayoutManager(manager);
        near_rv.setRefreshProgressStyle(15);
        near_rv.setLoadingMoreProgressStyle(10);
        near_rv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
                nearpresenter.GetNearVideos(1,weidu+"",jingdu+"");
            }
            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "上拉加载", Toast.LENGTH_SHORT).show();
                page++;
                nearpresenter.GetNearVideos(page,weidu+"",jingdu+"");
            }
        });
    }

    @Override
    public void GetNearSuccess(GetNearVideoBean value) {
        List<GetNearVideoBean.DataBean> data = value.data;
        Toast.makeText(getActivity(), value.msg, Toast.LENGTH_SHORT).show();
        if(adapter==null)
        {
            adapter = new GetNearAdapter(getActivity(),list);
            near_rv.setAdapter(adapter);
        }
        if(page==1)
        {
            adapter.refreshData(data);
            near_rv.refreshComplete();
        } else
        {
            adapter.loadData(data);
            near_rv.loadMoreComplete();
        }

    }

    @Override
    public void GetNearError(String msg) {
        Toast.makeText(getActivity(),msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void GetNearOnFair(String msg) {
        Toast.makeText(getActivity(),msg, Toast.LENGTH_SHORT).show();
    }

    private void initMap() {
        mMapView = new MapView(getActivity());
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        //设置地图的放缩级别
        aMap.moveCamera(CameraUpdateFactory.zoomTo(12));
        // 设置定位监听
        aMap.setLocationSource(this);
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setMyLocationEnabled(true);
        // 设置定位的类型为定位模式，有定位、跟随或地图根据面向方向旋转几种
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);

        //蓝点初始化
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.getUiSettings().setMyLocationButtonEnabled(true);//设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）默认执行此种模式。
        myLocationStyle.showMyLocation(true);
        aMap.setOnMyLocationChangeListener(new AMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                //从location对象中获取经纬度信息，地址描述信息，建议拿到位置之后调用逆地理编码接口获取
                double latitude = location.getLatitude();
                weidu = (int) latitude;
                double longitude = location.getLongitude();
                jingdu = (int) longitude;
                System.out.println("经度======= " + jingdu +"纬度============"+ weidu);
            }
        });
    }
    //--定位监听---------
    //定位回调  在回调方法中调用“mListener.onLocationChanged(amapLocation);”可以在地图上显示系统小蓝点
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (mListener != null && aMapLocation != null) {
            if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(aMapLocation);// 显示系统小蓝点


            } else {
                String errText = "定位失败," + aMapLocation.getErrorCode() + ": " + aMapLocation.getErrorInfo();
                Log.e("定位AmapErr", errText);
            }
        }
    }

    /**
     * 激活定位
     */
    @Override
    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mlocationClient == null) {
            //初始化定位
            mlocationClient = new AMapLocationClient(getActivity());
            //初始化定位参数
            mLocationOption = new AMapLocationClientOption();
            //设置定位回调监听
            mlocationClient.setLocationListener(this);

            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();//启动定位
        }
    }

    /**
     * 停止定位
     */

    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;

    }

}
