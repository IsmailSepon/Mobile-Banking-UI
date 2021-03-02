package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.finalReview.fragment

import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.AirTicketMainActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.finalReview.model.ResAirPreBooking
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.finalReview.model.ResBookingAPI
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.flightDetails1.model.Fare
import com.cloudwell.paywell.data.preferences.AppStorageBox
import kotlinx.android.synthetic.main.fragment_booking_success.view.*


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 4/3/19.
 */

class BookingSuccessDialog : DialogFragment() {
    lateinit var resBookingAPI: ResBookingAPI
    lateinit var bookingDialogListener: BookingDialogListener

    companion object {
        var fare = Fare()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        isCancelable = false

        val v = inflater.inflate(R.layout.fragment_booking_success, container, false)
        resBookingAPI = activity?.applicationContext?.let { AppStorageBox.get(it, AppStorageBox.Key.AIR_BOOKKING) } as ResBookingAPI

        v.tvFare.text = resBookingAPI.bookingID
        v.tvMessage.text = resBookingAPI.message
        v.tvMessageDetails.text = resBookingAPI.messageDetails

        v.tvFare.setOnClickListener {
            val cm = activity?.application?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            cm.setText(v.tvFare.getText())
            Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show()
        }

        v.btBooking.setOnClickListener {
            val intent = Intent(activity, AirTicketMainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }
        return v
    }

    interface BookingDialogListener {
        fun onBooking(resAirPreBooking: ResAirPreBooking)
    }


}
