package com.cloudwell.paywell.uiCommon.pay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.username_layout.view.*

class PaywellUserNameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.username_layout, container, false)


        view.edit_txt.setOnClickListener(View.OnClickListener {

            FragmentHelper.addFirstFragment(
                EditPaymentProfileFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container
            )

        })


        return view
    }


}
