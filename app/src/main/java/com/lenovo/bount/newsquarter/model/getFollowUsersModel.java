package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.GetFollowUsersBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/12/14.
 */

public class getFollowUsersModel {
    public void getFollowUsers(String uid)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder().getService().getFollowUsers(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<GetFollowUsersBean>() {
                    @Override
                    public void onNext(GetFollowUsersBean getFollowUsersBean) {
                        if("0".equals(getFollowUsersBean.code))
                        {
                            followUsersInterFace.FollowSucces(getFollowUsersBean);
                        }
                        else if("1".equals(getFollowUsersBean.code))
                        {
                            followUsersInterFace.FollowError(getFollowUsersBean.msg);
                        }else
                        {
                            followUsersInterFace.FollowOnFrair(getFollowUsersBean.msg);

                        }
                        System.out.println("===关注=="+getFollowUsersBean.msg);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                 });
                 }
      private FollowUsersInterFace followUsersInterFace;

    public void setFollowUsersInterFace(FollowUsersInterFace followUsersInterFace) {
        this.followUsersInterFace = followUsersInterFace;
    }

    public interface FollowUsersInterFace
       {
           void FollowSucces(GetFollowUsersBean getFollowUsersBean);
           void FollowError(String msg);
           void FollowOnFrair(String msg);
        }

                 }
