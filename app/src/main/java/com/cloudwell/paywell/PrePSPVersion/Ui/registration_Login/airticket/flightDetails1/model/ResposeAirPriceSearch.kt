package com.cloudwell.paywell.services.activity.eticket.airticket.flightDetails1.model


import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.model.Data
import com.google.gson.annotations.SerializedName


class ResposeAirPriceSearch(var throwable: Throwable) {

    @SerializedName("data")
    var data: Data? = null
    @SerializedName("message")
    var message: String = ""
    @SerializedName("status")
    var status: Int = 0


}
