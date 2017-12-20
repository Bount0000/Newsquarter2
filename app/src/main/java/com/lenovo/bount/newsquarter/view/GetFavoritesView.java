package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.GetFavoritesBean;

/**
 * Created by lenovo on 2017/12/18.
 */

public interface GetFavoritesView {
    void GetFavoriteSucces(GetFavoritesBean bean);
    void GetFavoriteError(String msg);
    void GetFavoriteOnFair(String msg);

}
