package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.AddFavoriteAModel;
import com.lenovo.bount.newsquarter.view.AddFavoriteView;

/**
 * Created by lenovo on 2017/12/18.
 */

public class AddFavoritePresenter extends BasePresenter<AddFavoriteView> implements AddFavoriteAModel.AddFavoriteInterface
{
    private AddFavoriteAModel favoriteAModel;
    private AddFavoriteView  addFavoriteView;

    public AddFavoritePresenter(AddFavoriteView mView) {
        super(mView);
        addFavoriteView=mView;
        favoriteAModel=new AddFavoriteAModel();
        favoriteAModel.setAddFavoriteInterface(this);
    }
 public  void getAddFavorite(String uid,String wid)
 {
     favoriteAModel.getAddFavorite(uid,wid);
 }
    @Override
    public void AddFavoriteSucces(ResponsBodyBean bean) {
        addFavoriteView.AddFavoriteSucces(bean);
    }

    @Override
    public void AddFavoriteError(String msg) {
        addFavoriteView.AddFavoriteError(msg);
    }

    @Override
    public void AddFavoriteOnFair(String msg) {
        addFavoriteView.AddFavoriteOnFair(msg);
    }
}
