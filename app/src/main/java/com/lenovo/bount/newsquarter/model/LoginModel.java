package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.bean.Userbean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/28.
 */

public class LoginModel {
    public void login(String mobile,String pwd)
    {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",pwd);
        new RetrofitUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .builder().getService().getlogin(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponsBodyBean<Userbean>>() {
                    @Override
                    public void accept(ResponsBodyBean<Userbean> userbean) throws Exception {
                         if(userbean.code.equals("0"))
                         {
                             loginInterface.Success(userbean);
                         }else
                         {
                             loginInterface.Error();
                         }
                    }
                });

          }
    private LoginInterface loginInterface;

    public void setLoginInterface(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    public interface  LoginInterface
    {
        void Success(ResponsBodyBean<Userbean> userbean);
        void Error();
        void onFair();
    }
}
