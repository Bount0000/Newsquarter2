package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.Guangao;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/30.
 */

public class GetAdModel {

    public void getAd()
    {
        Observer<Guangao> observer = new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder().getService().getAd()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<Guangao>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Guangao value) {
                        if (value.code.equals("0")) {
                            getAdInterface.Success(value);
                            System.out.println("==guang===" + value.msg);
                        } else if (value.code.equals("1")) {
                            getAdInterface.Error(value.msg);
                            System.out.println("==guang===" + value.msg);
                        } else {
                            getAdInterface.OnFair(value.msg);
                            System.out.println("==guang===" + value.msg);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    private GetAdInterface getAdInterface;

    public void setGetAdInterface(GetAdInterface getAdInterface) {
        this.getAdInterface = getAdInterface;
    }

    public interface GetAdInterface
    {
        void Success(Guangao value);
        void Error(String msg);
        void OnFair(String msg);
    }
}
