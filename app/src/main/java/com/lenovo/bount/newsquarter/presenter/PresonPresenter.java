package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.Userbean2;
import com.lenovo.bount.newsquarter.model.PresonModel;
import com.lenovo.bount.newsquarter.view.PresonView;

/**
 * Created by lenovo on 2017/11/28.
 */

public class PresonPresenter extends BasePresenter<PresonView> implements PresonModel.PersonInterface {
    private PresonView presenterView;
    private PresonModel presonModel;
    public PresonPresenter(PresonView mView) {
        super(mView);
        this.presenterView=mView;
        presonModel=new PresonModel();
        presonModel.setPersonInterface(this);
    }
    public void getuser(String uid)
    {
        presonModel.getUser(uid);
    }

    @Override
    public void Success(Userbean2 userbean) {
        presenterView.Success(userbean);
    }

    @Override
    public void Error(String msg) {
        presenterView.Error(msg);
    }


    @Override
    public void onFair(Throwable e) {
        presenterView.onFair(e);
    }
}
