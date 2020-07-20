package com.cloudwell.paywell.consumer.ui.authentication.view

import com.cloudwell.paywell.consumer.data.db.AppDatabase
import com.cloudwell.paywell.consumer.data.network.APIService
import com.cloudwell.paywell.consumer.data.repository.BaseRepository

class UserAuthenticationHostRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
}