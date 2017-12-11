package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/1.
 */

public class FollowModel {

    public  void getfollow(String uid,String followId)
    {
        Map<String,String> parms=new HashMap<>();
        parms.put("uid",uid);
        parms.put("followId",followId);
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder().getService().getfollow(parms)
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
                              followInterface.FollowSuccess(value);
                          }else if("1".equals(value.code))
                          {
                              followInterface.FollowError(value.msg);
                          }else
                          {
                              followInterface.FollowError(value.msg);
                          }
                    }

                    @Override
                    public void onError(Throwable e) {
                        followInterface.FollowOnFair(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
               }
  private FollowInterface followInterface;

    public void setFollowInterface(FollowInterface followInterface) {
        this.followInterface = followInterface;
    }

    public  interface FollowInterface
  {
      void FollowSuccess(ResponsBodyBean value);
      void FollowError(String msg);
      void FollowOnFair(Throwable e);

  }
}
