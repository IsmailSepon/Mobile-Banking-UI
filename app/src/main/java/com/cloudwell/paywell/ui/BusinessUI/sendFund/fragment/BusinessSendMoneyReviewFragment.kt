package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.dialog.SchedulePaymentDialog
import kotlinx.android.synthetic.main.business_payment_details_layout.view.*
import kotlinx.android.synthetic.main.business_schedule_payment_details_layout.view.*

class BusinessSendMoneyReviewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_sendfund_review_layout, container, false)


        return view
    }


}
