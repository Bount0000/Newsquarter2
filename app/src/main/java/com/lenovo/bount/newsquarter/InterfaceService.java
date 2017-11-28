package com.lenovo.bount.newsquarter;

import com.lenovo.bount.newsquarter.bean.GetJokeBean;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.bean.Userbean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2017/11/14.
 */

public interface InterfaceService {
    //注册
    @POST("user/reg")
    @FormUrlEncoded
    Observable<ResponsBodyBean> getDate(@FieldMap Map<String,String> map);
    //登录
    @POST("user/login")
    @FormUrlEncoded
    Observable<ResponsBodyBean<Userbean>> getlogin(@FieldMap Map<String,String> map);
    //个人信息
    @POST("user/getUserInfo")
    Observable<ResponsBodyBean<Userbean>> getuser(@Query("uid") String uid,@Query("token") String token);
    //发布段子
    @POST("quarter/publishJoke")
    @FormUrlEncoded
    Observable<ResponsBodyBean> getpublishJoke(@Field("uid") String uid,@Field("content") String content);
    //获取段子
    @POST("quarter/getJokes")
    @FormUrlEncoded
    Observable<GetJokeBean> getJoke(@Field("page") String page);
}
