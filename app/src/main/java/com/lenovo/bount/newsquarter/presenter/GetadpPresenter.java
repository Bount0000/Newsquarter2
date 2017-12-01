package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.Guangao;
import com.lenovo.bount.newsquarter.model.GetAdModel;
import com.lenovo.bount.newsquarter.view.GetadView;

/**
 * Created by lenovo on 2017/11/30.
 */

public class GetadpPresenter extends BasePresenter<GetadView> implements GetAdModel.GetAdInterface {
    private GetadView getadView;
    private GetAdModel getAdModel;

    public GetadpPresenter(GetadView mView) {
        super(mView);
        getadView=mView;
        getAdModel=new GetAdModel();
        getAdModel.setGetAdInterface(this);
    }
   public void getAd()
   {
       getAdModel.getAd();
   }
    @Override
    public void Success(Guangao value) {
        getadView.Success(value);
    }

    @Override
    public void Error(String msg) {
        getadView.Error(msg);
    }

    @Override
    public void OnFair(String msg) {
        getadView.OnFair(msg);
    }
}
