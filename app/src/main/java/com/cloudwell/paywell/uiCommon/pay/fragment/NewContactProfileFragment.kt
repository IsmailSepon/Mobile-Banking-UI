package com.cloudwell.paywell.uiCommon.pay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.newcontact_profile_layout.view.*

class NewContactProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.newcontact_profile_layout, container, false)


//        view.edit_txt.setOnClickListener(View.OnClickListener {
//
//            FragmentHelper.addFirstFragment(
//                EditPaymentProfileFragment(),
//                requireActivity().supportFragmentManager,
//                R.id.payment_container
//            )
//
//        })



        view.contact_profile_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }


}
