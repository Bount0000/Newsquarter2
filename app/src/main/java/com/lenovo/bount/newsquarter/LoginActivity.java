package com.lenovo.bount.newsquarter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;

import java.util.List;

public class LoginActivity extends BaseActivity {

    private TextView other_way;
    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setLister() {
        other_way.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
     switch (view.getId())
     {
         case R.id.other_way:
             startActivity(new Intent(LoginActivity.this,Login2Activity.class));
             break;
     }
    }

    @Override
    public void initView() {
        other_way = findViewById(R.id.other_way);
    }

    @Override
    public void initDate() {

    }

}
