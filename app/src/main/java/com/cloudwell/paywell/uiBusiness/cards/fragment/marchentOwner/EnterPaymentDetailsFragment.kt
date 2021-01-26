package com.cloudwell.paywell.uiBusiness.cards.fragment.marchentOwner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.marchent_payment_details_layout.view.*

class EnterPaymentDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.marchent_payment_details_layout, container, false)


        view.enter_details_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                MarchentPaymentDoneFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Cards_container
            )

        })


        view.req_link_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }


}
