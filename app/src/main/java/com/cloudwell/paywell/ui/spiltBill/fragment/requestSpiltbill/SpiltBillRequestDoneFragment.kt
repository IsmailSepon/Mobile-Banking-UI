package com.cloudwell.paywell.ui.spiltBill.fragment.requestSpiltbill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.spilt_bill_request_done_layout.view.*


class SpiltBillRequestDoneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.spilt_bill_request_done_layout, container, false)


        view.request_done.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })


        return view
    }


}
