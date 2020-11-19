package com.cloudwell.paywell.uiBusiness.cards.fragment.marchentOwner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.marchent_payment_done_layout.view.*

class MarchentPaymentDoneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.marchent_payment_done_layout, container, false)

        view.marchent_payment_done_btn.setOnClickListener(View.OnClickListener {

            activity?.finish()
        })

        return view
    }


}
