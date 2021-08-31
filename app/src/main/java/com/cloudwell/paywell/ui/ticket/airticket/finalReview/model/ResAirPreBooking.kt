package com.cloudwell.paywell.ui.ticket.airticket.finalReview.model


import com.cloudwell.paywell.ui.ticket.airticket.flightDetails1.model.Data
import com.google.gson.annotations.SerializedName


class ResAirPreBooking(var throwable: Throwable) {

    @SerializedName("data")
    var data: Data? = null
    @SerializedName("message")
    var message: String? = null
    @SerializedName("status")
    var status: Int = 0

}
