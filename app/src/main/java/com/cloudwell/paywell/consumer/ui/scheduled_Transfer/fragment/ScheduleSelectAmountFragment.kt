package com.cloudwell.paywell.consumer.ui.scheduled_Transfer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.scheduled_Transfer.fragment.bottomsheet.SchedulBottomSheetFragment
import kotlinx.android.synthetic.main.schedule_select_amount_layout.view.*

class ScheduleSelectAmountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_select_amount_layout, container, false)

        view.date_time_txt.setOnClickListener(View.OnClickListener {
            val scheduleBottomSheetFragment =
                SchedulBottomSheetFragment()
            scheduleBottomSheetFragment.show(
                (view.context as AppCompatActivity).supportFragmentManager,
                scheduleBottomSheetFragment.tag
            )

        })


        return view
    }


}
