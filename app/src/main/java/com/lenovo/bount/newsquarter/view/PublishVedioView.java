package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

/**
 * Created by lenovo on 2017/11/28.
 */

public interface PublishVedioView {
    void Success(ResponsBodyBean bodyBean);
    void Error(String msg);
    void onFair(String msg);
}
