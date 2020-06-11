package com.cloudwell.paywell.consumer.ui.spiltBill.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.spilt_bill_amount_layout.view.*

class SpiltBillAmountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.spilt_bill_amount_layout, container, false)


        view.spilt_amount_done_btn.setOnClickListener(View.OnClickListener {
//            FragmentHelper.replaceFragment(
//                ScheduleSelectAmountFragment(),
//                activity?.supportFragmentManager,
//                R.id.schedule_transfer_container
//            )
        })


        return view
    }


}
