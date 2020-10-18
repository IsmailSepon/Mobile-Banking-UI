package com.cloudwell.paywell.uiCommon.pay.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/9/2020.
 */
open class RecurringPOjo {

    @field:SerializedName("name")
    var name: String? = null

    var icon: Int? = null
}