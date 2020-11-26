package com.cloudwell.paywell.ui.budget.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/9/2020.
 */
open class BudgetPOjo {

    @field:SerializedName("name")
    var amount : String? = null

    @field:SerializedName("name")
    var month : String? = null

 //   var icon: Int? = null
}