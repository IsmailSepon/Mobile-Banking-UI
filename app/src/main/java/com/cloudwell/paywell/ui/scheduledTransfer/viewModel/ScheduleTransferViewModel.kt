package com.cloudwell.paywell.ui.scheduledTransfer.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.data.repository.BaseRepository
import com.cloudwell.paywell.ui.scheduledTransfer.view.IscheduleTransferVIew

class ScheduleTransferViewModel(val repository: BaseRepository) : ViewModel() {

    var mView: IscheduleTransferVIew? = null

    fun showBottomsheet(view: View) {

    }

    fun setView(view: IscheduleTransferVIew) {
        this.mView = view
    }
}