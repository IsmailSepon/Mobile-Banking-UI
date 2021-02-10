package com.cloudwell.paywell.retrofit

import com.cloudwell.paywell.app.Token
import com.google.gson.annotations.SerializedName

class ResposeAppsAuth {
    @SerializedName("checkOTP")
    var checkOTP: Int = 0
    @SerializedName("envlope")
    var envlope: String = ""
    @SerializedName("message")
    var message: String = ""

    @SerializedName("OTPMessaage")
    var OTPMessaage: String = ""
    @SerializedName("sealedData")
    var sealedData: String = ""
    @SerializedName("status")
    var status: Int = 0
    @SerializedName("token")
    var token: Token = Token()

}