package com.cloudwell.paywell.consumer.ui.home.ui.sendMoney

import com.cloudwell.paywell.consumer.data.db.AppDatabase
import com.cloudwell.paywell.consumer.data.network.APIService
import com.cloudwell.paywell.consumer.data.repository.BaseRepository

class SendMoneyRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
}
