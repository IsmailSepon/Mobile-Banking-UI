package com.cloudwell.paywell.ui.scheduledTransfer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.schedule_profile_edit_layout.view.*

class ScheduleProfileEditFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_profile_edit_layout, container, false)

        view.amount.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                ScheduleSelectAmountFragment(),
                activity?.supportFragmentManager,
                R.id.schedule_transfer_container
            )
        })


        view.back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })



        return view
    }


}
