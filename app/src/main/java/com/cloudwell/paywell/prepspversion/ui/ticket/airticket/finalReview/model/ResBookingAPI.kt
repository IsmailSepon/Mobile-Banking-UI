package com.cloudwell.paywell.prepspversion.ui.ticket.airticket.finalReview.model

import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.model.Data
import com.google.gson.annotations.SerializedName


class ResBookingAPI(var throwable: Throwable) {

    @SerializedName("BookingID")
    var bookingID: String? = null
    @SerializedName("data")
    var data: Data? = null
    @SerializedName("message")
    var message: String? = null
    @SerializedName("message_details")
    var messageDetails: String? = null
    @SerializedName("status")
    var status: Int = 0

}
