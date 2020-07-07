package com.cloudwell.paywell.ui.addMoney.viewModel

import android.view.View
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneyBankListVIew

class AddMoneyBankListViewModel : BaseViewModel() {


    var mView: IaddMoneyBankListVIew? = null

    fun bank_list_back_btn(view: View) {
        mView?.bank_list_back_btn()
    }

    fun addmoneyBankListBankOnclick(view: View) {
        mView?.addmoneyBankListBankOnclick()
    }


    fun setView(view: IaddMoneyBankListVIew) {
        this.mView = view
    }
}