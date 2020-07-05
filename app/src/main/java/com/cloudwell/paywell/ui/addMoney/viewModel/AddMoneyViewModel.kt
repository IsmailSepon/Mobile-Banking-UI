package com.cloudwell.paywell.ui.addMoney.viewModel

import android.view.View
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneyVIew

class AddMoneyViewModel : BaseViewModel() {


    var mView: IaddMoneyVIew? = null


    fun add_money_submit(view: View) {
        mView?.addMoneySubmit()
    }

    fun type_change(view: View) {
        mView?.type_change()
    }

    fun add_money_back_btn(view: View) {
        mView?.add_money_back_btn()
    }


    fun setView(view: IaddMoneyVIew) {
        this.mView = view
    }
}