package com.cloudwell.paywell.data.repository

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.db.entities.User
import com.cloudwell.paywell.data.network.SafeApiRequest
import com.cloudwell.paywell.retrofit.APIService

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-03.
 */
open class BaseRepository(
    val apiService: APIService,
    val db: AppDatabase

) : SafeApiRequest() {

//    suspend fun userLogin(email: String, password: String): UserLoginResponse {
//        return apiRequest { apiService.userLogin(email, password) }
//    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)



}
