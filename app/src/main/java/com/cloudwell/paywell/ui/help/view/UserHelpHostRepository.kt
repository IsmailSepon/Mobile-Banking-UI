package com.cloudwell.paywell.ui.help.view

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.network.APIService
import com.cloudwell.paywell.data.repository.BaseRepository

class UserHelpHostRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
}
