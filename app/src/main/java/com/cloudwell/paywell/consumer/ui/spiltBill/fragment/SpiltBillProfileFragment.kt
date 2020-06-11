package com.cloudwell.paywell.consumer.ui.spiltBill.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.spilt_bill_profile_layout.view.*

class SpiltBillProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.spilt_bill_profile_layout, container, false)


        view.spilt_bill_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                SpiltBillAmountFragment(),
                activity?.supportFragmentManager,
                R.id.schedule_transfer_container
            )
        })


        return view
    }


}
