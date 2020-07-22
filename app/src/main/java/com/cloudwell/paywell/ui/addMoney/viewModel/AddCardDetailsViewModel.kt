package com.cloudwell.paywell.ui.addMoney.viewModel

import android.view.View
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.ui.addMoney.view.IaddCardDetailsVIew

class AddCardDetailsViewModel : BaseViewModel() {


    var mView: IaddCardDetailsVIew? = null

    fun card_details_done_btn(view: View) {
        mView?.card_details_done_btn()
    }

    fun card_detils_back_btn(view: View) {
        mView?.card_detils_back_btn()
    }


    fun setView(view: IaddCardDetailsVIew) {
        this.mView = view
    }
}