package com.cloudwell.paywell.ui.cards.fragment.identityCheck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog.TerminateOrderDialog
import kotlinx.android.synthetic.main.confirm_delivery_layout.view.*

class ConfirmDeliveryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.confirm_delivery_layout, container, false)


        view.yes_continue_btn.setOnClickListener(View.OnClickListener {

            pendindProfilePopup()
        })


        return view
    }

    fun pendindProfilePopup() {

        val newFragment: DialogFragment = TerminateOrderDialog()
        newFragment.show(activity?.supportFragmentManager!!, "TerminateOrderDialog")


    }
}

