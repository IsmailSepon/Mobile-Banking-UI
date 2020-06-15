package com.cloudwell.paywell.consumer.ui.requestMoney.fragment.creat_link

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.request_money_link_info_layout.view.*

class RequestMoneyLinkInfoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.request_money_link_info_layout, container, false)


        view.request_info_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                RequestLinkDoneFragment(),
                activity?.supportFragmentManager,
                R.id.request_money_container
            )
        })


        return view
    }


}
