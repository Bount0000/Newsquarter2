package com.lenovo.bount.newsquarter;

import com.lenovo.bount.newsquarter.bean.BanbenUpdate;
import com.lenovo.bount.newsquarter.bean.GetJokeBean;
import com.lenovo.bount.newsquarter.bean.GetVideos;
import com.lenovo.bount.newsquarter.bean.Guangao;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.bean.Userbean;
import com.lenovo.bount.newsquarter.bean.Userbean2;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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
    @FormUrlEncoded
    Observable<Userbean2> getuser(@Field("uid") String uid);
    //发布段子
    @POST("quarter/publishJoke")
    @Multipart
    Observable<ResponsBodyBean> getpublishJoke(@Part() List<MultipartBody.Part> jokeFiles);
    //获取段子
    @POST("quarter/getJokes")
    @FormUrlEncoded
    Observable<GetJokeBean> getJoke(@Field("page") int page);

    //版本更新
    @GET("quarter/getVersion")
    Observable<BanbenUpdate> getupdate();
    //广告
    @GET("quarter/getAd")
    Observable<Guangao> getAd();
    //上传头像
    @POST("file/upload")
    @Multipart
    Observable<ResponsBodyBean> getchange(@Part List<MultipartBody.Part> file);
    //修改昵称
    @POST("user/updateNickName")
    @FormUrlEncoded
    Observable<ResponsBodyBean> getnick(@Field("uid") String uid,@Field("nickname") String nickname);
    //关注
    @POST("quarter/follow")
    @FormUrlEncoded
    Observable<ResponsBodyBean> getfollow(@FieldMap Map<String,String> map);

    //获取关注用户列表
    @POST("quarter/getFollowUsers")
    @FormUrlEncoded
    Observable<ResponsBodyBean> getfollowlist(@Field("uid") String uid);
    //获取视频作品列表
    @POST("quarter/getVideos")
    @FormUrlEncoded
    Observable<GetVideos> getVideos(@Field("uid") String uid,@Field("type") String type,@Field("page") int page );
    //发布视频作品
    @POST("quarter/publishVideo")
    @Multipart
    Observable<ResponsBodyBean> getpublishVideos(@Part  List<MultipartBody.Part> videoFile,@Part List<MultipartBody.Part> coverFile);
}
