package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.RemoveFavoriteAModel;
import com.lenovo.bount.newsquarter.view.RemoveFavoriteView;

/**
 * Created by lenovo on 2017/12/18.
 */

public class RemoveFavoritePresenter extends BasePresenter<RemoveFavoriteView> implements RemoveFavoriteAModel.RemoveFavoriteInterface
{
    private RemoveFavoriteAModel removeFavoriteAModel;
    private RemoveFavoriteView  removeFavoriteView;

    public RemoveFavoritePresenter(RemoveFavoriteView mView) {
        super(mView);
        removeFavoriteView=mView;
        removeFavoriteAModel=new RemoveFavoriteAModel();
        removeFavoriteAModel.setRemoveFavoriteInterface(this);
    }
 public  void RomoveFavorite(String uid,String wid)
 {
     removeFavoriteAModel.RemoveFavorite(uid,wid);
 }


    @Override
    public void RemoveFavoriteSucces(ResponsBodyBean bean) {
        removeFavoriteView.RemoveFavoriteSucces(bean);
    }

    @Override
    public void RemoveFavoriteError(String msg) {
        removeFavoriteView.RemoveFavoriteError(msg);
    }

    @Override
    public void RemoveFavoriteOnFair(String msg) {
        removeFavoriteView.RemoveFavoriteOnFair(msg);
    }
}
