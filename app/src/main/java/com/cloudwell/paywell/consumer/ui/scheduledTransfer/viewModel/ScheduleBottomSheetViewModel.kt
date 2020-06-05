package com.cloudwell.paywell.consumer.ui.scheduledTransfer.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.ui.scheduledTransfer.view.IscheduleTransferVIew

class ScheduleBottomSheetViewModel : ViewModel() {

    var mView: IscheduleTransferVIew? = null


    fun beneficeryOnclick(view: View) {
        mView?.startBeneficeryChooseFragment()
    }

    fun contactOnclick(view: View) {
        mView?.startContactFragment()
    }


    fun setView(view: IscheduleTransferVIew) {
        this.mView = view
    }

}