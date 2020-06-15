package com.cloudwell.paywell.consumer.ui.requestMoney.fragment.nearMe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper

class NearMeSearchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.near_me_frg_layout, container, false)

        view.inviteFnd_req.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                NearMePeopleListFragment(),
                activity?.supportFragmentManager,
                R.id.request_money_container
            )
        })




        return view
    }


}
