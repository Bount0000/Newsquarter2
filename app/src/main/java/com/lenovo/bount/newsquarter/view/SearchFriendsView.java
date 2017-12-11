package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.SearchBean;

/**
 * Created by lenovo on 2017/12/9.
 */

public interface SearchFriendsView {
    void SearchSuccess(SearchBean value);
    void SearchError(String msg);
    void SearchonFair(String msg);
}
