package com.lenovo.bount.newsquarter.activitybao;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;

import java.util.List;

public class ShipinActivity extends BaseActivity {

    private ImageView iv_start;
    private ImageView iv_tu;

    @Override
    public int bindLayout() {
        return R.layout.activity_shipin;
    }

    @Override
    public void setLister() {
        iv_start.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {

    }

    @Override
    public void initView() {
        iv_start = findViewById(R.id.iv_start);
        iv_tu=findViewById(R.id.iv_tu);
    }

    @Override
    public void initDate() {
        Glide.with(this).load(R.drawable.dongtu).asGif().into(iv_tu);
    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

}
