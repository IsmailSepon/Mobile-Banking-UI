package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.airportSearch.model

import android.os.Parcelable
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.airportSearch.model.Airline
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.airportSearch.model.Destination
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.airportSearch.model.Origin
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
class OutputSegment : Parcelable {

    @SerializedName("Airline")
    var airline: Airline? = null
    @SerializedName("Baggage")
    var baggage: String? = null
    @SerializedName("Destination")
    var destination: Destination? = null
    @SerializedName("Equipment")
    var equipment: String? = null
    @SerializedName("JourneyDuration")
    var journeyDuration: String = "0"
    @SerializedName("Origin")
    var origin: Origin? = null

    @SerializedName("TripIndicator")
    var tripIndicator: String? = null


    @SerializedName("StopQuantity")
    var stopQuantity: String? = null


}
