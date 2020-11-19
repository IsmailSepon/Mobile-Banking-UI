package com.cloudwell.paywell.uiBusiness.cards.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog.BusinessDeliveryTrackingDialog
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.confirm_delivery_address_layout.view.*

class BuConfirmDeliveryAddressFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.confirm_delivery_address_layout, container, false)


        view.physical_card_address_confirm_btn.setOnClickListener(View.OnClickListener {

            val newFragment: DialogFragment = BusinessDeliveryTrackingDialog()
            newFragment.show(activity?.supportFragmentManager!!, "Date Picker")


        })

        view.confirm_delivery_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })

        return view
    }
}

