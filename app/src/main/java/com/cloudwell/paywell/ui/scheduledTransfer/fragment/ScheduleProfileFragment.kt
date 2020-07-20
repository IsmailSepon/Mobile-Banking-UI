package com.cloudwell.paywell.ui.scheduledTransfer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.scheduledTransfer.ProfileRenameFragment
import com.cloudwell.paywell.ui.scheduledTransfer.fragment.dialog.ScheduleActivationDialog
import com.cloudwell.paywell.ui.scheduledTransfer.fragment.dialog.ScheduleDeleteDialog
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.schedule_profile_layout.view.*

class ScheduleProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_profile_layout, container, false)


        view.profile_adjust.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                ScheduleProfileEditFragment(),
                activity?.supportFragmentManager,
                R.id.schedule_transfer_container
            )
        })

        view.deactive.setOnClickListener(View.OnClickListener {
            val dialog: ScheduleActivationDialog = ScheduleActivationDialog()
            activity?.supportFragmentManager?.let { it1 -> dialog.show(it1, "ACtivation") }
        })
        view.sc_profile_delete.setOnClickListener(View.OnClickListener {
            val dialog: ScheduleDeleteDialog = ScheduleDeleteDialog()
            activity?.supportFragmentManager?.let { it1 -> dialog.show(it1, "DELETE") }
        })
        view.profile_rename.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                ProfileRenameFragment(),
                activity?.supportFragmentManager,
                R.id.schedule_transfer_container
            )
        })


        view.active_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })

        return view
    }


}
