package com.cloudwell.paywell.ui.addMoney.viewModel

import android.view.View
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.ui.addMoney.view.IaddCardDetailsDoneVIew

class AddCardDetailsDoneViewModel : BaseViewModel() {


    var mView: IaddCardDetailsDoneVIew? = null

    fun gofortopup(view: View) {
        mView?.gofortopup()
    }


    fun setView(view: IaddCardDetailsDoneVIew) {
        this.mView = view
    }
}