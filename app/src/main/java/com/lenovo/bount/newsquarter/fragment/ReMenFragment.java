package com.lenovo.bount.newsquarter.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.GetVideoAdapter;
import com.lenovo.bount.newsquarter.bean.GetVideoBean;
import com.lenovo.bount.newsquarter.bean.GetVideos;
import com.lenovo.bount.newsquarter.bean.Guangao;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;
import com.lenovo.bount.newsquarter.presenter.GetVideosPresenter;
import com.lenovo.bount.newsquarter.presenter.GetadpPresenter;
import com.lenovo.bount.newsquarter.view.GetVideosView;
import com.lenovo.bount.newsquarter.view.GetadView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/25.
 */

public class ReMenFragment extends Fragment implements XBanner.XBannerAdapter,GetadView,GetVideosView {

    private ViewPager remen_vp;
    private XBanner banner_1;
    private List<String> imgesUrl;
    private String icon;
    private XRecyclerView xrecycleview;
    private GetVideosPresenter getVideosPresenter;
    private GetVideoAdapter adapter;
    private int page=1;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(),R.layout.guanzhu_layout,null);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         initView();
         initData();
    }

    private void initData() {
        GetadpPresenter presenter=new GetadpPresenter(this);
        presenter.getAd();
        getVideosPresenter = new GetVideosPresenter(this);
        getVideosPresenter.getvideo(MyInterceptor.uid,"1",page);
    }

    private void initView() {
        View view=View.inflate(getContext(),R.layout.xbanner_layout,null);
        banner_1 = view.findViewById(R.id.banner_1);
        xrecycleview = getView().findViewById(R.id.xrecycleview);
        xrecycleview.addHeaderView(view);
        //xrecycleview.setPullRefreshEnabled(true);
        //xrecycleview.setLoadingMoreEnabled(true);

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
    public void onStop(){
        super.onStop();
        banner_1.stopAutoPlay();
    }

    @Override
    public void Success(Guangao value) {
        imgesUrl = new ArrayList<>();
        List<Guangao.DataBean> list = value.data;
        for (int i = 0; i <list.size(); i++) {
            Guangao.DataBean dataBean = list.get(i);
            icon = dataBean.icon;
            imgesUrl.add(icon);
        }
        banner_1.setData(imgesUrl,null);
        banner_1.setmAdapter(ReMenFragment.this);
        // 设置XBanner页面切换的时间，即动画时长
        banner_1.setPageChangeDuration(1000);
    }

    @Override
    public void Error(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void OnFair(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void GetVideoSuccess(GetVideos value) {
        List<GetVideoBean>  getVideolist=new ArrayList();
        final List<GetVideoBean> list=new ArrayList<>();
        list.addAll(getVideolist);
        Toast.makeText(getContext(), value.msg, Toast.LENGTH_SHORT).show();
        List<GetVideos.DataBean> data = value.data;
        for (int i = 0; i <data.size() ; i++) {
            GetVideos.DataBean dataBean = data.get(i);
            String createTime = dataBean.createTime;
            String icon = dataBean.user.icon;
            String nickname = (String) dataBean.user.nickname;
            String cover = dataBean.cover;
            String videoUrl = dataBean.videoUrl;
            getVideolist.add(new GetVideoBean(createTime,icon,nickname,cover,videoUrl));
        }

        System.out.println("======获取======"+getVideolist.size());

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        xrecycleview.setLayoutManager(layoutManager);
        adapter = new GetVideoAdapter(getContext(),getVideolist);
        xrecycleview.setAdapter(adapter);
/*
         if(adapter==null)
         {
             adapter = new GetVideoAdapter(getContext(),list);
             xrecycleview.setAdapter(adapter);
         }
         else
         {
             adapter.notifyDataSetChanged();
         }*/
       /* xrecycleview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "上拉加载", Toast.LENGTH_SHORT).show();
              list.clear();
              getVideosPresenter.getvideo(MyInterceptor.uid,"1",page);
              xrecycleview.refreshComplete();
            }
            @Override
            public void onLoadMore() {
                Toast.makeText(getContext(), "下拉刷新", Toast.LENGTH_SHORT).show();
                page++;
                getVideosPresenter.getvideo(MyInterceptor.uid,"1",page);
                xrecycleview.loadMoreComplete();
            }
        });*/
    }
    @Override
    public void GetVideoError(String msg) {
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void GetVideoOnFair(Throwable e) {
        Toast.makeText(getContext(),e.toString(), Toast.LENGTH_SHORT).show();
    }
}
