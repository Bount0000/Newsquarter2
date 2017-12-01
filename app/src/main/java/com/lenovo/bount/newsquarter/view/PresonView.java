package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.Userbean2;

/**
 * Created by lenovo on 2017/11/28.
 */

public interface PresonView {
    void Success(Userbean2 userbean);
    void Error(String msg);
    void onFair(Throwable e);
}
