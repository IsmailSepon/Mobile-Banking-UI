package com.cloudwell.paywell.uiCommon.pay.fragment.utility.water

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.electricity_success_approve_layout.view.*

class WasaSuccessfulApproveFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.wasa_success_approve_layout, container, false)



        view.electricity_success_dones.setOnClickListener(View.OnClickListener {
            requireActivity().finish()
        })


        return view
    }


}
