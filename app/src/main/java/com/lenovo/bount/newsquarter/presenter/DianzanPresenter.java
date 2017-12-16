package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.DianzanModel;
import com.lenovo.bount.newsquarter.view.DianzanView;

/**
 * Created by lenovo on 2017/12/12.
 */

public class DianzanPresenter extends BasePresenter<DianzanView> implements DianzanModel.PraiseInterface {

    private  DianzanModel model;
    private DianzanView view;

    public DianzanPresenter(DianzanView mView) {
        super(mView);
        view=mView;
        model=new DianzanModel();
        model.setPraiseInterface(this);

    }
    public void getDaianzan(String uid,String wid)
    {

        model.getpraise(uid,wid);
    }
    @Override
    public void Success(ResponsBodyBean bodyBean) {

        view.Success(bodyBean);
    }

    @Override
    public void Error(String msg) {
      view.Error(msg);
    }

    @Override
    public void OnFair(String msg) {
        view.OnFair(msg);
    }
}
