package com.cloudwell.paywell.consumer.ui.addMoney.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.consumer.ui.sendMoney.viewmodel.SendMoneyViewModel

class AddMoneyFactory(private val repository: AddMoneyRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SendMoneyViewModel(
            repository
        ) as T
    }

}