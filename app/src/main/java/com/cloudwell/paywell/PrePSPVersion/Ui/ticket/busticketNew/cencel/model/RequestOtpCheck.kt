package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.cencel.model

import com.google.gson.annotations.SerializedName

class RequestOtpCheck {
    @SerializedName("format")
    var format: String = ""
    @SerializedName("otp")
    var otp: String = ""
    @SerializedName("username")
    var username: String = ""

}