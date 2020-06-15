package com.cloudwell.paywell.consumer.ui.requestMoney.fragment.creat_link

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper

class RequestLinkDoneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.request_link_done_layout, container, false)


        view.request_link_done_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                RequestLinkFinishFragment(),
                activity?.supportFragmentManager,
                R.id.request_money_container
            )
        })


        return view
    }


}
