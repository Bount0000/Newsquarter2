package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.GetJokeBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/28.
 */

public class GetJokesModel {

  public void getJokes(int page)
  {
    new RetrofitUtils.Builder().addConverterFactory()
            .addCallAdapterFactory()
            .builder().getService().getJoke(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<GetJokeBean>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(GetJokeBean value) {
                  if(value.code.equals("0"))
                  {
                      getJokeInterface.Success(value);
                  }
                  else if(value.code.equals("1"))
                {
                      getJokeInterface.Error(value.msg);
                 }
                 else if("2".equals(value.code))
                  {
                      getJokeInterface.Error(value.msg);
                  }

                }

                @Override
                public void onError(Throwable e) {
                    getJokeInterface.onFair(e);

                }

                @Override
                public void onComplete() {

                }
            });
  }
 private  GetJokeInterface getJokeInterface;

    public void setGetJokeInterface(GetJokeInterface getJokeInterface) {
        this.getJokeInterface = getJokeInterface;
    }

    public interface GetJokeInterface
  {
      void Success(GetJokeBean value);
      void Error(String msg);
      void onFair(Throwable e);
  }

}
