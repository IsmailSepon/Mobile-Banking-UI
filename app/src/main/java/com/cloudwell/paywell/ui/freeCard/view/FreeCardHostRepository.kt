package com.cloudwell.paywell.ui.freeCard.view

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.network.APIService
import com.cloudwell.paywell.data.repository.BaseRepository

class FreeCardHostRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
}