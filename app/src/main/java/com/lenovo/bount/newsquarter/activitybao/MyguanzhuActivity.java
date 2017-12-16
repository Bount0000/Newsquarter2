package com.lenovo.bount.newsquarter.activitybao;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.MyGuanzhuAdapter;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.GetFollowUsersBean;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;
import com.lenovo.bount.newsquarter.presenter.FollowUsersPresenter;
import com.lenovo.bount.newsquarter.view.GetFollowUsersView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyguanzhuActivity extends BaseActivity implements GetFollowUsersView{

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.rt_1)
    RelativeLayout rt1;
    @BindView(R.id.rv_guanzhu)
    RecyclerView rvGuanzhu;
    private List<BasePresenter> presenterList;
    private FollowUsersPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_myguanzhu;
    }

    @Override
    public void setLister() {

    }

    @Override
    public void Click(View view) {

    }

    @Override
    public void initView() {
        setshowActionBar(false);
        ButterKnife.bind(this);
    }

    @Override
    public void initDate() {
        presenter = new FollowUsersPresenter(this);
        presenter.getFollowUser(MyInterceptor.uid);
    }

    @Override
    public List<BasePresenter> initPresenter() {
        presenterList = new ArrayList<>();
        presenterList.add(presenter);
        return presenterList;
    }

    @Override
    public void FollowSucces(GetFollowUsersBean getFollowUsersBean) {
        showToast(getFollowUsersBean.msg);
        List<GetFollowUsersBean.DataBean> data = getFollowUsersBean.data;
        LinearLayoutManager manager=new LinearLayoutManager(this);
        MyGuanzhuAdapter adapter=new MyGuanzhuAdapter(this,data);
        rvGuanzhu.setLayoutManager(manager);
        rvGuanzhu.setAdapter(adapter);

    }
    @Override
    public void FollowError(String msg) {
        showToast(msg);
    }

    @Override
    public void FollowOnFrair(String msg) {
        showToast(msg);
    }
}
