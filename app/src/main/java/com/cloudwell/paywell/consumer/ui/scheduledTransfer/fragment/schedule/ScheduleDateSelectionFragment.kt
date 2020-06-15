package com.cloudwell.paywell.consumer.ui.scheduledTransfer.fragment.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.schedule_date_selection_layout.view.*

class ScheduleDateSelectionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_date_selection_layout, container, false)


        view.scheduleDateBtn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                ScheduleSelectDoneFragment(),
                activity?.supportFragmentManager,
                R.id.schedule_transfer_container
            )
        })


        return view
    }


}
