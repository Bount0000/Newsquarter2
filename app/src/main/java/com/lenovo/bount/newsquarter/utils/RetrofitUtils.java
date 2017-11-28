package com.lenovo.bount.newsquarter.utils;

import com.lenovo.bount.newsquarter.InterfaceService;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.lenovo.bount.newsquarter.Api.Api.Api_Url;

/**
 * Created by lenovo on 2017/11/27.
 */

public class RetrofitUtils {

    public static SpUtils.RetrofitUtils retrofitUtils;
    public InterfaceService service;
    public RetrofitUtils(InterfaceService service)
    {
        this.service=service;
    }
    public InterfaceService getService()
    {
        return service;
    }
    public static class Builder
    {
        OkHttpClient.Builder okbuilder = new OkHttpClient.Builder()
                .addInterceptor(new MyInterceptor());
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl(Api_Url).client(okbuilder.build());

        public Builder addCallAdapterFactory()
        {
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            return this;
        }
        public Builder addConverterFactory()
        {
            builder.addConverterFactory(GsonConverterFactory.create());
            return this;
        }
        public SpUtils.RetrofitUtils builder()
        {
            InterfaceService service=builder.build().create(InterfaceService.class);
            retrofitUtils=new SpUtils.RetrofitUtils(service);
            return retrofitUtils;
        }
    }
}
