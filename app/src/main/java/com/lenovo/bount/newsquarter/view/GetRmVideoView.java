package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.RmSpBean;

/**
 * Created by lenovo on 2017/12/6.
 */

public interface GetRmVideoView {
    void RmSpSuccess(RmSpBean rmSpBean);
    void RmSpError(String msg);
    void RmSpOnFair(String msg);
}
