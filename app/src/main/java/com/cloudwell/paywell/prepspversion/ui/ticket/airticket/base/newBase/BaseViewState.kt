package com.cloudwell.paywell.prepspversion.ui.ticket.airticket.base.newBase

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/2/19.
 */

data class BaseViewState(
        val isProgressIndicatorShown: Boolean = false,
        var isNoInternectConnectionFoud: Boolean = false,
        var errorMessage: String = ""
)

