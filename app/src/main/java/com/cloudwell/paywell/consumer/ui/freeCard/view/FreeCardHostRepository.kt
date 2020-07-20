package com.cloudwell.paywell.consumer.ui.freeCard.view

import com.cloudwell.paywell.consumer.data.db.AppDatabase
import com.cloudwell.paywell.consumer.data.network.APIService
import com.cloudwell.paywell.consumer.data.repository.BaseRepository

class FreeCardHostRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
}