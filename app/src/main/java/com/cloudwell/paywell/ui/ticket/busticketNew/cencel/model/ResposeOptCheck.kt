package com.cloudwell.paywell.ui.ticket.busticketNew.cencel.model

import com.google.gson.annotations.SerializedName

class ResposeOptCheck {
    @SerializedName("ApiStatus")
    val apiStatus: Int = 0
    @SerializedName("ApiStatusName")
    val apiStatusName: String = ""
    @SerializedName("ResponseDetails")
    val responseDetails: ResponseDetails?= null

}