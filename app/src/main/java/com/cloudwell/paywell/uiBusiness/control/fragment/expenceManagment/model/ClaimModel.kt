package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/8/2020.
 */


data class ClaimModel(

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("reportingBy")
    var reportingBy: String? = null,

    @field:SerializedName("accounting")
    var accounting: String? = null
)