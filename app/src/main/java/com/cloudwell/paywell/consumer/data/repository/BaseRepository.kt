package com.cloudwell.paywell.consumer.data.repository

import com.cloudwell.paywell.consumer.data.db.AppDatabase
import com.cloudwell.paywell.consumer.data.db.entities.User
import com.cloudwell.paywell.consumer.data.network.APIService
import com.cloudwell.paywell.consumer.data.network.SafeApiRequest

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-03.
 */
open class BaseRepository() : SafeApiRequest() {
    val apiService: APIService? = null
    val db: AppDatabase? = null



//    suspend fun userLogin(email: String, password: String): UserLoginResponse {
//        return apiRequest { apiService.userLogin(email, password) }
//    }

    suspend fun saveUser(user: User) = db?.getUserDao()?.upsert(user)

}
