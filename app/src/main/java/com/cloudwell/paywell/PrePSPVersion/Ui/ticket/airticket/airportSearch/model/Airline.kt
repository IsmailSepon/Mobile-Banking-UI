package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.airportSearch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Airline : Parcelable {

    @SerializedName("AirlineCode")
    var airlineCode = ""
    @SerializedName("AirlineName")
    var airlineName = ""
    @SerializedName("BookingClass")
    var bookingClass = ""
    @SerializedName("CabinClass")
    var cabinClass = ""
    @SerializedName("FlightNumber")
    var flightNumber = ""
    @SerializedName("OperatingCarrier")
    var operatingCarrier = ""

}
