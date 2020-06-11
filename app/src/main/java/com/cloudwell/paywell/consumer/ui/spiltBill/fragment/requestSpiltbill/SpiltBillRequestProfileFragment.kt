package com.cloudwell.paywell.consumer.ui.spiltBill.fragment.requestSpiltbill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.spiltBill.fragment.SpiltBillProfileFragment
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.spilt_bill_request_profile_layout.view.*

class SpiltBillRequestProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.spilt_bill_request_profile_layout, container, false)

        view.button6.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                SpiltBillProfileFragment(),
                activity?.supportFragmentManager,
                R.id.spilt_bill_container
            )
        })




        return view
    }


}
