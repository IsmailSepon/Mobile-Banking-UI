package com.cloudwell.paywell.prepspversion.ui.ticket.airticket.ticketViewer.model

import com.google.gson.annotations.SerializedName


class ResInvoideEmailAPI(var throwable: Throwable) {

    @SerializedName("message")
    var message: String = ""
    @SerializedName("status")
    var status: Int = 0

}
