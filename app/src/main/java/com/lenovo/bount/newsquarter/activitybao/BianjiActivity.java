package com.lenovo.bount.newsquarter.activitybao;

import android.view.View;
import android.widget.ImageView;

import com.lenovo.bount.newsquarter.R;
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
       startActivity(PublishJokeActivity.class);
       break;
       case R.id.iv_shiping:
           startActivity(ShipinActivity.class);
           break;
    }
    }
    @Override
    public void initView() {
        setshowActionBar(false);
        iv_shiping =findViewById(R.id.iv_shiping);
        iv_duanzi =findViewById(R.id.iv_duanzi);
    }

    @Override
    public void initDate() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }
}
