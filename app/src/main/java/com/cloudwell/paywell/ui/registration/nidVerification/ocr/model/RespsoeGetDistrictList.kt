package com.cloudwell.paywell.ui.registration.nidVerification.ocr.model

import com.google.gson.annotations.SerializedName

class RespsoeGetDistrictList {
    @SerializedName("data")
    var data: List<District>? = null

    @SerializedName("message")
    var message: String = ""

    @SerializedName("status")
    var status: Int = 0

}