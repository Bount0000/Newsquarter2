package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.BanbenUpdate;

/**
 * Created by lenovo on 2017/11/29.
 */

public interface UpdateView {
    void Success(BanbenUpdate value);
    void Error(String msg);
    void onFair(Throwable e);
    void Token(String msg);
}
