package com.cloudwell.paywell.ui.scheduledTransfer.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.scheduledTransfer.fragment.bottomsheet.SchedulBottomSheetFragment
import com.cloudwell.paywell.ui.scheduledTransfer.fragment.schedule.ScheduleDateSelectionFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.schedule_select_amount_layout.view.*


class ScheduleSelectAmountFragment : Fragment() {


    @RequiresApi(Build.VERSION_CODES.M)
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

        view.reg_top_up_btn.setOnClickListener(View.OnClickListener {

            val fg : ScheduleDateSelectionFragment = ScheduleDateSelectionFragment()
            val bundle = Bundle()
            bundle.putInt("ScheduleDateSelectionFragment", 1)
            fg.arguments  = bundle
            FragmentHelper.replaceFragment(fg, requireActivity().supportFragmentManager, R.id.schedule_transfer_container)
        })


        view.back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })


        return view
    }


}
