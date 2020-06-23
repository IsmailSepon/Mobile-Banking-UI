package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.add_card_details_layout.view.*

class AddCardDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_card_details_layout, container, false)

        view.card_details_done_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                AddCardDetailsDoneFragment(),
                activity?.supportFragmentManager,
                R.id.add_money_container
            )
        })


        view.card_detils_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })


        return view
    }


}
