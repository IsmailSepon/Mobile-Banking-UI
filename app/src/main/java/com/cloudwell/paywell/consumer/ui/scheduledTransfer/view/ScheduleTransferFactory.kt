package com.cloudwell.paywell.consumer.ui.scheduledTransfer.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.consumer.ui.sendMoney.viewmodel.SendMoneyViewModel

class ScheduleTransferFactory(private val repository: ScheduleTransferRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SendMoneyViewModel(
            repository
        ) as T
    }

}