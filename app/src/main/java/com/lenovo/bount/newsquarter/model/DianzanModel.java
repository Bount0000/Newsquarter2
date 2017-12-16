package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/12/11.
 */

public class DianzanModel {
    public void getpraise(String uid,String wid)
    {
      new RetrofitUtils.Builder().addConverterFactory()
              .addCallAdapterFactory()
              .builder().getService().getpraise(uid,wid)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new DisposableSubscriber<ResponsBodyBean>() {
                  @Override
                  public void onNext(ResponsBodyBean bodyBean) {
                      if("0".equals(bodyBean.code))
                      {
                          praiseInterface.Success(bodyBean);
                      }
                      else if("1".equals(bodyBean.code))
                      {
                          praiseInterface.Error(bodyBean.msg);
                      }else
                      {
                          praiseInterface.OnFair(bodyBean.msg);
                      }
                      System.out.println("=====点赞====="+bodyBean.msg);
                  }

                  @Override
                  public void onError(Throwable t) {

                  }

                  @Override
                  public void onComplete() {

                  }
              });
               }
  private PraiseInterface praiseInterface;

    public void setPraiseInterface(PraiseInterface praiseInterface) {
        this.praiseInterface = praiseInterface;
    }

    public interface PraiseInterface
               {
                   void Success(ResponsBodyBean bodyBean);
                   void Error(String msg);
                   void OnFair(String msg);
               }
}
