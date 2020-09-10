package com.cloudwell.paywell.uiBusiness.cards.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepon on 9/9/2020.
 */
open class CardPOjo {

    @field:SerializedName("name")
    var name: String? = null

//    var imageId = 0
//    @field:SerializedName("name")
    var icon: Int? = null
}