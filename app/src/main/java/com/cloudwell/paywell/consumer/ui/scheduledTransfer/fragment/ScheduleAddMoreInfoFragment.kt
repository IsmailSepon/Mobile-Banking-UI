package com.cloudwell.paywell.consumer.ui.scheduledTransfer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R

class ScheduleAddMoreInfoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_add_info_layout, container, false)



        return view
    }


}
