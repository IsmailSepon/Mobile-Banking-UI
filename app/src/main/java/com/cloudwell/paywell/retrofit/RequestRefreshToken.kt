package com.cloudwell.paywell.retrofit

import com.google.gson.annotations.SerializedName

class RequestRefreshToken {
    @SerializedName("channel")
    var channel: String = ""
    @SerializedName("deviceId")
    var deviceId: String = ""
    @SerializedName("format")
    var format: String = ""
    @SerializedName("timestamp")
    var timestamp: String = ""
    @SerializedName("username")
    var username: String = ""

}