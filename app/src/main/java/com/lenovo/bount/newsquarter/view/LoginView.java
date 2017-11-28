package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.bean.Userbean;

/**
 * Created by lenovo on 2017/11/28.
 */

public interface LoginView {
    void Success(ResponsBodyBean<Userbean> userbean);
    void Error();
    void onFair();
}
