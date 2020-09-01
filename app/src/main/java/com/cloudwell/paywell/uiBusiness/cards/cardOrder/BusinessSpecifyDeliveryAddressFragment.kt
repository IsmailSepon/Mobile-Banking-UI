package com.cloudwell.paywell.uiBusiness.cards.cardOrder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.fragment.BuConfirmDeliveryAddressFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.bu_specify_delivery_address_layout.view.*

class BusinessSpecifyDeliveryAddressFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bu_specify_delivery_address_layout, container, false)


        view.specify_address_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BuConfirmDeliveryAddressFragment(),
                activity?.supportFragmentManager,
                R.id.bu_Cards_container
            )
        })
//
//
//        view.card_delivery_address_back.setOnClickListener(View.OnClickListener {
//            FragmentHelper.removeFragment(activity?.supportFragmentManager)
//        })


        return view
    }
}

