package com.cloudwell.paywell.ui.ticket.busticketNew.cencel.model

import com.google.gson.annotations.SerializedName

class ResponseDetails {
    @SerializedName("StatusName")
    var statusName: String = ""
    @SerializedName("Status")
    var status: Int = 0

}