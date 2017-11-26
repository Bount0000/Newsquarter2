package com.lenovo.bount.newsquarter;

import android.content.Intent;
import android.view.View;

import com.lenovo.bount.newsquarter.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Qidong2Activity extends BaseActivity {

/*    public Qidong2Activity(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }*/

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

    }

    @Override
    public void initDate() {
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {

                startActivity(new Intent(Qidong2Activity.this,LoginActivity.class));
              /*  Intent intent=new Intent(Qidong2Activity.this,MainActivity.class);
                startActivity(intent);*/
            }
        };
        timer.schedule(timerTask,3000);
    }

    }

