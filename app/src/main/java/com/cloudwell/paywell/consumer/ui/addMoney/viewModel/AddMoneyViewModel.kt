package com.cloudwell.paywell.consumer.ui.addMoney.viewModel

import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.data.repository.BaseRepository
import com.cloudwell.paywell.consumer.ui.addMoney.view.IaddMoneyVIew

class AddMoneyViewModel(val repository: BaseRepository) : ViewModel() {


    var mView: IaddMoneyVIew? = null


    fun setView(view: IaddMoneyVIew) {
        this.mView = view
    }
}