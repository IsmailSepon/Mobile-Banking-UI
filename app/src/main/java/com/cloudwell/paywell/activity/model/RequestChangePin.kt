package com.cloudwell.paywell.activity.model

import com.google.gson.annotations.SerializedName

class RequestChangePin {
    @SerializedName("deviceId")
    var deviceId: String? = null
    @SerializedName("format")
    var format: String? = null
    @SerializedName("new_pin")
    var newPin: String? = null
    @SerializedName("old_pin")
    var oldPin: String? = null
    @SerializedName("timestamp")
    var timestamp: String? = null
    @SerializedName("username")
    var username: String? = null

}