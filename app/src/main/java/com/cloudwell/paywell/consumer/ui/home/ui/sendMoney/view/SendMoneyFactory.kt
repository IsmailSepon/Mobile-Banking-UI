package com.cloudwell.paywell.consumer.ui.home.ui.sendMoney.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.consumer.data.repository.BaseRepository
import com.cloudwell.paywell.consumer.ui.home.ui.sendMoney.SendMoneyRepository
import com.cloudwell.paywell.consumer.ui.home.ui.sendMoney.SendMoneyViewModel

class SendMoneyFactory(private val repository: SendMoneyRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SendMoneyViewModel(repository) as T
    }

}