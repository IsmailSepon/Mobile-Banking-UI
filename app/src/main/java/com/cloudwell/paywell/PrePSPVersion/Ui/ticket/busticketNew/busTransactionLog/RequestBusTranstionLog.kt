package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransactionLog

import com.google.gson.annotations.SerializedName

class RequestBusTranstionLog {
    @SerializedName("channel")
    var channel: String? = null

    @SerializedName("deviceId")
    var deviceId: String? = null

    @SerializedName("limit")
    var limit: String? = null

    @SerializedName("ref_id")
    var refId: String? = null

    @SerializedName("timestamp")
    var timestamp: String? = null

    @SerializedName("username")
    var username: String? = null

    @field:SerializedName("transportType")
    var transportType: String = ""


}