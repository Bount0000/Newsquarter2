package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.Guangao;

/**
 * Created by lenovo on 2017/11/30.
 */

public interface GetadView {

    void Success(Guangao value);
    void Error(String msg);
    void OnFair(String msg);
}
