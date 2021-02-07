package com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.model

import com.google.gson.annotations.SerializedName


class Data {

    @SerializedName("Error")
    var error: Any? = null
    @SerializedName("Results")
    var results: List<Result> = mutableListOf()
    @SerializedName("SearchId")
    var searchId: String = ""

}
