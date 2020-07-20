package com.cloudwell.paywell.ui.requestMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
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


        view.request_money_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })
        return view
    }


}
