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
 * Created by lenovo on 2017/12/6.
 */

public class PublishVideoModel {

    public void getpbvideo(String uid,File videoFile,File coverFile,String videoDesc,String latitude,String longitude)
    {
        MultipartBody.Builder builder=new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("uid",uid);
        builder.addFormDataPart("videoDesc",videoDesc);
        builder.addFormDataPart("latitude",latitude);
        builder.addFormDataPart("longitude",longitude);
        RequestBody revideoFile=RequestBody.create(MediaType.parse("multipart/form-data"),videoFile);
        builder.addFormDataPart("videoFile",videoFile.getName(),revideoFile);

        RequestBody recoverFile=RequestBody.create(MediaType.parse("multipart/form-data"),coverFile);
        builder.addFormDataPart("coverFile",coverFile.getName(),recoverFile);
        List<MultipartBody.Part> parts = builder.build().parts();
        new RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder()
                .getService()
                .getpublishVideos(parts)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponsBodyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponsBodyBean bodyBean) {
                         if("0".equals(bodyBean.code))
                         {
                             getPublishInterface.PbVideoSuccess(bodyBean);
                         }
                         else if("0".equals(bodyBean.code))
                         {
                             getPublishInterface.PbVideoError(bodyBean.msg);
                         }else
                         {
                             getPublishInterface.PbVideoOnFair(bodyBean.msg);
                         }
                        System.out.println("======发布视屏======="+bodyBean.msg);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("======发布视屏onError======="+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
                }
                private GetPublishInterface getPublishInterface;

    public void setGetPublishInterface(GetPublishInterface getPublishInterface) {
        this.getPublishInterface = getPublishInterface;
    }

    public  interface  GetPublishInterface
                {
                    void PbVideoSuccess(ResponsBodyBean bodyBean);
                    void PbVideoError(String msg);
                    void PbVideoOnFair(String msg);
                }
}
