package com.cloudwell.paywell.ui.authentication.view

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.repository.BaseRepository
import com.cloudwell.paywell.retrofit.APIService

class UserAuthenticationHostRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
}