package com.cloudwell.paywell.prepspversion.ui.registration_Login.repository

import android.util.Log
import android.widget.Toast
import com.cloudwell.paywell.prepspversion.network.ApiService
import com.cloudwell.paywell.prepspversion.network.SafeApiRequest
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.RegResponse
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.RegistrationRequest
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.TokenResponse
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.User
import com.cloudwell.paywell.retrofit.ApiUtils
import okhttp3.Callback
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by MD ISMAIL HOSSAIN SEPON on 07-Jun-21.
 * ismailhossainsepon@gmail.com
 */
class UserRepository(private val api: ApiService) : SafeApiRequest(){


//    suspend fun userLogin(email: String, password: String): AuthResponse {
//        return apiRequest { api.userLogin(email, password) }
//    }

    suspend fun userSignup( reg : RegistrationRequest ) : ResponseBody {
        return apiRequest{ api.userSignup(reg)}
    }

//    suspend fun getToken(user : User) : TokenResponse{
//        return apiRequest { api.getRegToken(user) }
//    }


    suspend fun getToken(user : User ): TokenResponse{
      //  ApiUtils.getConsumerAPI().userToken(user).enqueue(object : Callback<TokenResponse>{} )
        var tokenResponse : TokenResponse? = null


        ApiUtils.getConsumerAPI().userToken(user).enqueue(object :
            retrofit2.Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {

                if ( response.isSuccessful ){
                   // Toast.makeText(requireContext(), response.body()?.jwttoken.toString(), Toast.LENGTH_SHORT).show()
                    Log.e("Success", response.body()?.jwttoken.toString())
                     tokenResponse  = response.body()!!

                }else{

                    Log.e("Success", response.body()?.jwttoken.toString())
                   // Toast.makeText(requireContext(), "Not Success!"+response.code() + " / "+ response.body(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
               // Toast.makeText(requireContext(), t.message.toString(), Toast.LENGTH_SHORT).show()
                Log.e("Error", t.message)
            }
        })

        return tokenResponse!!
    }

//    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)
//
//    fun getUser() = db.getUserDao().getuser()
}