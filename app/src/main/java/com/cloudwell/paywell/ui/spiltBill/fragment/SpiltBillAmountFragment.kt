package com.cloudwell.paywell.ui.spiltBill.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.spiltBill.fragment.requestSpiltbill.SpiltBillRequestFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.spilt_bill_amount_layout.view.*

class SpiltBillAmountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.spilt_bill_amount_layout, container, false)


        view.spilt_amount_done_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                SpiltBillDoneFragment(),
                activity?.supportFragmentManager,
                R.id.spilt_bill_container
            )
        })

        view.constraintLayout15.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                SpiltBillRequestFragment(),
                activity?.supportFragmentManager,
                R.id.spilt_bill_container
            )
        })


        return view
    }


}
