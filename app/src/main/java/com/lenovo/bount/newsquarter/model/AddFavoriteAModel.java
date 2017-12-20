
package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/12/18.
 */

public class AddFavoriteAModel {
    public void getAddFavorite(String uid,String wid)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder()
                .getService().getaddFavorite(uid,wid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<ResponsBodyBean>() {
                    @Override
                    public void onNext(ResponsBodyBean bean) {
                  if("0".equals(bean.code))
                  {
                      addFavoriteInterface.AddFavoriteSucces(bean);
                  }
                  else if("1".equals(bean.code))
                  {
                      addFavoriteInterface.AddFavoriteError(bean.msg);
                  }else
                  {
                      addFavoriteInterface.AddFavoriteOnFair(bean.msg);
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
     private AddFavoriteInterface addFavoriteInterface;

    public void setAddFavoriteInterface(AddFavoriteInterface addFavoriteInterface) {
        this.addFavoriteInterface = addFavoriteInterface;
    }

    public interface AddFavoriteInterface
              {
                  void AddFavoriteSucces(ResponsBodyBean bean);
                  void AddFavoriteError(String msg);
                  void AddFavoriteOnFair(String msg);

              }
}
