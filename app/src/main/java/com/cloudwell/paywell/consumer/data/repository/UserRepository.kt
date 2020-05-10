package com.cloudwell.paywell.consumer.data.repository

import com.cloudwell.paywell.consumer.data.db.AppDatabase
import com.cloudwell.paywell.consumer.data.db.entities.User
import com.cloudwell.paywell.consumer.data.network.APIService
import com.cloudwell.paywell.consumer.data.network.SafeApiRequest
import com.cloudwell.paywell.consumer.ui.auth.model.UserLoginResponse

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-03.
 */
class UserRepository(
    private val apiService: APIService,
    private val db: AppDatabase

) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): UserLoginResponse {
        return apiRequest { apiService.userLogin(email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)



}