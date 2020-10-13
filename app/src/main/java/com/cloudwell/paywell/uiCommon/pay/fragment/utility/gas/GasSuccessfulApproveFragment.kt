package com.cloudwell.paywell.uiCommon.pay.fragment.utility.gas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.gas_success_approve_layout.view.*

class GasSuccessfulApproveFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.gas_success_approve_layout, container, false)



        view.gas_success_dones.setOnClickListener(View.OnClickListener {
            requireActivity().finish()
        })


        return view
    }


}
