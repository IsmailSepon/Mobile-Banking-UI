package com.cloudwell.paywell.ui.beneficiary.view

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.repository.BaseRepository
import com.cloudwell.paywell.retrofit.APIService

class BeneficeryRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db) {
    var type: Int = 0
}
