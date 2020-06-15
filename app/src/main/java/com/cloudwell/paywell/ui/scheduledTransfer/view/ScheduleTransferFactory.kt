package com.cloudwell.paywell.ui.scheduledTransfer.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.ui.sendMoney.viewmodel.SendMoneyViewModel

class ScheduleTransferFactory(private val repository: ScheduleTransferRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SendMoneyViewModel(
            repository
        ) as T
    }

}