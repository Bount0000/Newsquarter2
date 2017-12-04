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
 * Created by lenovo on 2017/12/4.
 */

public class PublishVideoModel {

    private RequestBody body;
    private MultipartBody.Builder builder;

    public void getpbvideo(String uid, String laungitude, String longitude, List<String> videoFile, List<String> coverFile)
    {
        builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("uid",uid);
        builder.addFormDataPart("laungitude",laungitude);
        builder.addFormDataPart("longitude",longitude);
        for (int i = 0; i <videoFile.size(); i++) {
            File file1 =new File(videoFile.get(i));
            body = RequestBody.create(MediaType.parse("multipart/form-data"),file1);
            builder.addFormDataPart("videoFile",file1.getName(), body);
        }
        for (int i = 0; i <coverFile.size(); i++) {
            File file2 =new File(coverFile.get(i));
            body=RequestBody.create(MediaType.parse("multipart/form-data"),file2);
            builder.addFormDataPart("coverFile",file2.getName(),body);
        }
        List<MultipartBody.Part> parts = builder.build().parts();
        List<MultipartBody.Part> parts2 = builder.build().parts();

        new RetrofitUtils.Builder().addConverterFactory()
              .addCallAdapterFactory()
              .builder().getService().getpublishVideos(parts,parts2)
              .observeOn(Schedulers.io())
              .subscribeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<ResponsBodyBean>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(ResponsBodyBean value) {

                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onComplete() {

                  }
              });
             }
     private PublishVideoInterface publishVideoInterface;

    public void setPublishVideoInterface(PublishVideoInterface publishVideoInterface) {
        this.publishVideoInterface = publishVideoInterface;
    }

    public  interface PublishVideoInterface
             {
                 void Success(ResponsBodyBean bodyBean);
                 void Error(String msg);
                 void onFair(String msg);
             }
}
