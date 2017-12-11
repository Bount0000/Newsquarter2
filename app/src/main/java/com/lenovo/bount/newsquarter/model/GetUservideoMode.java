package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.Getuser;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/7.
 */

public class GetUservideoMode {
    public  void getUserVideo(String uid,int page)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder()
                .getService().getUserVideos(uid,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Getuser>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Getuser value) {
                         if("0".equals(value.code))
                         {
                             getVideoUserInterface.getUserSuccess(value);
                         }
                         else if("1".equals(value.code))
                         {
                             getVideoUserInterface.getUserError(value.msg);
                         }
                         else
                         {
                           getVideoUserInterface.getUsermsOnFair(value.msg);
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
     private GetVideoUserInterface getVideoUserInterface;

    public void setGetVideoUserInterface(GetVideoUserInterface getVideoUserInterface) {
        this.getVideoUserInterface = getVideoUserInterface;
    }

    public  interface GetVideoUserInterface
      {
        void  getUserSuccess(Getuser value);
          void  getUserError(String msg);
          void  getUsermsOnFair(String msg);

      }
}
