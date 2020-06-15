package com.cloudwell.paywell.consumer.ui.requestMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.request_money_amount_frg_layout.view.*

class RequestMoneyAmountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.request_money_amount_frg_layout, container, false)


        view.request_money_done_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                RequestMoneyDoneFragment(),
                activity?.supportFragmentManager,
                R.id.request_money_container
            )
        })

        return view
    }


}
