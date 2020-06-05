package com.cloudwell.paywell.consumer.ui.scheduled_Transfer.fragment.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R

class ScheduleDateSelectionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_date_selection_layout, container, false)

//        view.amount.setOnClickListener(View.OnClickListener {
//            FragmentHelper.replaceFragment(
//                ScheduleSelectAmountFragment(),
//                activity?.supportFragmentManager,
//                R.id.schedule_transfer_container
//            )
//        })


        return view
    }


}
