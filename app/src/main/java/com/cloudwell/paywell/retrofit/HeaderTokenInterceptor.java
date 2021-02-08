package com.cloudwell.paywell.retrofit;

import android.content.Context;

import androidx.annotation.NonNull;

import com.cloudwell.paywell.services.app.AppHandler;

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

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        String token = AppHandler.getmInstance(mContext).getToken();
        Request newRequest = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .build();
        return chain.proceed(newRequest);
    }
}

