package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.BanbenUpdate;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/29.
 */

public class UpdataModel {

    public void getUpdata()
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory().builder().getService().getupdate()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BanbenUpdate>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(BanbenUpdate value) {
                           if(value.code.equals("0"))
                           {
                               updataInterface.Success(value);

                           }
                           else if(value.code.equals("1"))
                           {
                               updataInterface.Error(value.msg);
                           }
                           else if(value.code.equals("2"))
                           {
                               updataInterface.Token(value.msg);
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

   private UpdataInterface updataInterface;

    public void setUpdataInterface(UpdataInterface updataInterface) {
        this.updataInterface = updataInterface;
    }

    public  interface UpdataInterface
            {
                void Success(BanbenUpdate value);
                void Error(String msg);
                void onFair(Throwable e);
                void Token(String msg);

            }
}
