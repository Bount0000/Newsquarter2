package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.GetNearVideoBean;

/**
 * Created by lenovo on 2017/12/7.
 */

public interface GetNearVideosView {
    void GetNearSuccess(GetNearVideoBean value);
    void GetNearError(String msg);
    void GetNearOnFair(String msg);
}
