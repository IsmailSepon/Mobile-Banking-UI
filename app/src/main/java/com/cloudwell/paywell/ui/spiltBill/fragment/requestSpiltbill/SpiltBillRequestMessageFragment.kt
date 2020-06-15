package com.cloudwell.paywell.ui.spiltBill.fragment.requestSpiltbill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.spilt_bill_request_message_layout.view.*

class SpiltBillRequestMessageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.spilt_bill_request_message_layout, container, false)

        val value = requireArguments().getString("requestMoney")

        view.send_text.setOnClickListener(View.OnClickListener {


            FragmentHelper.replaceFragment(
                SpiltBillSendMoneyFragment(),
                activity?.supportFragmentManager,
                R.id.spilt_bill_container
            )

        })


        return view
    }


}
