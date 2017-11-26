package com.lenovo.bount.newsquarter.build;

import com.lenovo.bount.newsquarter.InterfaceService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/11/13.
 */

public class RetrofitUtils {

    public static RetrofitUtils retrofitUtils;
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
        OkHttpClient.Builder okbuilder = new OkHttpClient.Builder();
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("").client(okbuilder.build());
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
        public RetrofitUtils builder()
        {
           InterfaceService service=builder.build().create(InterfaceService.class);
            retrofitUtils=new RetrofitUtils(service);
            return retrofitUtils;
        }
        }
        }
