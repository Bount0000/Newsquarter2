package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.bean.Userbean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/28.
 */

public class PresonModel {

    public void getUser(String uid,String token)
    {new RetrofitUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .builder().getService().getuser(uid,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponsBodyBean<Userbean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponsBodyBean<Userbean> value) {
                        if(value.code.equals("0"))
                        {
                            personInterface.Success(value);
                            System.out.println("==model=="+value.msg);
                        }
                        else
                        {
                            personInterface.Error();
                            System.out.println("==model=="+value.msg);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("==model=="+e);
                        personInterface.onFair(e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("==onComplete==");
                    }
                });
    }
    private PersonInterface personInterface;

    public void setPersonInterface(PersonInterface personInterface) {
        this.personInterface = personInterface;
    }

    public interface  PersonInterface
    {
        void Success(ResponsBodyBean<Userbean> userbean);
        void Error();
        void onFair(Throwable e);
    }
}
