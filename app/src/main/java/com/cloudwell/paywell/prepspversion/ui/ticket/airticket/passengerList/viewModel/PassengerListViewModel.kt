package com.cloudwell.paywell.prepspversion.ui.ticket.airticket.passengerList.viewModel

import androidx.lifecycle.MutableLiveData
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.base.newBase.BaseViewState
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.base.newBase.SingleLiveEvent
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.AirTicketBaseViewMode
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails2.model.Passenger
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.passengerList.view.PassengerListViewStatus

class PassengerListViewModel : AirTicketBaseViewMode() {

    var mListMutableLiveDPassengers = MutableLiveData<MutableList<Passenger>>()

    val mViewStatus = SingleLiveEvent<PassengerListViewStatus>()


    fun getAllPassengers() {

        mAirTicketRepository.getAllPassengers().observeForever {
            it.let {
                val toMutableList = it?.toMutableList()
                mListMutableLiveDPassengers.value = toMutableList
            }

        }
    }

    fun deletePassenger(passenger: Passenger) {

        baseViewStatus.value = BaseViewState(isProgressIndicatorShown = true)
        mAirTicketRepository.deletedPassenger(passenger).observeForever({
            baseViewStatus.value = BaseViewState(isProgressIndicatorShown = false)
            if (it != -1) {
                mViewStatus.value = PassengerListViewStatus(isPassengerDeletedSuccessful = true)
            }

        })
    }
}
