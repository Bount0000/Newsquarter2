package com.lenovo.bount.newsquarter;

import android.view.View;
import android.widget.LinearLayout;

import com.lenovo.bount.newsquarter.base.BaseActivity;

public class RegisterActivity extends BaseActivity {


    private LinearLayout rl;
/*
    public RegisterActivity(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }*/

    @Override
    public int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void setLister() {

    }

    @Override
    public void Click(View view) {

    }

    @Override
    public void initView() {
        rl = findViewById(R.id.rl_background);
        rl.getBackground().setAlpha(80);
    }

    @Override
    public void initDate() {

    }
}
