package com.lenovo.bount.newsquarter.activitybao;

import android.content.Intent;
import android.location.Location;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MyLocationStyle;
import com.bumptech.glide.Glide;
import com.lenovo.bount.newsquarter.GlideLoader;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.presenter.PbVedioPresenter;
import com.lenovo.bount.newsquarter.utils.SpUtils;
import com.lenovo.bount.newsquarter.view.PublishVedioView;
import com.yancy.imageselector.ImageConfig;
import com.yancy.imageselector.ImageSelector;
import com.yancy.imageselector.ImageSelectorActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PbVideoActivity extends BaseActivity implements LocationSource,AMapLocationListener,PublishVedioView {
    private MapView mMapView;  //初始化地图控制器对象
    AMap aMap;
    //定位需要的数据
    LocationSource.OnLocationChangedListener mListener;
    AMapLocationClient mlocationClient;
    AMapLocationClientOption mLocationOption;
    //定位蓝点
    MyLocationStyle myLocationStyle;
    public static final int REQUEST_CODE = 1000;
    private Button bt_cover;
    private int jingdu;
    private int weidu;
    private ArrayList<String> path;
    private PbVedioPresenter pbVedioPresenter;
    private Button bt_publish;
    private String coverlist;
    private ImageView iv_head;
    private File cover;

    @Override
    public int bindLayout() {
        return R.layout.activity_pb_video;
    }

    @Override
    public void setLister() {
        bt_cover.setOnClickListener(this);
        bt_publish.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
    switch (view.getId())
    {
        case R.id.bt_cover:
            ImageConfig imageConfig
                    = new ImageConfig.Builder(
                    // GlideLoader 可用自己用的缓存库
                    new GlideLoader())
                    // 如果在 4.4 以上，则修改状态栏颜色 （默认黑色）
                    .steepToolBarColor(getResources().getColor(R.color.green))
                    // 标题的背景颜色 （默认黑色）
                    .titleBgColor(getResources().getColor(R.color.green))
                    // 提交按钮字体的颜色  （默认白色）
                    .titleSubmitTextColor(getResources().getColor(R.color.white))
                    // 标题颜色 （默认白色）
                    .titleTextColor(getResources().getColor(R.color.white))
                    // 开启多选   （默认为多选）  (单选 为 singleSelect)
                    .singleSelect()
                    .crop()
                    // 多选时的最大数量   （默认 9 张）
                    .mutiSelectMaxSize(9)
                    // 已选择的图片路径
                    .pathList((ArrayList<String>) path)
                    // 拍照后存放的图片路径（默认 /temp/picture）
                    .filePath("/ImageSelector/Pictures")
                    // 开启拍照功能 （默认开启）
                    .showCamera()
                    .requestCode(REQUEST_CODE)
                    .build();
            ImageSelector.open(PbVideoActivity.this, imageConfig); // 开启图片选择器
            break;
        case R.id.bt_publish:
            Intent intent = getIntent();
            String videourl = intent.getStringExtra("videourl");
            File file=new File(videourl);
            SpUtils util=new SpUtils(this,"Login");
            String uid = util.getString("uid", "");
            System.out.println("======uid========"+uid);
            System.out.println("======file========"+file);
            System.out.println("======cover========"+cover);
            System.out.println("======file========"+weidu);
            System.out.println("======file========"+jingdu);
            pbVedioPresenter.getpbvedio(uid,file,cover,"发布视频",weidu+"",jingdu+"");
            break;
        }
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);
            for (int i = 0; i <pathList.size() ; i++) {
                coverlist = pathList.get(i);
                Glide.with(this).load(coverlist).into(iv_head);
                cover = new File(coverlist);
            }
            path.clear();
            path.addAll(pathList);
        }
    }
    @Override
    public void initView() {
         setshowActionBar(false);
        bt_cover = findViewById(R.id.bt_cover);
        bt_publish = findViewById(R.id.bt_publish);
        iv_head = findViewById(R.id.iv_head);
    }

    @Override
    public void initDate() {
        initMap();
        pbVedioPresenter = new PbVedioPresenter(this);
        path = new ArrayList<>();

    }

    private void initMap() {
        mMapView = new MapView(this);
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
    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> presenters=new ArrayList<>();
        presenters.add(pbVedioPresenter);
        return presenters;
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
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mlocationClient == null) {
            //初始化定位
            mlocationClient = new AMapLocationClient(this);
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

    @Override
    public void Success(ResponsBodyBean bodyBean) {
    showToast(bodyBean.msg);
    }

    @Override
    public void Error(String msg) {
        showToast(msg);
    }

    @Override
    public void onFair(String msg) {
        showToast(msg);
    }
}
