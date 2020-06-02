package com.cloudwell.paywell.consumer.ui.scheduled_Transfer.viewModel

import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.data.repository.BaseRepository
import com.cloudwell.paywell.consumer.ui.scheduled_Transfer.view.IscheduleTransferVIew

class ScheduleTransferViewModel(val repository: BaseRepository) : ViewModel() {

    var mView: IscheduleTransferVIew? = null


    fun setView(view: IscheduleTransferVIew) {
        this.mView = view
    }
}