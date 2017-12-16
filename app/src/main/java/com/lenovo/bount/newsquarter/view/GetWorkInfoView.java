package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.GetWorkInfoBean;

/**
 * Created by lenovo on 2017/12/15.
 */

public interface GetWorkInfoView {
    void Success(GetWorkInfoBean bean);
    void Error(String msg);
    void OnFair(String msg);
}
