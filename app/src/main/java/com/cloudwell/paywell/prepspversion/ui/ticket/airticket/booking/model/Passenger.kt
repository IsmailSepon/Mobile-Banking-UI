package com.cloudwell.paywell.prepspversion.ui.ticket.airticket.booking.model

import com.google.gson.annotations.SerializedName


class Passenger {

    @SerializedName("address1")
    var address1: Any? = null
    @SerializedName("address2")
    var address2: Any? = null
    @SerializedName("booking_id")
    var bookingId: String? = null
    @SerializedName("contact_number")
    var contactNumber: String? = null
    @SerializedName("country_code")
    var countryCode: String? = null
    @SerializedName("date_of_birth")
    var dateOfBirth: String = ""
    @SerializedName("email")
    var email: String = ""
    @SerializedName("ff_airline")
    var ffAirline: Any? = null
    @SerializedName("ff_number")
    var ffNumber: Any? = null
    @SerializedName("first_name")
    var firstName: String? = null
    @SerializedName("gender")
    var gender: String? = null
    @SerializedName("id")
    var id: String? = null
    @SerializedName("last_name")
    var lastName: String? = null
    @SerializedName("name_title")
    var nameTitle: String? = null
    @SerializedName("nationality")
    var nationality: String? = null
    @SerializedName("passport_expiry_date")
    var passportExpiryDate: String = ""
    @SerializedName("passport_nationality")
    var passportNationality: String = ""
    @SerializedName("passport_number")
    var passportNumber: String = ""
    @SerializedName("pax_index")
    var paxIndex: String? = null
    @SerializedName("pax_type")
    var paxType: String? = null
    @SerializedName("ticket_no")
    var ticketNo: String? = null
    @SerializedName("ticket_url")
    var ticketUrl: Any? = null


    @SerializedName("country")
    var country: String = ""


    var isCheckEmail = false

    var isDefalt = false
        private set

    fun setDefault(defalt: Boolean) {
        isDefalt = defalt
    }

}
