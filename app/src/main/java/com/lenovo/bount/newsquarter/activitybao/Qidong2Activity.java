package com.lenovo.bount.newsquarter.activitybao;

import android.content.Intent;
import android.view.View;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Qidong2Activity extends BaseActivity {


    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }
    @Override
    public int bindLayout() {
        return R.layout.activity_qidong2;
    }

    @Override
    public void setLister() {

    }

    @Override
    public void Click(View view) {

    }

    @Override
    public void initView() {
        setshowActionBar(false);
    }

    @Override
    public void initDate() {
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {

                startActivity(new Intent(Qidong2Activity.this,LoginActivity.class));
                 finish();
              /*  Intent intent=new Intent(Qidong2Activity.this,MainActivity.class);
                startActivity(intent);*/
            }
        };
        timer.schedule(timerTask,3000);
    }

    }

