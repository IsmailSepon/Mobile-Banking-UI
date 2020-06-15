package com.cloudwell.paywell.services.retrofit


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/29/18.
 */
//object RetrofitClient {
//
//    private var okHttpClient: OkHttpClient? = null
//    private var retrofit: Retrofit? = null
//    private var retrofitPHP7: Retrofit? = null
//
//
//    fun getClient(baseUrl: String): Retrofit? {
//        if (retrofit == null) {
//
//            val okHttpClient = OkHttpClient().newBuilder()
//                    .connectTimeout(60, TimeUnit.SECONDS)
//                    .readTimeout(60, TimeUnit.SECONDS)
//                    .writeTimeout(60, TimeUnit.SECONDS)
//
//
//            if (BuildConfig.DEBUG) {
//                val logging = HttpLoggingInterceptor()
//                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//                okHttpClient.addInterceptor(logging)
////                okHttpClient.addNetworkInterceptor(StethoInterceptor())
//                okHttpClient.addInterceptor(OkHttpProfilerInterceptor())
//
//            }
//
//            val build = okHttpClient.build()
//
//
//            retrofit = Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .addConverterFactory(ScalarsConverterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(build)
//                    .build()
//        }
//        return retrofit
//    }
//
//
//    fun getClientPHP( networkConnectionInterceptor: NetworkConnectionInterceptor, headerTokenInterceptor :HeaderTokenInterceptor, okHttpProfilerInterceptor: OkHttpProfilerInterceptor, baseUrl: String): Retrofit? {
//        if (retrofitPHP7 == null) {
//            val httpClient = OkHttpClient.Builder()
//            httpClient.connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS)
//            httpClient.addInterceptor(networkConnectionInterceptor)
//            httpClient.addInterceptor(headerTokenInterceptor)
//
//            if (BuildConfig.DEBUG) {
//                val logging = HttpLoggingInterceptor()
//                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//                httpClient.addInterceptor(logging)
//                httpClient.addInterceptor(okHttpProfilerInterceptor)
//            }
//            httpClient.authenticator(TokenAuthenticator())
//
//
//            okHttpClient = httpClient.build()
//            retrofitPHP7 = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .addConverterFactory(ScalarsConverterFactory.create())
//                    .build()
//        }
//        return retrofitPHP7
//    }
//
//    fun getClient(): OkHttpClient? {
//        return okHttpClient
//    }
//}
