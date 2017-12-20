package com.lenovo.bount.newsquarter.activitybao;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.lenovo.bount.newsquarter.App;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.fragment.DuanziFragment;
import com.lenovo.bount.newsquarter.fragment.FindFragment;
import com.lenovo.bount.newsquarter.fragment.LeftFragment;
import com.lenovo.bount.newsquarter.fragment.ShipinFragment;
import com.lenovo.bount.newsquarter.fragment.TuijianFragment;
import com.lenovo.bount.newsquarter.utils.SpUtils;

import java.util.List;

public class MainActivity extends BaseActivity {


    private LinearLayout lt1;
    private LinearLayout lt2;
    private LinearLayout lt3;
    private ImageView iv_1;
    private ImageView iv_2;
    private ImageView iv_3;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private ImageView iv_touxiang;
    private DrawerLayout drawer;
    private DrawerLayout drawer1;
    private ImageView iv_bianji;
    private TextView tv_title;
    private TuijianFragment tuijianFragmet;
    private DuanziFragment duanziFragment;
    private ShipinFragment shipinFragment;
    private android.support.v4.app.Fragment cuttrentFragment;
    private LeftFragment leftFragment;
    private FindFragment findFragment;
    private LinearLayout lt4;
    private ImageView iv_4;
    private TextView tv_4;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setLister() {
        lt1.setOnClickListener(this);
        lt2.setOnClickListener(this);
        lt3.setOnClickListener(this);
        lt4.setOnClickListener(this);
        iv_touxiang.setOnClickListener(this);
        iv_bianji.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.lt1:
                switchFragment(tuijianFragmet);
                //getSupportFragmentManager().beginTransaction().replace(R.id.fl,new TuijianFragment()).commit();
                iv_1.setImageResource(R.mipmap.one1);
                iv_2.setImageResource(R.mipmap.two);
                iv_3.setImageResource(R.mipmap.thress);
                iv_4.setImageResource(R.mipmap.find);
                tv_1.setTextColor(Color.BLUE);
                tv_2.setTextColor(Color.BLACK);
                tv_3.setTextColor(Color.BLACK);
                tv_4.setTextColor(Color.BLACK);
                break;
            case R.id.lt2:
                switchFragment(duanziFragment);
                // getSupportFragmentManager().beginTransaction().replace(R.id.fl,new DuanziFragment()).commit();
                tv_title.setText("段子");
                iv_1.setImageResource(R.mipmap.one);
                iv_2.setImageResource(R.mipmap.two2);
                iv_3.setImageResource(R.mipmap.thress);
                iv_4.setImageResource(R.mipmap.find);
                tv_2.setTextColor(Color.BLUE);
                tv_1.setTextColor(Color.BLACK);
                tv_3.setTextColor(Color.BLACK);
                tv_4.setTextColor(Color.BLACK);
                break;
            case R.id.lt3:
                switchFragment(shipinFragment);
                //getSupportFragmentManager().beginTransaction().replace(R.id.fl,new ShipinFragment()).commit();
                tv_title.setText("视频");
                iv_1.setImageResource(R.mipmap.one);
                iv_2.setImageResource(R.mipmap.two);
                iv_3.setImageResource(R.mipmap.thress2);
                iv_4.setImageResource(R.mipmap.find);
                tv_3.setTextColor(Color.BLUE);
                tv_1.setTextColor(Color.BLACK);
                tv_2.setTextColor(Color.BLACK);
                tv_4.setTextColor(Color.BLACK);
                break;
            case R.id.lt4:
                switchFragment(findFragment);
                //getSupportFragmentManager().beginTransaction().replace(R.id.fl,new ShipinFragment()).commit();
                tv_title.setText("发现");
                iv_1.setImageResource(R.mipmap.one);
                iv_2.setImageResource(R.mipmap.two);
                iv_3.setImageResource(R.mipmap.thress);
                iv_4.setImageResource(R.mipmap.find2);

                tv_1.setTextColor(Color.BLACK);
                tv_2.setTextColor(Color.BLACK);
                tv_3.setTextColor(Color.BLACK);
                tv_4.setTextColor(Color.BLUE);

            break;
            case R.id.iv_touxiang:
                drawer.openDrawer(Gravity.LEFT);

                break;
            case R.id.iv_bianji:
                startActivity(new Intent(this, BianjiActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void initView() {

        lt1 = findViewById(R.id.lt1);
        lt2 = findViewById(R.id.lt2);
        lt3 = findViewById(R.id.lt3);
        lt4 = findViewById(R.id.lt4);
        iv_1 = findViewById(R.id.iv_icon);
        iv_2 = findViewById(R.id.iv_2);
        iv_3 = findViewById(R.id.iv_3);
        iv_4 = findViewById(R.id.iv_4);

        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);
        tv_4 = findViewById(R.id.tv_4);
        drawer = findViewById(R.id.drawer);
        iv_touxiang = findViewById(R.id.iv_touxiang);
        iv_bianji = findViewById(R.id.iv_bianji);
        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("推荐");
        getSupportFragmentManager().beginTransaction().replace(R.id.left_fl,new LeftFragment()).commit();
    }

    @Override
    public void initDate() {
        setStatus(false);
        setshowActionBar(false);
        tuijianFragmet = new TuijianFragment();
        duanziFragment = new DuanziFragment();
        shipinFragment = new ShipinFragment();
        leftFragment = new LeftFragment();
        findFragment = new FindFragment();
        cuttrentFragment = tuijianFragmet;
        getSupportFragmentManager().beginTransaction().add(R.id.fl, tuijianFragmet).commit();
        iv_1.setImageResource(R.mipmap.one1);
        tv_1.setTextColor(Color.BLACK);
        SpUtils utils = new SpUtils(this,"Chuan");
        String icon = utils.getString("icon", "");
        System.out.println("----icon-------" + icon);
        Glide.with(this).load(icon).asBitmap().centerCrop().into(new BitmapImageViewTarget(iv_touxiang) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(App.context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                iv_touxiang.setImageDrawable(circularBitmapDrawable);
            }
        });
        drawer.setScrimColor(Color.TRANSPARENT);
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                drawer.setScrimColor(Color.TRANSPARENT);
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    //Fragmen替换隐藏方法
    private void switchFragment(Fragment targetFragmnet) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!targetFragmnet.isAdded()) {
            transaction.hide(cuttrentFragment)
                    .add(R.id.fl, targetFragmnet)
                    .commit();
        } else {
            transaction.hide(cuttrentFragment)
                    .show(targetFragmnet)
                    .commit();
        }
        cuttrentFragment = targetFragmnet;

    }
}
