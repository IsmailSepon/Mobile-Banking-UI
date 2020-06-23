package com.cloudwell.paywell.ui.scheduledTransfer.fragment.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.schedule_select_done_layout.view.*

class ScheduleSelectDoneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_select_done_layout, container, false)


        view.schedule_trx_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })


        return view
    }


}
