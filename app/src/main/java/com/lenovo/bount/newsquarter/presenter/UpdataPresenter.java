
package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.BanbenUpdate;
import com.lenovo.bount.newsquarter.model.UpdataModel;
import com.lenovo.bount.newsquarter.view.UpdateView;

/**
 * Created by lenovo on 2017/11/29.
 */

public class UpdataPresenter extends BasePresenter<UpdateView> implements UpdataModel.UpdataInterface {
    private UpdateView view;
    private UpdataModel model;

    public UpdataPresenter(UpdateView mView) {
        super(mView);
        view=mView;
        model=new UpdataModel();
        model.setUpdataInterface(this);
    }
     public  void getupdate()
     {
         model.getUpdata();
     }
    @Override
    public void Success(BanbenUpdate value) {
        view.Success(value);
    }

    @Override
    public void Error(String msg) {
        view.Error(msg);
    }

    @Override
    public void onFair(Throwable e) {
        view.onFair(e);
    }

    @Override
    public void Token(String msg) {
        view.Token(msg);
    }
}
