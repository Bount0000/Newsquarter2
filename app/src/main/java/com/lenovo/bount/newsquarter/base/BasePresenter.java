package com.lenovo.bount.newsquarter.base;

/**
 * Created by lenovo on 2017/11/13.
 */

public class BasePresenter<V> {

    private V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }
    public void deacth()
    {
        this.mView=null;
    }
}
