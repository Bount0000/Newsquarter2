
package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.RandomFriendsBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/12/18.
 */

public class RandomFavoriteModel {
    public void RandomFavorite()
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder()
                .getService().randomFriends()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<RandomFriendsBean>() {
                    @Override
                    public void onNext(RandomFriendsBean bean) {
                         if("1".equals(bean.code))
                         {
                             randomFavoriteInterface.RandomFavoriteSucces(bean);
                         }
                         else if("0".equals(bean.code))
                         {
                             randomFavoriteInterface.RandomFavoriteError(bean.msg);
                         }
                         else
                         {
                             randomFavoriteInterface.RandomFavoriteOnFair(bean.msg);
                         }
                        System.out.println("===搜索====="+bean.msg);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
              }
     private RandomFavoriteInterface  randomFavoriteInterface;

    public void setRandomFavoriteInterface(RandomFavoriteInterface randomFavoriteInterface) {
        this.randomFavoriteInterface = randomFavoriteInterface;
    }

    public interface RandomFavoriteInterface
              {
                  void RandomFavoriteSucces(RandomFriendsBean bean);
                  void RandomFavoriteError(String msg);
                  void RandomFavoriteOnFair(String msg);
              }
}
