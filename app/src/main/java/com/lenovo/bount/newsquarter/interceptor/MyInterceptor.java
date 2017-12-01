package com.lenovo.bount.newsquarter.interceptor;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.lenovo.bount.newsquarter.App;
import com.lenovo.bount.newsquarter.utils.SpUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/11/27.
 */

public class MyInterceptor implements Interceptor {
    public static String uid;
    public static String token;
    private int versioncode;

    public Response intercept(Interceptor.Chain chain) throws IOException
    {
        SpUtils utils=new SpUtils(App.context,"Login");
         token = utils.getString("token", "");
          uid = utils.getString("uid", "");
        PackageManager manager = App.context.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(App.context.getPackageName(),0);
            versioncode = info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request request=chain.request();
        //判断当前的请求
        if (request.method().equals("POST")){
            //判断当前的请求Boby
            if (request.body() instanceof FormBody){
                //创建一个新的FromBoby
                FormBody.Builder bobyBuilder = new FormBody.Builder();
                //获取原先的boby
                FormBody body = (FormBody) request.body();
                //遍历boby
                for (int i = 0; i < body.size(); i++) {
                    //取出原先boby的数据  存入新的boby里
                    bobyBuilder.add(body.encodedName(i),body.encodedValue(i));
                }
                System.out.println("===token======"+token);
                body=bobyBuilder.addEncoded("token",token)
                        .addEncoded("source","android")
                        .addEncoded("appVersion", String.valueOf(versioncode))
                        .build();
                request=request.newBuilder().post(body).build();
            }
            else
            {
                MultipartBody body= (MultipartBody) request.body();
                MultipartBody.Builder builder=new MultipartBody.Builder().setType(MultipartBody.FORM);
                builder.addFormDataPart("token",token);
                builder.addFormDataPart("source","android");
                builder.addFormDataPart("appVersion",String.valueOf(versioncode));
                List<MultipartBody.Part> parts=body.parts();
                for (MultipartBody.Part part : parts) {
                    builder.addPart(part);
                }
                request=request.newBuilder().post(builder.build()).build();
            }
            }
       return chain.proceed(request);
    }
}
