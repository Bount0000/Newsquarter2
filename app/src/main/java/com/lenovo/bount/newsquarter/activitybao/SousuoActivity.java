package com.lenovo.bount.newsquarter.activitybao;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.RandomSousuoAdapter;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.RandomFriendsBean;
import com.lenovo.bount.newsquarter.bean.SearchBean;
import com.lenovo.bount.newsquarter.presenter.RandomFavoritePresenter;
import com.lenovo.bount.newsquarter.presenter.SearchFriendsPresenter;
import com.lenovo.bount.newsquarter.view.RandomFavoriteView;
import com.lenovo.bount.newsquarter.view.SearchFriendsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class SousuoActivity extends BaseActivity implements SearchFriendsView, RandomFavoriteView {

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
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.randomsousuo_xrv)
    XRecyclerView randomsousuoXrv;
    private int page = 1;
    private SearchFriendsPresenter presenter;
    private RandomFavoritePresenter randomFavoritePresenter;

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
        switch (view.getId()) {
            case R.id.search_view:
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
        randomFavoritePresenter = new RandomFavoritePresenter(this);
        randomFavoritePresenter.getRandomFavorite();
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                presenter.getSearch(string, page);
            }
        });
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
    }

    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> list = new ArrayList<>();
        list.add(presenter);
        list.add(randomFavoritePresenter);
        return list;
    }

    @Override
    public void SearchSuccess(SearchBean value) {
        List<SearchBean.DataBean> data = value.data;
        showToast(value.msg);
       /* SousuoAdapter adapter = new SousuoAdapter(this, data);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        sousuoXrv.setLayoutManager(manager);
        sousuoXrv.setAdapter(adapter);*/
    }

    @Override
    public void SearchError(String msg) {
        showToast(msg);
    }

    @Override
    public void SearchonFair(String msg) {
        showToast(msg);

    }

    @Override
    public void RandomFavoriteSucces(RandomFriendsBean bean) {
        showToast(bean.msg);
        List<RandomFriendsBean.DataBean> data = bean.data;
        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        RandomSousuoAdapter adapter2 = new RandomSousuoAdapter(this, data);
        randomsousuoXrv.setLayoutManager(manager2);
        randomsousuoXrv.setAdapter(adapter2);
    }

    @Override
    public void RandomFavoriteError(String msg) {
        showToast(msg);
    }

    @Override
    public void RandomFavoriteOnFair(String msg) {
        showToast(msg);
    }

}
