package com.cloudwell.paywell.ui.scheduledTransfer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.scheduledTransfer.fragment.addNewContact.ScheduleNewContactFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.schedule_selection_layout.view.*

class ScheduleSelectionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_selection_layout, container, false)

        view.contact_layout.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                ScheduleProfileFragment(),
                activity?.supportFragmentManager,
                R.id.schedule_transfer_container
            )
        })

        view.addnewContact.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                ScheduleNewContactFragment(),
                activity?.supportFragmentManager,
                R.id.schedule_transfer_container
            )
        })



        view.back_btn.setOnClickListener(View.OnClickListener {
           activity?.finish()
        })


        return view
    }


}
