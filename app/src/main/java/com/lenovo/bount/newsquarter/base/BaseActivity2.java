package com.lenovo.bount.newsquarter.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lenovo on 2017/11/13.
 */

public abstract class BaseActivity2<P extends BasePresenter> extends AppCompatActivity {
   public P presenter;
   public abstract P  initPresenter();
   public abstract int getLayout();
   public BaseActivity2(P presenter)
   {
       this.presenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        presenter=initPresenter();
        setContentView(getLayout());
        initView();
    }
    public abstract void initView();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deacth();
    }
}
