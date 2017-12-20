package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.RandomFriendsBean;
import com.lenovo.bount.newsquarter.model.RandomFavoriteModel;
import com.lenovo.bount.newsquarter.view.RandomFavoriteView;

/**
 * Created by lenovo on 2017/12/18.
 */

public class RandomFavoritePresenter extends BasePresenter<RandomFavoriteView> implements RandomFavoriteModel.RandomFavoriteInterface
{
    private RandomFavoriteModel randomFavoriteModel;
    private RandomFavoriteView  randomFavoriteView;

    public RandomFavoritePresenter(RandomFavoriteView mView) {
        super(mView);
        randomFavoriteView=mView;
        randomFavoriteModel=new RandomFavoriteModel();
        randomFavoriteModel.setRandomFavoriteInterface(this);
    }
 public void getRandomFavorite()
 {
     randomFavoriteModel.RandomFavorite();
 }

    @Override
    public void RandomFavoriteSucces(RandomFriendsBean bean) {
        randomFavoriteView.RandomFavoriteSucces(bean);
    }

    @Override
    public void RandomFavoriteError(String msg) {
        randomFavoriteView.RandomFavoriteError(msg);
    }

    @Override
    public void RandomFavoriteOnFair(String msg) {
        randomFavoriteView.RandomFavoriteOnFair(msg);
    }
}
