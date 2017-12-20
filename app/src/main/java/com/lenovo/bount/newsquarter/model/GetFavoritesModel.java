
package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.GetFavoritesBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/12/18.
 */

public class GetFavoritesModel {
    public void getFavorite(String uid)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder()
                .getService().getFavorites(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<GetFavoritesBean>() {
                    @Override
                    public void onNext(GetFavoritesBean bean) {
                  if("0".equals(bean.code))
                  {
                      getFavoriteInterface.GetFavoriteSucces(bean);
                  }
                  else if("1".equals(bean.code))
                  {
                      getFavoriteInterface.GetFavoriteError(bean.msg);
                  }else
                  {
                      getFavoriteInterface.GetFavoriteOnFair(bean.msg);
                  }
                        System.out.println("====收藏======"+bean.msg);
                    }
                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
              }
     private GetFavoriteInterface getFavoriteInterface;

    public void setGetFavoriteInterface(GetFavoriteInterface getFavoriteInterface) {
        this.getFavoriteInterface = getFavoriteInterface;
    }

    public interface GetFavoriteInterface
              {
                  void GetFavoriteSucces(GetFavoritesBean bean);
                  void GetFavoriteError(String msg);
                  void GetFavoriteOnFair(String msg);

              }
}
