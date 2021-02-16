package com.cloudwell.paywell.ui.profile.view

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.repository.BaseRepository
import com.cloudwell.paywell.retrofit.APIService

class ProfileHostRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
}

