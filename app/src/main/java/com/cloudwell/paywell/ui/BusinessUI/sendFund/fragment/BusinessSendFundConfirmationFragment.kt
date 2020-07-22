package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_send_fund_confirmation_layout.view.*

class BusinessSendFundConfirmationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.business_send_fund_confirmation_layout, container, false)



        view.confirm_continue_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BusinessPaymentDetailsFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )
        })

        return view
    }


}
