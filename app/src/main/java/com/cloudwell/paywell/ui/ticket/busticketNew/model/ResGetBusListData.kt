package com.cloudwell.paywell.ui.ticket.busticketNew.model

import com.google.gson.annotations.SerializedName


class ResGetBusListData {

    @SerializedName("accessKey")
    var accessKey: String = ""
    @SerializedName("data")
    var data: Data = Data()
    @SerializedName("message")
    var message: String = ""
    @SerializedName("status")
    var status: Int = 0


}
