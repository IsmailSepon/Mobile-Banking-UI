package com.cloudwell.paywell.prepspversion.network

import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.RegResponse
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.RegistrationRequest
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.PO

/**
 * Created by MD ISMAIL HOSSAIN SEPON on 07-Jun-21.
 * ismailhossainsepon@gmail.com
 */
interface ApiService {


//    @FormUrlEncoded
//    @POST("signup")
//    suspend fun userSignup(
//        @Field("name") name: String,
//        @Field("email") email: String,
//        @Field("password") password: String
//    ) : Response<RegResponse>


    @POST("register")
    suspend fun userSignup(@Body reg : RegistrationRequest) : Response<ResponseBody>

//    @POST("Recharge/mobileRecharge/bulkTopup")
//    fun callTopAPI(@Body requestTopup: RequestTopup?): Call<TopupReposeData?>?




    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : ApiService{


            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("http://consumerback.paywellonline.com:8080/consumerbackoffice/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}