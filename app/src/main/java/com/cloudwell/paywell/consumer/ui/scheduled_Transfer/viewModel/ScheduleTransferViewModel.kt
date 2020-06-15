package com.cloudwell.paywell.consumer.ui.scheduled_Transfer.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.data.repository.BaseRepository
import com.cloudwell.paywell.consumer.ui.scheduled_Transfer.view.IscheduleTransferVIew

class ScheduleTransferViewModel(val repository: BaseRepository) : ViewModel() {

    var mView: IscheduleTransferVIew? = null

    fun showBottomsheet(view: View) {

    }

    fun setView(view: IscheduleTransferVIew) {
        this.mView = view
    }
}