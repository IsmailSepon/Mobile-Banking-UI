package com.cloudwell.paywell.ui.requestMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R

class RequestMoneyDoneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.request_money_done_frg_layout, container, false)


        view.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })

        return view
    }


}
