package com.cloudwell.paywell.uiBusiness.sendFund.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_send_fund_phone_contact_layout.view.*


class BusinessSendFundwithPhoneContactFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_send_fund_phone_contact_layout, container, false)


        //val tag : String = arguments.getString()


        view.business_send_money_phone_submit.setOnClickListener(View.OnClickListener {


            FragmentHelper.replaceFragment(
                BusinessSendFundSignUprequestFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )
        })


        return view
    }




}
