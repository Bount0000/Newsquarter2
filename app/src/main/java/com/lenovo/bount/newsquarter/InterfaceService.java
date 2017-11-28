package com.lenovo.bount.newsquarter;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lenovo on 2017/11/14.
 */

public interface InterfaceService {
    //注册
    @POST("user/reg")
    @FormUrlEncoded
    Observable<ResponsBodyBean> getDate(@FieldMap Map<String,String> map);
}
