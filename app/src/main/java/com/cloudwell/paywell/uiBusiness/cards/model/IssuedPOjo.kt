package com.cloudwell.paywell.uiBusiness.cards.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/9/2020.
 */
open class IssuedPOjo {

    @field:SerializedName("name")
    var name: String? = null

    @field:SerializedName("date")
    var date: String? = null

    @field:SerializedName("link")
    var link: String? = null

    @field:SerializedName("profile")
    var profile: String? = null

}