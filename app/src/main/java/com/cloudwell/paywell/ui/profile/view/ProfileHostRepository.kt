package com.cloudwell.paywell.ui.profile.view

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.network.APIService
import com.cloudwell.paywell.data.repository.BaseRepository

class ProfileHostRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
}

