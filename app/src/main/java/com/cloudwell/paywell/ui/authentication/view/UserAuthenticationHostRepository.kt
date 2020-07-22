package com.cloudwell.paywell.ui.authentication.view

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.network.APIService
import com.cloudwell.paywell.data.repository.BaseRepository

class UserAuthenticationHostRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
}