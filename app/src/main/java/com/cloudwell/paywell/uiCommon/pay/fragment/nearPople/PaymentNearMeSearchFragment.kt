package com.cloudwell.paywell.consumer.ui.requestMoney.fragment.nearMe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.near_me_frg_layout.view.*

class PaymentNearMeSearchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.near_me_frg_layout, container, false)


        val textHolder = requireActivity().getSharedPreferences("TextHolder", 0).getInt("nearMeContainer", 0)


        view.inviteFnd_req.setOnClickListener(View.OnClickListener {

            if (textHolder != 0){

                FragmentHelper.replaceFragment(
                    PaymentNearMePeopleListFragment(),
                    activity?.supportFragmentManager,
                    textHolder
                )
            }else{
                FragmentHelper.replaceFragment(
                    NearMePeopleListFragment(),
                    activity?.supportFragmentManager,
                    R.id.request_money_container
                )
            }


        })


        view.near_me_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })


        return view
    }


}
