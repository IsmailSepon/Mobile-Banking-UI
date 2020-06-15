package com.cloudwell.paywell.ui.sendMoney.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.ui.sendMoney.viewmodel.SendMoneyViewModel

class SendMoneyFactory(private val repository: SendMoneyRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SendMoneyViewModel(
            repository
        ) as T
    }

}