package com.cloudwell.paywell.uiCommon.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.uiCommon.view.PayBottomsheetVIew


class PayBottomsheetViewModel : ViewModel() {

    var mView: PayBottomsheetVIew? = null


    fun addBankAccount(view: View) {
        mView?.startPayMainActivity(1)

    }

    fun findPayWellUser(view: View) {
        mView?.startPayMainActivity(2)
    }

    fun addAccount(view: View) {
        mView?.startPayMainActivity(3)
    }


    fun setView(view: PayBottomsheetVIew) {
        this.mView = view
    }

}