package com.cloudwell.paywell.ui.cards.fragment.identityCheck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.confirm_delivery_done_layout.view.*

class ConfirmDeliveryDoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.confirm_delivery_done_layout, container, false)



        view.card_gotit_btn.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })

        return view
    }


}

