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

public class GetRmVideoModel {
    public void getRmVideoModel(int page)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder()
                .getService()
                .getspRm(page)
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
                          getRmSpinterface.RmSpSuccess(rmSpBean);
                      }else if("1".equals(rmSpBean.code))
                      {
                          getRmSpinterface.RmSpError(rmSpBean.msg);
                      }
                      else
                      {
                          getRmSpinterface.RmSpError(rmSpBean.msg);
                      }
                        System.out.println("=====获取热门视屏======"+rmSpBean.msg);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
               }

   private GetRmSpinterface getRmSpinterface;

    public void setGetRmSpinterface(GetRmSpinterface getRmSpinterface) {
        this.getRmSpinterface = getRmSpinterface;
    }

    public interface GetRmSpinterface
            {
                void RmSpSuccess(RmSpBean rmSpBean);
                void RmSpError(String msg);
                void RmSpOnFair(String msg);

            }

}
