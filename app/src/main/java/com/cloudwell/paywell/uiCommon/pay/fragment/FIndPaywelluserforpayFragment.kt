package com.cloudwell.paywell.uiCommon.pay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.consumer.ui.requestMoney.fragment.nearMe.PaymentSendFundFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.find_puserforpay_layout.view.*

class FIndPaywelluserforpayFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.find_puserforpay_layout, container, false)


        view.continueforpay.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                PaymentSendFundFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container
            )

        })


        return view
    }


}
