
package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/12/18.
 */

public class RemoveFavoriteAModel {
    public void RemoveFavorite(String uid,String fid)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder()
                .getService().removeFavorite(uid,fid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<ResponsBodyBean>() {
                    @Override
                    public void onNext(ResponsBodyBean bean) {
                  if("0".equals(bean.code))
                  {
                      removeFavoriteInterface.RemoveFavoriteSucces(bean);
                  }
                  else if("1".equals(bean.code))
                  {
                      removeFavoriteInterface.RemoveFavoriteError(bean.msg);
                  }else
                  {
                      removeFavoriteInterface.RemoveFavoriteOnFair(bean.msg);
                  }

                    }
                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
              }
     private RemoveFavoriteInterface removeFavoriteInterface;
    public void setRemoveFavoriteInterface(RemoveFavoriteInterface removeFavoriteInterface) {
        this.removeFavoriteInterface = removeFavoriteInterface;
    }

    public interface RemoveFavoriteInterface
              {
                  void RemoveFavoriteSucces(ResponsBodyBean bean);
                  void RemoveFavoriteError(String msg);
                  void RemoveFavoriteOnFair(String msg);

              }
}
