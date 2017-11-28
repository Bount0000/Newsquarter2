package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.GetJokeBean;

/**
 * Created by lenovo on 2017/11/28.
 */

public interface GetJokeView {
    void Success(GetJokeBean value);
    void Error();
    void onFair(Throwable e);
}
