package com.cloudwell.paywell.ui.addMoney.factory

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.repository.BaseRepository
import com.cloudwell.paywell.retrofit.APIService

class AddMoneyRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db)
