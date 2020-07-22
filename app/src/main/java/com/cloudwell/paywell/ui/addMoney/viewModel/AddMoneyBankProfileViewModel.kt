package com.cloudwell.paywell.ui.addMoney.viewModel

import android.view.View
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneyBankProfileVIew

class AddMoneyBankProfileViewModel : BaseViewModel() {


    var mView: IaddMoneyBankProfileVIew? = null

    fun bank_profile_edit(view: View) {
        mView?.bank_profile_edit()
    }

    fun bank_back_btn(view: View) {
        mView?.bank_back_btn()
    }


    fun setView(view: IaddMoneyBankProfileVIew) {
        this.mView = view
    }
}