package com.cloudwell.paywell.ui.sendMoney.view

import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.network.APIService
import com.cloudwell.paywell.data.repository.BaseRepository

class SendMoneyRepository(apiService: APIService, db: AppDatabase) :
    BaseRepository(apiService, db)
