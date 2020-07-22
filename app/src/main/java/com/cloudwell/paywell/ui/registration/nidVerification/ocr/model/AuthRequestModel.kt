package com.cloudwell.paywell.ui.registration.nidVerification.ocr.model

import com.google.gson.annotations.SerializedName

class AuthRequestModel {
    @SerializedName("appVersionName")
    var appVersionName: String = ""

    @SerializedName("appVersionNo")
    var appVersionNo: String = ""

    @SerializedName("username")
    var username: String = ""

}