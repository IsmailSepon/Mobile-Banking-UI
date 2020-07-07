package com.cloudwell.paywell.ui.addMoney.factory

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.network.APIService
import com.cloudwell.paywell.data.repository.BaseRepository

class AddMoneyRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db)
