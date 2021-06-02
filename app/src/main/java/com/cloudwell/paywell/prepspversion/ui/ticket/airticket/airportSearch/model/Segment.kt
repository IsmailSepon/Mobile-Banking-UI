package com.cloudwell.paywell.prepspversion.ui.ticket.airticket.airportSearch.model

import com.google.gson.annotations.SerializedName


data class Segment(
        @SerializedName("CabinClass")
        var cabinClass: String = "",
        @SerializedName("DepartureDateTime")
        var departureDateTime: String = "",
        @SerializedName("Destination")
        var destination: String = "",
        @SerializedName("Origin")
        var origin: String = ""
)
