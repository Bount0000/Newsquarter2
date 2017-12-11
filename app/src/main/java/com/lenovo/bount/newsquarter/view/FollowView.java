package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

/**
 * Created by lenovo on 2017/12/1.
 */

public interface FollowView {
    void FollowSuccess(ResponsBodyBean value);
    void FollowError(String msg);
    void FollowOnFair(Throwable e);
}
