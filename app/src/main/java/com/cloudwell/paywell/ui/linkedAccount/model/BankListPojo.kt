package com.cloudwell.paywell.ui.linkedAccount.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/9/2020.
 */
open class BankListPojo {

    @field:SerializedName("name")
    var name : String? = null

    var icon: Int? = null
}