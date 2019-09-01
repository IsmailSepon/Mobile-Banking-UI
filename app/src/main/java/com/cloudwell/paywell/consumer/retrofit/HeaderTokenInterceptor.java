package com.cloudwell.paywell.consumer.retrofit;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-05-29.
 */
public class HeaderTokenInterceptor implements Interceptor {

    private Context mContext;

    HeaderTokenInterceptor(Context context) {

        mContext = context;
    }

    public HeaderTokenInterceptor(){


    }


    @NotNull
    @Override
    public Response intercept( Chain chain) throws IOException {

        //String token = AppHandler.getmInstance(mContext).getToken();
        String token = "";
        Request newRequest = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .build();
        return chain.proceed(newRequest);
    }
}

