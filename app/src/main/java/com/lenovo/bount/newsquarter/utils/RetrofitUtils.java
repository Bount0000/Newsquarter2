package com.lenovo.bount.newsquarter.utils;

import android.os.Environment;

import com.lenovo.bount.newsquarter.InterfaceService;
import com.lenovo.bount.newsquarter.interceptor.CachingControlInterceptor;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.lenovo.bount.newsquarter.Api.Api.Api_Url;

/**
 * Created by lenovo on 2017/11/27.
 */

public class RetrofitUtils {
    private static final long cacheSize=1024*1024*20;
    private static String cacheDirectory = Environment.getExternalStorageDirectory() + "/okttpcaches"; // 设置缓存文件路径
    private static Cache cache = new Cache(new File(cacheDirectory), cacheSize);  //
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
        OkHttpClient okbuilder = new OkHttpClient.Builder()
                .connectTimeout(8, TimeUnit.SECONDS)
                .writeTimeout(8,TimeUnit.SECONDS)
                .readTimeout(8,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                //有网络时的拦截器
                .addNetworkInterceptor(CachingControlInterceptor.REWRITE_RESPONSE_INTERCEPTOR)
                //没网络时的拦截器
                .addInterceptor(CachingControlInterceptor.REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)
                .cache(cache)
                .addInterceptor(new MyInterceptor()).build();

        Retrofit.Builder builder=new Retrofit.Builder().client(okbuilder).baseUrl(Api_Url);
        private InterfaceService service;

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
            service = builder.build().create(InterfaceService.class);
            retrofitUtils=new SpUtils.RetrofitUtils(service);
            return retrofitUtils;
        }
    }
}
