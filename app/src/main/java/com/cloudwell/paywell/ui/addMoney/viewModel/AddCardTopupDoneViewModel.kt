package com.cloudwell.paywell.ui.addMoney.viewModel

import android.view.View
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.ui.addMoney.view.IaddCardtopupDoneVIew

class AddCardTopupDoneViewModel : BaseViewModel() {


    var mView: IaddCardtopupDoneVIew? = null

    fun doneonclick(view: View) {
        mView?.doneonclick()
    }


    fun setView(view: IaddCardtopupDoneVIew) {
        this.mView = view
    }
}