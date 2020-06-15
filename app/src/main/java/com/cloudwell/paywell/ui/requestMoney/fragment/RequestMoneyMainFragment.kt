package com.cloudwell.paywell.ui.requestMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.request_money_main_frg_layout.view.*

class RequestMoneyMainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.request_money_main_frg_layout, container, false)

        view.item.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                RequestMoneyAmountFragment(),
                activity?.supportFragmentManager,
                R.id.request_money_container
            )
        })


        return view
    }


}
