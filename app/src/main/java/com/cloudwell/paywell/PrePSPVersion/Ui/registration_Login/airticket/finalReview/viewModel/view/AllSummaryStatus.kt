package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.finalReview.viewModel.view

import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.finalReview.model.ResAirPreBooking
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.finalReview.model.ResBookingAPI

data class AllSummaryStatus(val noSerachFoundMessage: String, val isShowProcessIndicatior: Boolean, var resAirPreBooking: ResAirPreBooking? = null, var resBookingAPI: ResBookingAPI? = null, var test: String? = null, val RePriceStatus: String? = "") {


}
