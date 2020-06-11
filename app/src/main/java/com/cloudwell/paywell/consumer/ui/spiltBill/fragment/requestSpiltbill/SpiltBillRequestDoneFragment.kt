package com.cloudwell.paywell.consumer.ui.spiltBill.fragment.requestSpiltbill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.spilt_bill_request_layout.view.*

class SpiltBillRequestDoneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.spilt_bill_request_done_layout, container, false)


        view.send_link_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                SpiltBillRequestMessageFragment(),
                activity?.supportFragmentManager,
                R.id.schedule_transfer_container
            )
        })


        return view
    }


}
