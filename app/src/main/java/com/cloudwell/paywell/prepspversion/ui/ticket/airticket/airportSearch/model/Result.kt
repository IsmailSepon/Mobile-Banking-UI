package com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.model

import android.os.Parcelable
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.airportSearch.model.Fare
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.airportSearch.model.OutputSegment
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(

    @SerializedName("Availabilty")
        var availabilty: Long = 0,

    @SerializedName("Currency")
        var currency: String = "",

    @SerializedName("Discount")
        var discount: Double = 0.0,

    @SerializedName("FareType")
        var fareType: String = "",

    @SerializedName("Fares")
        var fares: List<Fare> = mutableListOf(),

    @SerializedName("IsRefundable")
        var isRefundable: Boolean = false,

//        @SerializedName("LastTicketDate")
//        var lastTicketDate: Any? = null,

    @SerializedName("ResultID")
        var resultID: String = "",

    @SerializedName("segments")
        var segments: List<OutputSegment> = mutableListOf(),

    @SerializedName("TotalFare")
        var totalFare: Long = 0,

    @SerializedName("TotalFareWithAgentMarkup")
        var totalFareWithAgentMarkup: Long = 0,

    @SerializedName("Validatingcarrier")
        var validatingcarrier: String = ""

) : Parcelable
