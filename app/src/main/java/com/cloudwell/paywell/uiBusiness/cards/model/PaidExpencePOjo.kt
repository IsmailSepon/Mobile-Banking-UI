package com.cloudwell.paywell.uiBusiness.cards.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/9/2020.
 */
open class PaidExpencePOjo {

    @field:SerializedName("name")
    var name: String? = null

    @field:SerializedName("date")
    var date: String? = null

    @field:SerializedName("amount")
    var amount: String? = null

}