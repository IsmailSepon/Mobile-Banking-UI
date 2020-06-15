package com.cloudwell.paywell.consumer.ui.requestMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.requestMoney.fragment.nearMe.NearMeSearchFragment
import com.cloudwell.paywell.consumer.utils.FragmentHelper
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


        view.near_me_search.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                NearMeSearchFragment(),
                activity?.supportFragmentManager,
                R.id.request_money_container
            )
        })

        view.creat_link_btn.setOnClickListener(View.OnClickListener {

            val requestMoneyFragment = RequestMoneyFragment()
            val args = Bundle()
            args.putString("activity", "create_link")
            requestMoneyFragment.arguments = args
            FragmentHelper.replaceFragment(
                requestMoneyFragment, activity?.supportFragmentManager, R.id.request_money_container
            )
        })

        return view
    }


}
