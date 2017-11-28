package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.bean.Userbean;
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
    public void getuser(String uid,String token)
    {
        presonModel.getUser(uid,token);
    }

    @Override
    public void Success(ResponsBodyBean<Userbean> userbean) {
        presenterView.Success(userbean);
    }

    @Override
    public void Error() {
        presenterView.Error();
    }

    @Override
    public void onFair(Throwable e) {
        presenterView.onFair(e);
    }
}
