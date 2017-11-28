package com.lenovo.bount.newsquarter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.DuanziAdapter;
import com.lenovo.bount.newsquarter.bean.GetJokeBean;
import com.lenovo.bount.newsquarter.presenter.GetJokePresenter;
import com.lenovo.bount.newsquarter.view.GetJokeView;

import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class DuanziFragment extends Fragment implements GetJokeView,View.OnClickListener{

    private View view;
    private RecyclerView rv;
    private ImageView iv_bianji;

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
        GetJokePresenter presenter=new GetJokePresenter(this);
        presenter.getjoke("1");

    }

    private void initView() {
        rv = getView().findViewById(R.id.rv);
        View view=View.inflate(getContext(),R.layout.title_layout,null);
        iv_bianji = view.findViewById(R.id.iv_bianji);
        iv_bianji.setOnClickListener(this);
    }

    @Override
    public void Success(GetJokeBean value) {
        Toast.makeText(getContext(), value.msg,Toast.LENGTH_SHORT).show();
        List<GetJokeBean.DataBean> data = value.data;
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        DuanziAdapter adapter=new DuanziAdapter(getContext(),data);
        rv.setAdapter(adapter);
    }

    @Override
    public void Error() {

    }

    @Override
    public void onFair(Throwable e) {

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
