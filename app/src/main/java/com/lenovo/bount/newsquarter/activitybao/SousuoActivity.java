package com.lenovo.bount.newsquarter.activitybao;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.SousuoAdapter;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.SearchBean;
import com.lenovo.bount.newsquarter.presenter.SearchFriendsPresenter;
import com.lenovo.bount.newsquarter.view.SearchFriendsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SousuoActivity extends BaseActivity implements SearchFriendsView{

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.rt_1)
    RelativeLayout rt1;
    @BindView(R.id.soussuo)
    ImageView soussuo;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.rt_2)
    RelativeLayout rt2;
    @BindView(R.id.sousuo_xrv)
    XRecyclerView sousuoXrv;
    private int page=1;
    private SearchFriendsPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_sousuo;
    }

    @Override
    public void setLister() {
        soussuo.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
        switch (view.getId())
        {
            case R.id.soussuo:
            presenter.getSearch(etContent.getText().toString(),page);
                break;
        }
    }
    @Override
    public void initView() {
        setshowActionBar(false);
        ButterKnife.bind(this);
    }

    @Override
    public void initDate() {
        presenter = new SearchFriendsPresenter(this);
       ;
      }
    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> list=new ArrayList<>();
        list.add(presenter);
        return list;
    }

    @Override
    public void SearchSuccess(SearchBean value) {
        List<SearchBean.DataBean> data = value.data;
        showToast(value.msg);
        SousuoAdapter adapter=new SousuoAdapter(this,data);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        sousuoXrv.setLayoutManager(manager);
        sousuoXrv.setAdapter(adapter);
    }
    @Override
    public void SearchError(String msg) {
        showToast(msg);
    }

    @Override
    public void SearchonFair(String msg) {
        showToast(msg);

    }
}
