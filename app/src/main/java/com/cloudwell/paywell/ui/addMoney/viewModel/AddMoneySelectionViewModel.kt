package com.cloudwell.paywell.ui.addMoney.viewModel

import android.view.View
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneySelectionVIew

class AddMoneySelectionViewModel : BaseViewModel() {


    var mView: IaddMoneySelectionVIew? = null


    fun bankList(view: View) {
        mView?.bankList()
    }

    fun bankItemOnclick(view: View) {
        mView?.bankItemOnclick()
    }

    fun addmoneypaywell(view: View) {
        mView?.addmoneypaywell()
    }

    fun bankItem2Onclick(view: View) {
        mView?.bankItem2Onclick()
    }

    fun add_money_selection_back(view: View) {
        mView?.add_money_selection_back()
    }


    fun setView(view: IaddMoneySelectionVIew) {
        this.mView = view
    }
}