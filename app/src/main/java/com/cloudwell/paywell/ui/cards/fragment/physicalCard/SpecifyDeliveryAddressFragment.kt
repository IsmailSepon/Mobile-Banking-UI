package com.cloudwell.paywell.ui.cards.fragment.physicalCard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.specify_delivery_address_layout.view.*

class SpecifyDeliveryAddressFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.specify_delivery_address_layout, container, false)


        view.select_address.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                ConfirmDeliveryAddressFragment(),
                activity?.supportFragmentManager,
                R.id.Cards_container
            )
        })


        view.card_delivery_address_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })


        return view
    }
}

