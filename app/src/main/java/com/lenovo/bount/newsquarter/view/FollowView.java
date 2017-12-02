package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

/**
 * Created by lenovo on 2017/12/1.
 */

public interface FollowView {
    void Success(ResponsBodyBean value);
    void Error(String msg);
    void OnFair(Throwable e);
}
