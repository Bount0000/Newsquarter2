package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

/**
 * Created by lenovo on 2017/12/18.
 */

public interface AddFavoriteView {
    void AddFavoriteSucces(ResponsBodyBean bean);
    void AddFavoriteError(String msg);
    void AddFavoriteOnFair(String msg);
}
