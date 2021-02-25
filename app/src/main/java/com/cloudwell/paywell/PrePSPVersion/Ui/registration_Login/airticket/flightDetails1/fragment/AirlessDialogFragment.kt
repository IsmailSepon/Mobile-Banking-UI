package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.model.Airline
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.data.preferences.AppStorageBox
import kotlinx.android.synthetic.main.fragment_airless_info.view.*


class AirlessDialogFragment : BaseDialog() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val airline = context?.let { AppStorageBox.get(it, AppStorageBox.Key.Airline_details) } as Airline


        val v = inflater.inflate(R.layout.fragment_airless_info, container, false)
        v.tvAirlineCode.text = airline.airlineCode
        v.tvAirlineName.text = airline.airlineName
        v.tvBookingClass.text = airline.bookingClass
        v.tvCabinClass.text = airline.cabinClass
        v.tvFlightNumber.text = airline.flightNumber
        v.tvOperatingCarrier.text = airline.operatingCarrier

        v.tvOk.setOnClickListener {
            dismiss()
        }

        v.tvCencel.setOnClickListener {
            dismiss()
        }


        return v
    }

}
