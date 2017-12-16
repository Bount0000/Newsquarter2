package com.lenovo.bount.newsquarter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.GetWorkInfoAdapter;
import com.lenovo.bount.newsquarter.bean.GetWorkInfoBean;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;
import com.lenovo.bount.newsquarter.presenter.GetWorkInfoPresenter;
import com.lenovo.bount.newsquarter.view.GetWorkInfoView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2017/12/15.
 */

public class BendiFragment extends Fragment implements GetWorkInfoView{
    @BindView(R.id.rv_my)
    RecyclerView rvMy;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = View.inflate(getContext(), R.layout.getworkinfo_layout, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iniView();
        initData();
    }

    private void initData(){
        GetWorkInfoPresenter presenter=new GetWorkInfoPresenter(this);
        presenter.getGetWorkInfo(MyInterceptor.uid);
    }

    private void iniView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void Success(GetWorkInfoBean bean) {
        Toast.makeText(getActivity(), bean.msg, Toast.LENGTH_SHORT).show();
        List<GetWorkInfoBean.DataBean.WorksEntitiesBean> worksEntities = bean.data.worksEntities;
        GridLayoutManager manager=new GridLayoutManager(getActivity(),3);
        rvMy.setLayoutManager(manager);
        GetWorkInfoAdapter adapter=new GetWorkInfoAdapter(getActivity(),worksEntities);
        rvMy.setAdapter(adapter);
    }

    @Override
    public void Error(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnFair(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
