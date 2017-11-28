package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/27.
 */

public class ZhuceModel {
    public void zhuce(String mobile, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",pwd);
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder().getService().getDate(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponsBodyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponsBodyBean value) {
                        zhuceInterface.Success(value);
                        System.out.println("=="+value.msg);
                    }

                    @Override
                    public void onError(Throwable e) {
                        zhuceInterface.Error();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private ZhuceInterface zhuceInterface;

    public void setZhuceInterface(ZhuceInterface zhuceInterface) {
        this.zhuceInterface = zhuceInterface;
    }

    public interface  ZhuceInterface
    {
        void Success(ResponsBodyBean value);
        void Error();
        void onFair();
    }
}
