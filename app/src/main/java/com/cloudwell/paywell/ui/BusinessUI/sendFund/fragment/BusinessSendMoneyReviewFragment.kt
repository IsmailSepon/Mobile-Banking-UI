package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.dialog.SchedulePaymentDialog
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_payment_details_layout.view.*
import kotlinx.android.synthetic.main.business_schedule_payment_details_layout.view.*
import kotlinx.android.synthetic.main.business_sendfund_review_layout.view.*

class BusinessSendMoneyReviewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_sendfund_review_layout, container, false)


        view.approve_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BusinessTranscationViewFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )

        })
        return view
    }


}
