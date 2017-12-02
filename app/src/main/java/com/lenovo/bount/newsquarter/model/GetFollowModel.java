package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/1.
 */

public class GetFollowModel {
    public void getfollowlist(String uid)
    {
         new RetrofitUtils.Builder().addConverterFactory()
                 .addCallAdapterFactory()
                 .builder()
                 .getService().getfollowlist(uid)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<ResponsBodyBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(ResponsBodyBean value) {
                       if("0".equals(value.code))
                       {
                           getFollowInterface.Success(value);
                       }
                       else if("1".equals(value.code))
                       {
                           getFollowInterface.Error(value.msg);
                       }
                       else
                       {
                           getFollowInterface.Error(value.msg);
                       }
                     }

                     @Override
                     public void onError(Throwable e) {
                         getFollowInterface.OnFair(e);
                     }

                     @Override
                     public void onComplete() {

                     }
                 });
                }
    private GetFollowInterface getFollowInterface;
    public void setGetFollowInterface(GetFollowInterface getFollowInterface) {
        this.getFollowInterface = getFollowInterface;
    }

    public interface GetFollowInterface
                {
                    void Success(ResponsBodyBean value);
                    void Error(String msg);
                    void OnFair(Throwable e);

                }

}
