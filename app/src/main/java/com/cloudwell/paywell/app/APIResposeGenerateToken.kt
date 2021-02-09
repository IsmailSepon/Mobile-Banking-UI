package com.cloudwell.paywell.app

import com.google.gson.annotations.SerializedName


class APIResposeGenerateToken {

    @SerializedName("message")
    var message: String = ""
    @SerializedName("status")
    var status: Int = 0
    @SerializedName("token")
    var token: Token? = null

}
