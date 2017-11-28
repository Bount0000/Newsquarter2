package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/28.
 */

public class PublishJokeModel {
    public void publishJoke(String uid,String content)
    {
          new RetrofitUtils.Builder().addConverterFactory()
                  .addCallAdapterFactory()
                  .builder()
                  .getService().getpublishJoke(uid,content)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<ResponsBodyBean>() {
                      @Override
                      public void onSubscribe(Disposable d) {

                      }
                      @Override
                      public void onNext(ResponsBodyBean value) {
                       if(value.code.equals("0"))
                       {
                           publishJokeinterface.Success(value);
                           System.out.println("===段子====="+value.msg);
                       }else
                       {
                           publishJokeinterface.Error();
                           System.out.println("===段子====="+value.msg);
                       }
                      }
                      @Override
                      public void onError(Throwable e) {
                          publishJokeinterface.onFair(e);
                      }

                      @Override
                      public void onComplete() {

                      }
                  });
                }
   private publishJokeinterface publishJokeinterface;

    public void setPublishJokeinterface(PublishJokeModel.publishJokeinterface publishJokeinterface) {
        this.publishJokeinterface = publishJokeinterface;
    }

    public interface publishJokeinterface
    {
        void Success(ResponsBodyBean bodyBean);
        void Error();
        void onFair(Throwable e);
    }



}
