package com.lenovo.bount.newsquarter.activitybao;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;

import java.util.List;

public class GuanzhuActivity extends BaseActivity {


    private ImageView iv_gutx;

    @Override
    public int bindLayout() {
        return R.layout.activity_guanzhu;
    }

    @Override
    public void setLister() {

    }

    @Override
    public void Click(View view) {

    }

    @Override
    public void initView() {
        iv_gutx = findViewById(R.id.iv_gutx);
        iv_gutx.setImageURI(Uri.parse("http://img2.imgtn.bdimg.com/it/u=3835035961,1164635843&fm=27&gp=0.jpg"));
    }

    @Override
    public void initDate() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }
}
