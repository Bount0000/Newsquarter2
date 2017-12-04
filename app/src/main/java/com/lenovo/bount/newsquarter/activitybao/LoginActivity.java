package com.lenovo.bount.newsquarter.activitybao;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.GaodeMapActivity;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;

import java.util.List;

public class LoginActivity extends BaseActivity {

    private TextView other_way;
    private ImageView iv_map;

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
        iv_map.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
     switch (view.getId())
     {
         case R.id.other_way:
             startActivity(Login2Activity.class);
             finish();
             break;
         case R.id.iv_map:
             startActivity(GaodeMapActivity.class);
             finish();
             break;
     }
    }

    @Override
    public void initView() {
        setshowActionBar(false);
        other_way = (TextView) findViewById(R.id.other_way);
        iv_map = findViewById(R.id.iv_map);
    }

    @Override
    public void initDate() {

    }

}
