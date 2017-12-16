package com.lenovo.bount.newsquarter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.SpRemenAdapter;
import com.lenovo.bount.newsquarter.bean.RmSpBean;
import com.lenovo.bount.newsquarter.presenter.GetRmVideoPresenter;
import com.lenovo.bount.newsquarter.view.GetRmVideoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/1.
 */

public class SpRemenFragment extends Fragment implements GetRmVideoView {

    private XRecyclerView recyclerView;
    private int page=1;
    private List<RmSpBean.DataBean> data;
    private List<RmSpBean.DataBean> list;
    private SpRemenAdapter adapter;
    private GetRmVideoPresenter getRmVideoPresenter;
    private StaggeredGridLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.spremen_layout,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        getRmVideoPresenter = new GetRmVideoPresenter(this);
        getRmVideoPresenter.getRmsp(1);


   /*  //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(2);
        recyclerView.addItemDecoration(decoration);*/
    }
    private void initView() {
        recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setLoadingMoreEnabled(true);
        recyclerView.setPullRefreshEnabled(true);


    }

    @Override
    public void RmSpSuccess(RmSpBean rmSpBean) {
        if(getActivity()!=null)
        {
            Toast.makeText(getActivity(), rmSpBean.msg, Toast.LENGTH_SHORT).show();
        }
        data = rmSpBean.data;
        list.addAll(data);
        if(adapter==null)
        {
            adapter = new SpRemenAdapter(getContext(),list);
            manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            //顶部错位解决
            manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
            //防止第一行有白处
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    manager.invalidateSpanAssignments();
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                }
            });
             recyclerView.setLayoutManager(manager);
             recyclerView.setAdapter(adapter);
        }
        else
        {
            adapter.notifyDataSetChanged();
        }
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener(){
             @Override
            public void onRefresh() {
                list.clear();
                Toast.makeText(getContext(), "下拉刷新", Toast.LENGTH_SHORT).show();
                getRmVideoPresenter.getRmsp(1);
                recyclerView.refreshComplete();
            }
            @Override
            public void onLoadMore() {
                Toast.makeText(getContext(), "上拉加载", Toast.LENGTH_SHORT).show();
                page++;
                getRmVideoPresenter.getRmsp(page);
                recyclerView.loadMoreComplete();
            }
         });
         }

    @Override
    public void RmSpError(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RmSpOnFair(String msg) {
        Toast.makeText(getActivity(),msg, Toast.LENGTH_SHORT).show();
    }
}
