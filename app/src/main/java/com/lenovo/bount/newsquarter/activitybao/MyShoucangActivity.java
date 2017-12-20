package com.lenovo.bount.newsquarter.activitybao;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.GetFavoritesAdapter;
import com.lenovo.bount.newsquarter.adapter.GetVideoAdapter;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.GetFavoritesBean;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;
import com.lenovo.bount.newsquarter.presenter.GetFavoritesPresenter;
import com.lenovo.bount.newsquarter.presenter.RemoveFavoritePresenter;
import com.lenovo.bount.newsquarter.view.GetFavoritesView;
import com.lenovo.bount.newsquarter.view.RemoveFavoriteView;

import java.util.ArrayList;
import java.util.List;

public class MyShoucangActivity extends BaseActivity implements GetFavoritesView,GetFavoritesAdapter.CheckBoxInterface,RemoveFavoriteView{

    private XRecyclerView xrv_sc;
    private GetFavoritesPresenter presenter;
    private TextView tv_delete;
    private GetFavoritesAdapter.CheckBoxInterface checkBoxInterface;
    private CheckBox cb1;
    private GetFavoritesAdapter adapter;
    private RemoveFavoritePresenter removeFavoritePresenter;
    private Button btn_delete;

    @Override
    public int bindLayout() {
        return R.layout.activity_my_shoucang;
    }

    @Override
    public void setLister() {
        tv_delete.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
        switch (view.getId())
        {
            case R.id.tv_delete:
                cb1.setVisibility(View.VISIBLE);
                btn_delete.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_delete:
                removeFavoritePresenter.RomoveFavorite(MyInterceptor.uid, GetVideoAdapter.wid+"");
                adapter.notifyDataSetChanged();
                break;
          }
          }

    @Override
    public void initView(){
        setshowActionBar(false);
        xrv_sc = findViewById(R.id.xrv_sc);
        tv_delete = findViewById(R.id.tv_delete);
        btn_delete = findViewById(R.id.btn_delete);
    }

    @Override
    public void initDate() {
        presenter = new GetFavoritesPresenter(this);
        presenter.GetFavorites(MyInterceptor.uid);
        removeFavoritePresenter = new RemoveFavoritePresenter(this);
    }

    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> presentersList=new ArrayList<>();
        presentersList.add(presenter);
        presentersList.add(removeFavoritePresenter);
        return presentersList;
    }

    @Override
    public void GetFavoriteSucces(GetFavoritesBean bean) {
        showToast(bean.msg);
        List<GetFavoritesBean.DataBean> dataBeanList = bean.data;
        LinearLayoutManager manager=new LinearLayoutManager(this);
        adapter = new GetFavoritesAdapter(this,dataBeanList);
        xrv_sc.setAdapter(adapter);
        xrv_sc.setLayoutManager(manager);
        adapter.setCheckBoxInterface(this);
    }

    @Override
    public void GetFavoriteError(String msg) {
        showToast(msg);
    }

    @Override
    public void GetFavoriteOnFair(String msg) {
        showToast(msg);
    }


    @Override
    public void CheckBox(CheckBox cb) {
        cb1 = cb;
    }

    @Override
    public void RemoveFavoriteSucces(ResponsBodyBean bean) {
        Toast.makeText(this, bean.msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RemoveFavoriteError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RemoveFavoriteOnFair(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
