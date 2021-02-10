package com.cloudwell.paywell.services.activity.eticket.airticket.finalReview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.fragment_re_prices_status.view.*


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 4/3/19.
 */

class RePriceStatusFragment : DialogFragment() {
    lateinit var bookingDialogListener: BookingDialogListener

    companion object {
        var rePriceStatus = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_re_prices_status, container, false)

        v.tvMessage.setText("" + rePriceStatus)

        v.btBooking.setOnClickListener {
            bookingDialogListener.onClick()
            dismiss()
        }

        return v
    }

    interface BookingDialogListener {
        fun onClick()
    }


}
