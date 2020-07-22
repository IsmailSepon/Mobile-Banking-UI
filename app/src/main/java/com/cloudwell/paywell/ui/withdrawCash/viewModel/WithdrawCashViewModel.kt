package com.cloudwell.paywell.ui.withdrawCash.viewModel

import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.data.repository.BaseRepository
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneyVIew

class WithdrawCashViewModel(val repository: BaseRepository) : ViewModel() {


    var mView: IaddMoneyVIew? = null


    fun setView(view: IaddMoneyVIew) {
        this.mView = view
    }
}