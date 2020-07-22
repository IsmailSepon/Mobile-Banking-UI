package com.cloudwell.paywell.ui.addMoney.viewModel

import android.view.View
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneyBankConfirmVIew

class AddMoneyBankConfirmViewModel : BaseViewModel() {


    var mView: IaddMoneyBankConfirmVIew? = null

    fun bank_confirm(view: View) {
        mView?.bank_confirm()
    }

    fun back_back_btn(view: View) {
        mView?.back_back_btn()
    }


    fun setView(view: IaddMoneyBankConfirmVIew) {
        this.mView = view
    }
}