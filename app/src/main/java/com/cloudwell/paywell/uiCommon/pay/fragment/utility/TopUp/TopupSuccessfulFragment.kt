package com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.topup_success_layout.view.*

class TopupSuccessfulFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.topup_success_layout, container, false)


        view.topup_success_done.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                TopupSuccessfulApprovalFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container

            )

        })


        return view
    }


}
