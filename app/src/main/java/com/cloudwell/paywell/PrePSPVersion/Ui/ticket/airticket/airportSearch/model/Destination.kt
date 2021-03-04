package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.airportSearch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Destination : Parcelable {

    @SerializedName("Airport")
    var airport: Airport = Airport()
    @SerializedName("ArrTime")
    var arrTime: String = ""

}
