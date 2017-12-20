package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.RandomFriendsBean;

/**
 * Created by lenovo on 2017/12/18.
 */

public interface RandomFavoriteView {
    void RandomFavoriteSucces(RandomFriendsBean bean);
    void RandomFavoriteError(String msg);
    void RandomFavoriteOnFair(String msg);
}
