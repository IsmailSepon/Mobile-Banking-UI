package com.cloudwell.paywell.ui.authentication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.user_phn_number_lost_one_fragment.view.*

class UserLostPhnFirstFragment : Fragment() {

    var country = arrayOf("+880", "+9715", "+966", "+699", "+778")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.user_phn_number_lost_one_fragment, container, false)

        view.spinnerUPNL1.onItemSelectedListener
        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.spinnerUPNL1.adapter = aa

        view.buttonUPNL.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                UserLostPhnSecondFragment(),
                activity?.supportFragmentManager,
                R.id.user_auth_host_container
            )
        })

        return view
    }
}