package com.cloudwell.paywell.consumer.ui.beneficiary.view

import com.cloudwell.paywell.consumer.data.db.AppDatabase
import com.cloudwell.paywell.consumer.data.network.APIService
import com.cloudwell.paywell.consumer.data.repository.BaseRepository

class BeneficeryRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
    var type: Int = 0
}
