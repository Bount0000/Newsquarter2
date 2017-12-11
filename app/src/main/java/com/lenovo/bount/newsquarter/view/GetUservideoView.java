package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.Getuser;

/**
 * Created by lenovo on 2017/12/7.
 */

public interface GetUservideoView {

    void  getUserSuccess(Getuser value);
    void  getUserError(String msg);
    void  getUsermsOnFair(String msg);
}
