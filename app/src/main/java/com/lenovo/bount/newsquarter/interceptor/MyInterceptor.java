package com.lenovo.bount.newsquarter.interceptor;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/11/27.
 */

public class MyInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException
    {
        Request request=chain.request();
        //判断当前的请求
        if(request.method().equals("POST"))
        { //判断当期的请求的Body
            if(request.body()instanceof FormBody)
            {
              FormBody.Builder bobyBuilder=new FormBody.Builder();
                FormBody body= (FormBody) request.body();

                for (int i = 0; i <body.size(); i++) {
                    bobyBuilder.add(body.encodedName(i),body.encodedValue(i));
                }
                body=bobyBuilder.add("token","")
                        .add("source","android")
                        .add("appVersion","")
                        .build();
                request=request.newBuilder().post(body).build();
            }
            }
       return chain.proceed(request);
    }


}
