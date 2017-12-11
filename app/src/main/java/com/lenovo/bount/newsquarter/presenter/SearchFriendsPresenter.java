package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.SearchBean;
import com.lenovo.bount.newsquarter.model.SearchFriendsModel;
import com.lenovo.bount.newsquarter.view.SearchFriendsView;

/**
 * Created by lenovo on 2017/12/9.
 */

public class SearchFriendsPresenter extends BasePresenter<SearchFriendsView> implements SearchFriendsModel.SearchFriendsInterface
{
    private SearchFriendsView friendsView;
    private SearchFriendsModel friendsModel;
    public SearchFriendsPresenter(SearchFriendsView mView) {
        super(mView);
        friendsView=mView;
        friendsModel=new SearchFriendsModel();
        friendsModel.setSearchFriendsInterface(this);
    }
       public void getSearch(String keywords,int page)
       {
           friendsModel.getSearch(keywords,page);
       }
    @Override
    public void SearchSuccess(SearchBean value) {
        friendsView.SearchSuccess(value);
    }

    @Override
    public void SearchError(String msg) {
        friendsView.SearchError(msg);
    }

    @Override
    public void SearchonFair(String msg) {
        friendsView.SearchonFair(msg);
    }
}
