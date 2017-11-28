package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.bean.Userbean;
import com.lenovo.bount.newsquarter.model.LoginModel;
import com.lenovo.bount.newsquarter.view.LoginView;

/**
 * Created by lenovo on 2017/11/28.
 */

public class LoginPresenter extends BasePresenter<LoginView> implements LoginModel.LoginInterface {
    private LoginModel loginModel;
    private LoginView loginView;

    public LoginPresenter(LoginView mView) {
        super(mView);
        this.loginView=mView;
        loginModel=new LoginModel();
        loginModel.setLoginInterface(this);
    }

    public void login(String mobile,String pwd)
    {
        loginModel.login(mobile,pwd);
    }

    @Override
    public void Success(ResponsBodyBean<Userbean> userbean) {
        loginView.Success(userbean);
    }

    @Override
    public void Error() {
        loginView.Error();
    }

    @Override
    public void onFair() {
        loginView.onFair();
    }
}
