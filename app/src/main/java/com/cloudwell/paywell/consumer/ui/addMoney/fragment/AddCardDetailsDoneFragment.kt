package com.cloudwell.paywell.consumer.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.add_card_details_done_layout.view.*

class AddCardDetailsDoneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_card_details_done_layout, container, false)



        view.gofortopup.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                AddCardTopupDoneFragment(),
                activity?.supportFragmentManager,
                R.id.add_money_container
            )
        })


        return view
    }


}
