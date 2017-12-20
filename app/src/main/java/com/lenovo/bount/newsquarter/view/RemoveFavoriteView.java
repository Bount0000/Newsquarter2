package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

/**
 * Created by lenovo on 2017/12/18.
 */

public interface RemoveFavoriteView {
    void RemoveFavoriteSucces(ResponsBodyBean bean);
    void RemoveFavoriteError(String msg);
    void RemoveFavoriteOnFair(String msg);

}
