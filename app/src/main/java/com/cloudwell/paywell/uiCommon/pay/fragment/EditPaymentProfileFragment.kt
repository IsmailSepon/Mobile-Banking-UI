package com.cloudwell.paywell.uiCommon.pay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.edit_payment_profile_layout.view.*

class EditPaymentProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_payment_profile_layout, container, false)




        view.imageView290.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })
        return view
    }


}
