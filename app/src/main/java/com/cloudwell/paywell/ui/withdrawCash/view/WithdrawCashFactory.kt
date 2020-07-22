package com.cloudwell.paywell.ui.withdrawCash.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.ui.sendMoney.viewmodel.SendMoneyViewModel

class WithdrawCashFactory(private val repository: WithdrawCashRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SendMoneyViewModel(
            repository
        ) as T
    }

}