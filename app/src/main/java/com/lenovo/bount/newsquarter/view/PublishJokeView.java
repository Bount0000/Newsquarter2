package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

/**
 * Created by lenovo on 2017/11/28.
 */

public interface PublishJokeView {
    void Success(ResponsBodyBean bodyBean);
    void Error();
    void onFair(Throwable e);
}
