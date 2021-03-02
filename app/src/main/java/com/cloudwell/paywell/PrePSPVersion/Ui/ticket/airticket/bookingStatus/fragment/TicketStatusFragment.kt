package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.bookingStatus.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.fragment_status_cencelation.view.*


class TicketStatusFragment : DialogFragment() {


    companion object {
        lateinit var message: String
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_status_cencelation, container, false)

        v.tvFree.text = message


        v.btActionIssueTicket.setOnClickListener {
            dismiss()

        }

        return v
    }

    private fun setMargins(view: View, left: Int, top: Int, right: Int, bottom: Int) {
        if (view.layoutParams is ViewGroup.MarginLayoutParams) {
            val p = view.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(left, top, right, bottom)
            view.requestLayout()
        }
    }


}
