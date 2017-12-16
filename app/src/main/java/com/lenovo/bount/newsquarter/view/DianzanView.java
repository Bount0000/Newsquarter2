package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

/**
 * Created by lenovo on 2017/12/12.
 */

public interface DianzanView
{
    void Success(ResponsBodyBean bodyBean);
    void Error(String msg);
    void OnFair(String msg);
}
