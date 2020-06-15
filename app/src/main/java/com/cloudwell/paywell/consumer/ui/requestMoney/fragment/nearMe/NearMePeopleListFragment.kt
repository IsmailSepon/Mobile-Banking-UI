package com.cloudwell.paywell.consumer.ui.requestMoney.fragment.nearMe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.near_me_people_list_layout.view.*

class NearMePeopleListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.near_me_people_list_layout, container, false)

        view.request_from_nearest_peopleList.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                RequestMoneyFragment(),
                activity?.supportFragmentManager,
                R.id.request_money_container
            )
        })




        return view
    }


}
