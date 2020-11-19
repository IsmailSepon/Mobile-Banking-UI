package com.cloudwell.paywell.uiCommon.pay.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/9/2020.
 */
open class PaywellFriendPOjo {

    @field:SerializedName("name")
    var name: String? = null


    @field:SerializedName("mail")
    var mail: String? = null


    @field:SerializedName("profile")
    var profileTxt: String? = null

    var icon: Int? = null


}