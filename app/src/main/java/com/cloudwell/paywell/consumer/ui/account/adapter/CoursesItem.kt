package com.cloudwell.paywell.consumer.ui.account.adapter

import com.google.gson.annotations.SerializedName

data class CoursesItem(

    @field:SerializedName("amount")
    var amount: String? = null
)