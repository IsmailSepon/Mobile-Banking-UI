package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.cencel.model

import com.google.gson.annotations.SerializedName

class ResponseDetails {
    @SerializedName("StatusName")
    var statusName: String = ""
    @SerializedName("Status")
    var status: Int = 0

}