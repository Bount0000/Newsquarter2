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
 * Created by lenovo on 2017/12/1.
 */

public class ChangePictureModel {

    public void getchage(String uid, File file)
    {
        MultipartBody.Builder builder=new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("uid",uid);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        builder.addFormDataPart("file",file.getName(),requestBody);
        List<MultipartBody.Part> parts = builder.build().parts();
        new  RetrofitUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .builder()
                .getService().getchange(parts).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponsBodyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(ResponsBodyBean value) {
                       if("0".equals(value.code))
                       {
                           chageTxInterface.ChageTxSuccess(value);
                       }
                       else if("1".equals(value.code))
                       {
                           chageTxInterface.ChageTxError(value.msg);
                       }
                        System.out.println("===上传====="+value.msg);
                    }

                    @Override
                    public void onError(Throwable e) {
                        chageTxInterface.ChageTxonFair(e);
                    }
                    @Override
                    public void onComplete() {

                    }
                });

    }
    private ChageTxInterface chageTxInterface;

    public void setChageTxInterface(ChageTxInterface chageTxInterface) {
        this.chageTxInterface = chageTxInterface;
    }

    public interface ChageTxInterface
    {   void ChageTxSuccess(ResponsBodyBean value);
        void ChageTxError(String msg);
        void ChageTxonFair(Throwable e);
    }
}
