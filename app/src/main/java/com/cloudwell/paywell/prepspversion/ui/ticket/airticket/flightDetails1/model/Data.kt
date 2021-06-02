package com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.model

import com.google.gson.annotations.SerializedName


class Data {

    @SerializedName("Error")
    var error: Any? = null
    @SerializedName("RePriceStatus")
    var rePriceStatus: String? = null
    @SerializedName("Results")
    var results: List<Result> = mutableListOf()
    @SerializedName("SearchId")
    var searchId: String? = null

}
