package com.cloudwell.paywell.prepspversion.ui.registration_Login.repository

import com.cloudwell.paywell.prepspversion.network.ApiService
import com.cloudwell.paywell.prepspversion.network.SafeApiRequest
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.RegResponse
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.RegistrationRequest
import okhttp3.ResponseBody


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

//    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)
//
//    fun getUser() = db.getUserDao().getuser()
}