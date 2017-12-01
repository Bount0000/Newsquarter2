package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

/**
 * Created by lenovo on 2017/11/30.
 */

public interface NickNameView {
    void Success(ResponsBodyBean value);
    void Error(String msg);
    void onFair(Throwable e);
}
