package com.cloudwell.paywell.ui.ticket.airticket.airportSearch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Origin : Parcelable {

    @SerializedName("Airport")
    var airport: Airport? = null
    @SerializedName("DepTime")
    var depTime: String? = null

}
