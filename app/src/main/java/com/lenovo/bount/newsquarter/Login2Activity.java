package com.lenovo.bount.newsquarter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;

import java.util.List;

public class Login2Activity extends BaseActivity {


    private TextView tv_zhuce;
    private TextView but_log;


    @Override
    public int bindLayout() {
        return R.layout.activity_login2;
    }

    @Override
    public void setLister() {
        tv_zhuce.setOnClickListener(this);
        but_log.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
        switch (view.getId())
        {
            case R.id.tv_zhuce:
                startActivity(new Intent(Login2Activity.this,RegisterActivity.class));
                break;
            case R.id.but_log:
                startActivity(new Intent(Login2Activity.this,MainActivity.class));
                break;
         }
         }
    @Override
    public void initView() {
        tv_zhuce = findViewById(R.id.tv_zhuce);
        but_log = findViewById(R.id.but_log);
    }

    @Override
    public void initDate() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }
}
