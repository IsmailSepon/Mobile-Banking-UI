package com.cloudwell.paywell.ui.addMoney.viewModel

import android.view.View
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.ui.addMoney.view.ItransferPaywellAcVIew

class TransferPaywellAcViewModel : BaseViewModel() {


    var mView: ItransferPaywellAcVIew? = null

    fun transfer_back_btn(view: View) {
        mView?.transfer_back_btn()
    }


    fun setView(view: ItransferPaywellAcVIew) {
        this.mView = view
    }
}