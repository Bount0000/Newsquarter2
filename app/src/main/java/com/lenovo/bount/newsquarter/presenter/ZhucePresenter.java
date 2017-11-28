package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.ZhuceModel;
import com.lenovo.bount.newsquarter.view.ZhuceView;

/**
 * Created by lenovo on 2017/11/27.
 */

public class ZhucePresenter extends BasePresenter<ZhuceView> implements ZhuceModel.ZhuceInterface{
    private ZhuceModel zhuceModel;
    private ZhuceView zhuceView;

    public ZhucePresenter(ZhuceView mView) {
        super(mView);
        this.zhuceView=mView;
        zhuceModel=new ZhuceModel();
        zhuceModel.setZhuceInterface(this);
    }
    public void zhuce(String mobile,String pwd)
    {
        zhuceModel.zhuce(mobile,pwd);
    }

    @Override
    public void Success(ResponsBodyBean value) {
        zhuceView.Success(value);
    }

    @Override
    public void Error() {
        zhuceView.Error();
    }

    @Override
    public void onFair() {
        zhuceView.onFair();
    }
}
