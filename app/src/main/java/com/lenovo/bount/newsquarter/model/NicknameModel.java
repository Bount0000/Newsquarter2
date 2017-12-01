package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/30.
 */

public class NicknameModel {
    public void getnickname(String uid,String nickname)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory().builder().getService()
                .getnick(uid,nickname).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponsBodyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponsBodyBean value) {
                          if("0".equals(value.code))
                          {
                              nicknameInterface.Success(value);
                          }
                          else if("1".equals(value.code))
                          {
                              nicknameInterface.Error(value.msg);
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
    private NicknameInterface nicknameInterface;

    public void setNicknameInterface(NicknameInterface nicknameInterface) {
        this.nicknameInterface = nicknameInterface;
    }

    public interface  NicknameInterface
    {
        void Success(ResponsBodyBean value);
        void Error(String msg);
        void onFair(Throwable e);
    }
}
