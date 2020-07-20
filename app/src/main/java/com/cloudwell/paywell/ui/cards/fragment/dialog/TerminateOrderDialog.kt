package com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.ui.cards.fragment.identityCheck.ConfirmDeliveryDoneFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.terminate_order_dialog.view.*


class TerminateOrderDialog : BaseDialog() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.terminate_order_dialog, null)


        view.terminate_order_btn.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                ConfirmDeliveryDoneFragment(),
                activity?.supportFragmentManager,
                R.id.Cards_container
            )
            dismiss()
        })


        return view
    }


}