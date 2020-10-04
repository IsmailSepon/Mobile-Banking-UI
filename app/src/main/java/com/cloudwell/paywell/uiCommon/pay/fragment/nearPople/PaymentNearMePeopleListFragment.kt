package com.cloudwell.paywell.consumer.ui.requestMoney.fragment.nearMe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.pay_near_me_people_list_layout.view.*

class PaymentNearMePeopleListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.pay_near_me_people_list_layout, container, false)

        view.pay_nearest_peopleList.setOnClickListener(View.OnClickListener {


            FragmentHelper.replaceFragment(
                PaymentSendFundFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container
            )


        })


        view.pay_near_list_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper .removeFragment(activity?.supportFragmentManager)
        })

        view.pay_settings.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                PrivacySettingsFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container
            )



        })


        return view
    }


}
