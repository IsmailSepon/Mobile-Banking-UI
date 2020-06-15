package com.cloudwell.paywell.ui.scheduledTransfer.fragment.addNewContact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.scheduledTransfer.fragment.ScheduleSelectAmountFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.schedule_new_contact_layout.view.*

class ScheduleNewContactFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_new_contact_layout, container, false)

        view.done_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                ScheduleSelectAmountFragment(),
                activity?.supportFragmentManager,
                R.id.schedule_transfer_container
            )
        })


        return view
    }


}
