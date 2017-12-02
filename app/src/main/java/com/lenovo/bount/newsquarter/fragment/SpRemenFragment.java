package com.lenovo.bount.newsquarter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.SpRemenAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/1.
 */

public class SpRemenFragment extends Fragment {

    private RecyclerView recyclerView;

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
     List<Integer> pictuerlist=new ArrayList<>();
        pictuerlist.add(R.mipmap.p1);
        pictuerlist.add(R.mipmap.p2);
        pictuerlist.add(R.mipmap.p3);
        pictuerlist.add(R.mipmap.p4);
        pictuerlist.add(R.mipmap.p5);


        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        SpRemenAdapter adapter=new SpRemenAdapter(getContext(),pictuerlist);
        recyclerView.setAdapter(adapter);
   /*  //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(2);
        recyclerView.addItemDecoration(decoration);*/
    }
    private void initView() {
        recyclerView = getView().findViewById(R.id.recyclerView);
    }
}
