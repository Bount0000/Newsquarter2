package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.SearchBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/9.
 */

public class SearchFriendsModel  {
    public void getSearch(String keywords,int page)
    {
     new RetrofitUtils.Builder().addConverterFactory()
             .addCallAdapterFactory()
             .builder()
             .getService().getsearchFriends(keywords,page)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Observer<SearchBean>() {
                 @Override
                 public void onSubscribe(Disposable d) {

                 }

                 @Override
                 public void onNext(SearchBean value) {
                     if("0".equals(value.code))
                     {
                         searchFriendsInterface.SearchSuccess(value);
                     }
                     else if("1".equals(value.code))
                     {
                         searchFriendsInterface.SearchError(value.msg);
                     }
                     else
                     {
                         searchFriendsInterface.SearchonFair(value.msg);
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
    private  SearchFriendsInterface searchFriendsInterface;

    public void setSearchFriendsInterface(SearchFriendsInterface searchFriendsInterface) {
        this.searchFriendsInterface = searchFriendsInterface;
    }

    public  interface SearchFriendsInterface
          {
              void SearchSuccess(SearchBean value);
              void SearchError(String msg);
              void SearchonFair(String msg);

          }
}
