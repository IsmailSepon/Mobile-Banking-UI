package com.cloudwell.paywell.uiBusiness.sendFund.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.dialog.SchedulePaymentDialog
import kotlinx.android.synthetic.main.business_schedule_payment_details_layout.view.*

class BusinessSchedulePaymentDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_schedule_payment_details_layout, container, false)

        view.schedule_txt.setOnClickListener(View.OnClickListener {
            val dialog: SchedulePaymentDialog = SchedulePaymentDialog()
            activity?.supportFragmentManager?.let { it1 -> dialog.show(it1, "MobileFinancial") }

        })


        return view
    }


}
