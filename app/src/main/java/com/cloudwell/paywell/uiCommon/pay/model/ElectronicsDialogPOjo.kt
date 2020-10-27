package com.cloudwell.paywell.uiCommon.pay.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/9/2020.
 */
open class ElectronicsDialogPOjo {

    @field:SerializedName("type")
    var type: String? = null
//
//    @field:SerializedName("typeTitle")
//    var typeTitle: String? = null

    @field:SerializedName("typedetails")
    var typeDetails: String? = null


    @field:SerializedName("billNumbertitle")
    var billNumbertitle : String? = null


    @field:SerializedName("billNumber")
    var billNumber : String? = null



    @field:SerializedName("mobileNumber")
    var mobileNumber : String? = null



    @field:SerializedName("Amount")
    var amount : String? = null



    @field:SerializedName("location")
    var location : String? = null



    @field:SerializedName("month")
    var month : String? = null


//    var icon: Int? = null
}