package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.GetNearVideoBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/7.
 */

public class GetNearVideosModel {
    public void GetNearVideos(int page,String latitude,String longitude)
    {
          new RetrofitUtils.Builder().addConverterFactory()
                  .addCallAdapterFactory()
                  .builder().getService().getNearVideos(page,latitude,longitude)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<GetNearVideoBean>() {
                      @Override
                      public void onSubscribe(Disposable d) {

                      }

                      @Override
                      public void onNext(GetNearVideoBean value) {
                          if("0".equals(value.code))
                          {
                              getNearVideosInterface.GetNearSuccess(value);
                          }else if("1".equals(value.code))
                          {
                              getNearVideosInterface.GetNearError(value.msg);
                          }else
                          {
                              getNearVideosInterface.GetNearOnFair(value.msg);
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
    private GetNearVideosInterface getNearVideosInterface;

    public void setGetNearVideosInterface(GetNearVideosInterface getNearVideosInterface) {
        this.getNearVideosInterface = getNearVideosInterface;
    }

    public interface GetNearVideosInterface
      {
          void GetNearSuccess(GetNearVideoBean value);
          void GetNearError(String msg);
          void GetNearOnFair(String msg);
      }
}
