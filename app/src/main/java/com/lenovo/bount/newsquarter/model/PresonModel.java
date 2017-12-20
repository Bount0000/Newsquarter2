package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.Userbean2;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/28.
 */

public class PresonModel {

    public void getUser(String uid)
    {        new RetrofitUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .builder().getService().getuser(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Userbean2>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(Userbean2 value) {
                          if("0".equals(value.code))
                          {
                              personInterface.Success(value);
                          }else if("1".equals(value.code))
                          {
                              personInterface.Error(value.msg);
                          }
                          else if("2".equals(value.code))
                          {
                              personInterface.Error(value.msg);
                          }
                        System.out.println("====信息====="+value.msg);
                    }

                    @Override
                    public void onError(Throwable e) {
                        personInterface.onFair(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    private PersonInterface personInterface;

    public void setPersonInterface(PersonInterface personInterface) {
        this.personInterface = personInterface;
    }

    public interface  PersonInterface
    {
        void Success(Userbean2 userbean);
        void Error(String msg);
        void onFair(Throwable e);
    }
}
