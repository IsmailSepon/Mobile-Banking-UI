package com.cloudwell.paywell.ui.ticket.airticket.flightDetails2.viewmodel

import androidx.lifecycle.MutableLiveData
import com.cloudwell.paywell.ui.ticket.airticket.base.newBase.BaseViewState
import com.cloudwell.paywell.ui.ticket.airticket.AirTicketBaseViewMode
import com.cloudwell.paywell.ui.ticket.airticket.flightDetails2.model.Passenger

class FlightDetails2ViewModel : AirTicketBaseViewMode() {


    var mListMutableLiveDPassengers = MutableLiveData<MutableList<Passenger>>()


    fun getAllPassengers() {

        mAirTicketRepository.getAllPassengers().observeForever {
            it.let {
                val toMutableList = it?.toMutableList()
                toMutableList?.add(Passenger(true))
                mListMutableLiveDPassengers.value = toMutableList
            }

        }
    }

    fun updatePassenger(passenger: Passenger) {
        baseViewStatus.value = BaseViewState(isProgressIndicatorShown = true)
        mAirTicketRepository.updatePassenger(passenger).observeForever({
            baseViewStatus.value = BaseViewState(isProgressIndicatorShown = false)

        })

    }
}
