package com.lenovo.bount.newsquarter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.DuanziAdapter;
import com.lenovo.bount.newsquarter.bean.GetJokeBean;
import com.lenovo.bount.newsquarter.presenter.GetJokePresenter;
import com.lenovo.bount.newsquarter.view.GetJokeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class DuanziFragment extends Fragment implements GetJokeView,View.OnClickListener {

    private View view;
    private XRecyclerView rv;
    private ImageView iv_bianji;
    private DuanziAdapter adapter;
    public int page=1;
    private List<GetJokeBean.DataBean> list;
    private GetJokePresenter presenter;
    private TextView textview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = View.inflate(getContext(), R.layout.duanzi_frag,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         initView();
         initData();
    }

    private void initData() {
        list=new ArrayList<>();
        presenter = new GetJokePresenter(this);
        presenter.getjoke(page);
    }
    private void initView() {
        rv = getView().findViewById(R.id.rt_4);
        View view=View.inflate(getContext(),R.layout.title_layout,null);
        iv_bianji = view.findViewById(R.id.iv_bianji);
        iv_bianji.setOnClickListener(this);
        rv.setPullRefreshEnabled(true);
        rv.setLoadingMoreEnabled(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public void Success(GetJokeBean value) {
        if(getView()!=null)
        {
            Toast.makeText(getContext(),value.msg,Toast.LENGTH_SHORT).show();
        }
        list.addAll(value.data);
        if(adapter==null)
        {
            adapter = new DuanziAdapter(getContext(),list);
            rv.setAdapter(adapter);
        }
        else
        {
          adapter.notifyDataSetChanged();
        }

        rv.setLoadingListener(new XRecyclerView.LoadingListener(){
            @Override
            public void onRefresh() {
                list.clear();
                Toast.makeText(getContext(), "下拉刷新", Toast.LENGTH_SHORT).show();
                presenter.getjoke(1);
                rv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getContext(), "上拉加载", Toast.LENGTH_SHORT).show();
                page++;
                presenter.getjoke(page);
                rv.loadMoreComplete();
            }
        });
    }

    @Override
    public void Error(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFair(Throwable e) {
        Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
           case R.id.iv_bianji:
                break;
        }
    }
}

