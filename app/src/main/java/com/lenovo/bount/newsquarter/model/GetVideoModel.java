package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.GetVideos;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/1.
 */

public class GetVideoModel {

    public  void getVideo(String uid,String type,int page)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder().getService().getVideos(uid,type,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetVideos>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetVideos value) {
                          if("0".equals(value.code))
                          {
                              getVideosInterface.GetVideoSuccess(value);
                          }else if("1".equals(value.code))
                          {
                              getVideosInterface.GetVideoError(value.msg);
                          }else
                          {
                              getVideosInterface.GetVideoError(value.msg);
                          }
                          System.out.println("===获取==="+value.msg);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getVideosInterface.GetVideoOnFair(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
               }
  private GetVideosInterface getVideosInterface;

    public void setGetVideosInterface(GetVideosInterface getVideosInterface) {
        this.getVideosInterface = getVideosInterface;
    }

    public  interface GetVideosInterface
  {
      void GetVideoSuccess(GetVideos value);
      void GetVideoError(String msg);
      void GetVideoOnFair(Throwable e);

  }
}
