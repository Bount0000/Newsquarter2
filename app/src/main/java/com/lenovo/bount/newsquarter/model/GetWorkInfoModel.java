package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.GetWorkInfoBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/12/15.
 */

public class GetWorkInfoModel {
    public void getWorkInfo(String uid)
    {
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder().getService().getWorkInfo(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<GetWorkInfoBean>() {
                    @Override
                    public void onNext(GetWorkInfoBean bean) {
                        if("0".equals(bean.code))
                        {
                            getWorkInfoInterface.Success(bean);
                        }
                        else if("1".equals(bean.code))
                        {
                            getWorkInfoInterface.Error(bean.msg);
                        }else
                        {
                            getWorkInfoInterface.OnFair(bean.msg);
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
    private GetWorkInfoInterface getWorkInfoInterface;

    public void setGetWorkInfoInterface(GetWorkInfoInterface getWorkInfoInterface) {
        this.getWorkInfoInterface = getWorkInfoInterface;
    }

    public interface GetWorkInfoInterface
    {
        void Success(GetWorkInfoBean bean);
        void Error(String msg);
        void OnFair(String msg);

    }
}
