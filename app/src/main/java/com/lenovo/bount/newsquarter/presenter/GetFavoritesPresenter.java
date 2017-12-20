package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.GetFavoritesBean;
import com.lenovo.bount.newsquarter.model.GetFavoritesModel;
import com.lenovo.bount.newsquarter.view.GetFavoritesView;

/**
 * Created by lenovo on 2017/12/18.
 */

public class GetFavoritesPresenter extends BasePresenter<GetFavoritesView> implements GetFavoritesModel.GetFavoriteInterface {
    private GetFavoritesModel favoritesModel;
    private GetFavoritesView favoritesView;

    public GetFavoritesPresenter(GetFavoritesView mView) {
        super(mView);
        favoritesView=mView;
        favoritesModel=new GetFavoritesModel();
        favoritesModel.setGetFavoriteInterface(this);
    }
     public  void GetFavorites(String uid)
     {
         favoritesModel.getFavorite(uid);
     }
    @Override
    public void GetFavoriteSucces(GetFavoritesBean bean) {
        favoritesView.GetFavoriteSucces(bean);
    }

    @Override
    public void GetFavoriteError(String msg) {
        favoritesView.GetFavoriteError(msg);
    }

    @Override
    public void GetFavoriteOnFair(String msg) {
        favoritesView.GetFavoriteOnFair(msg);
    }
}
