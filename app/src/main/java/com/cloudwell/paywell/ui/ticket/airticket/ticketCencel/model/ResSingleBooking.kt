package com.cloudwell.paywell.ui.ticket.airticket.ticketCencel.model

import com.cloudwell.paywell.ui.ticket.airticket.booking.model.Datum

data class ResSingleBooking(
    val data : List<Datum>,
    val date_today: String,
    val message: String,
    val status: Int
)