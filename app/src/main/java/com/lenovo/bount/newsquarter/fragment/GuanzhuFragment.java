package com.lenovo.bount.newsquarter.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.bean.Rebean;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/25.
 */

public class GuanzhuFragment extends Fragment implements XBanner.XBannerAdapter {

    private ViewPager remen_vp;
    private XBanner banner_1;
    private List<Integer> imgesUrl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(),R.layout.guanzhu_layout,null);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        imgesUrl = new ArrayList<>();
        imgesUrl.add(R.mipmap.raw_1);
        imgesUrl.add(R.mipmap.raw_2);
        imgesUrl.add(R.mipmap.raw_3);
        imgesUrl.add(R.mipmap.raw_4);
        banner_1.setData(imgesUrl,null);
        banner_1.setmAdapter(GuanzhuFragment.this);
        // 设置XBanner页面切换的时间，即动画时长
        banner_1.setPageChangeDuration(1000);
        List<Rebean> list=new ArrayList<>();
    }
    private void initView() {
        banner_1 = getView().findViewById(R.id.banner_1);
        RecyclerView rv = getView().findViewById(R.id.rv);
    }

    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(this).load(imgesUrl.get(position)).into((ImageView) view);
    }
    @Override
    public void onResume() {
        super.onResume();
        banner_1.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner_1.stopAutoPlay();
    }

}
