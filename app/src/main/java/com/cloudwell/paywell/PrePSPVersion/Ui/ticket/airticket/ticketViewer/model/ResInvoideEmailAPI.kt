package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.ticketViewer.model

import com.google.gson.annotations.SerializedName


class ResInvoideEmailAPI(var throwable: Throwable) {

    @SerializedName("message")
    var message: String = ""
    @SerializedName("status")
    var status: Int = 0

}
