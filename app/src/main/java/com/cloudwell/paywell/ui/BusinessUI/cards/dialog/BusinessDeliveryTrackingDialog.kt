package com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.ui.BusinessUI.cards.cardOrder.BusinessCardApwithFingerFragment
import com.cloudwell.paywell.ui.BusinessUI.cards.cardOrder.BusinessOneMoreThingFragment
import com.cloudwell.paywell.ui.cards.fragment.physicalCard.OneMoreThingFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.delivery_tracking_dialog.view.*


class BusinessDeliveryTrackingDialog : BaseDialog() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.delivery_tracking_dialog, null)

        view.terminate_reorder_btn.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                BusinessCardApwithFingerFragment(),
                //BusinessOneMoreThingFragment(),
                activity?.supportFragmentManager,
                R.id.bu_Cards_container
            )
            dismiss()

        })


        return view
    }


}