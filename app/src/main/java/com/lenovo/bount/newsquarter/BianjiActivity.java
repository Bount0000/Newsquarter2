package com.lenovo.bount.newsquarter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;

import java.util.List;

public class BianjiActivity extends BaseActivity {


    private ImageView iv_shiping;
    private ImageView iv_duanzi;

    @Override
    public int bindLayout() {
        return R.layout.activity_bianji;
    }

    @Override
    public void setLister() {
        iv_duanzi.setOnClickListener(this);
        iv_shiping.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
   switch (view.getId())
   {
       case R.id.iv_duanzi:
           startActivity(new Intent(this,PublishJokeActivity.class));
           break;
    }
    }

    @Override
    public void initView() {
        iv_shiping = findViewById(R.id.iv_shiping);
        iv_duanzi = findViewById(R.id.iv_duanzi);
    }

    @Override
    public void initDate() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }
}
