package com.cloudwell.paywell.ui.cards.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.ui.sendMoney.viewmodel.SendMoneyViewModel

class CardsFragmentFactory(private val repository: CardsRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SendMoneyViewModel(
            repository
        ) as T
    }

}