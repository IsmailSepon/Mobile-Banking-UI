package com.cloudwell.paywell.uiCommon.pay.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/9/2020.
 */
open class RecurringBillPOjo {

    @field:SerializedName("name")
    var name: String? = null

    @field:SerializedName("amount")
    var amount: String? = null

    @field:SerializedName("name")
    var number: String? = null

    @field:SerializedName("name")
    var details: String? = null

    var icon: Int? = null
}