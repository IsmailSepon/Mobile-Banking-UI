package com.cloudwell.paywell.ui.ticket.airticket.finalReview.viewModel.view

import com.cloudwell.paywell.ui.ticket.airticket.finalReview.model.ResAirPreBooking
import com.cloudwell.paywell.ui.ticket.airticket.finalReview.model.ResBookingAPI

data class AllSummaryStatus(val noSerachFoundMessage: String, val isShowProcessIndicatior: Boolean, var resAirPreBooking: ResAirPreBooking? = null, var resBookingAPI: ResBookingAPI? = null, var test: String? = null, val RePriceStatus: String? = "") {


}
