package com.lenovo.bount.newsquarter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.base.BaseActivity;

public class Login2Activity extends BaseActivity {


    private TextView tv_zhuce;
    private TextView but_log;

    /*public Login2Activity(BasePresenter presenter) {
        super(presenter);
    }
    @Override
    public BasePresenter initPresenter() {
        return null;
    }
*/
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
}
