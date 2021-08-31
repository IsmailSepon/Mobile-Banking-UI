package com.cloudwell.paywell.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by MD ISMAIL HOSSAIN SEPON on 13-Jun-21.
 * ismailhossainsepon@gmail.com
 */
object NetClient {

    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder() .addInterceptor(interceptor).build()



        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit
    }



}