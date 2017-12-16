package com.lenovo.bount.newsquarter.model;


import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/12/14.
 */

public class CommentModel {

    public void getCommnet(String uid,String wid,String content)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder().getService().getcomment(uid,wid,content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<ResponsBodyBean>() {
                    @Override
                    public void onNext(ResponsBodyBean bodyBean) {
                        if("0".equals(bodyBean.code))
                        {
                            getCommentinterface.CommentSuccess(bodyBean);
                        }
                        else if("1".equals(bodyBean.code))
                        {
                            getCommentinterface.CommentError(bodyBean.msg);
                        }
                        else
                        {
                            getCommentinterface.CommentOnFair(bodyBean.msg);
                        }
                        System.out.println("===作品评论======="+bodyBean.msg);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("===onError作品评论======="+t);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("===onComplete=======");
                    }
                });
           }
  private  getCommentinterface getCommentinterface;

    public void setGetCommentinterface(CommentModel.getCommentinterface getCommentinterface) {
        this.getCommentinterface = getCommentinterface;
    }

    public interface getCommentinterface
           {
               void CommentSuccess(ResponsBodyBean bodyBean);
               void CommentError(String msg);
               void CommentOnFair(String msg);
           }
}
