package com.cloudwell.paywell.ui.budget.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/9/2020.
 */
open class BudgetMachentPOjo {

    @field:SerializedName("name")
    var amount : String? = null

    @field:SerializedName("name")
    var title : String? = null

    @field:SerializedName("name")
    var transcation : String? = null


    @field:SerializedName("name")
    var persentage : String? = null

    var icon: Int? = null
}