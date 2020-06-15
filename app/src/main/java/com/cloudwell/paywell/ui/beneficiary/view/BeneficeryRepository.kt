package com.cloudwell.paywell.ui.beneficiary.view

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.network.APIService
import com.cloudwell.paywell.data.repository.BaseRepository

class BeneficeryRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
    var type: Int = 0
}
