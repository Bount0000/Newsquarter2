package com.lenovo.bount.newsquarter.model;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.utils.RetrofitUtils;

import java.io.File;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by lenovo on 2017/11/28.
 */

public class PublishJokeModel {
    public void publishJoke(String uid, String content, List<String> jokeFiles)
    {
        MultipartBody.Builder builder=new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("uid",uid);
        builder.addFormDataPart("content",content);
        for (int i = 0; i <jokeFiles.size(); i++) {
            File file=new File(jokeFiles.get(i));
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
            builder.addFormDataPart("jokeFiles",file.getName(),requestBody);
        }
          List<MultipartBody.Part> parts=builder.build().parts();
          new RetrofitUtils.Builder().addConverterFactory()
                  .addCallAdapterFactory()
                  .builder()
                  .getService().getpublishJoke(parts)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<ResponsBodyBean>() {
                      @Override
                      public void onSubscribe(Disposable d) {

                      }
                      @Override
                      public void onNext(ResponsBodyBean value) {
                       if(value.code.equals("0"))
                       {
                           publishJokeinterface.Success(value);

                       }
                       else if(value.code.equals("1"))
                       {
                           publishJokeinterface.Error(value.msg);
                       }
                       else
                       {
                           publishJokeinterface.onFair(value.msg);
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
   private publishJokeinterface publishJokeinterface;

    public void setPublishJokeinterface(PublishJokeModel.publishJokeinterface publishJokeinterface) {
        this.publishJokeinterface = publishJokeinterface;
    }

    public interface publishJokeinterface
    {
        void Success(ResponsBodyBean bodyBean);
        void Error(String msg);
        void onFair(String msg);
    }
   }
