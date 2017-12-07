package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.RmSpBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/6.
 */

public class GetFjVideoModel {
    public void getFjVideoModel(int page,String latitude,String longitude)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder()
                .getService()
                .getFjRm(page,latitude,longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RmSpBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RmSpBean rmSpBean) {
                      if("0".equals(rmSpBean.code))
                      {
                          getFjSpinterface.FjSpSuccess(rmSpBean);
                      }else if("1".equals(rmSpBean.code))
                      {
                          getFjSpinterface.FjSpError(rmSpBean.msg);
                      }
                      else
                      {
                          getFjSpinterface.FjSpOnFair(rmSpBean.msg);

                      }
                        System.out.println("=====获取附近视屏======"+rmSpBean.msg);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
               }

   private GetFjSpinterface getFjSpinterface;

    public void setGetFjSpinterface(GetFjSpinterface getFjSpinterface) {
        this.getFjSpinterface = getFjSpinterface;
    }

    public interface GetFjSpinterface
            {
                void FjSpSuccess(RmSpBean rmSpBean);
                void FjSpError(String msg);
                void FjSpOnFair(String msg);
            }

}
