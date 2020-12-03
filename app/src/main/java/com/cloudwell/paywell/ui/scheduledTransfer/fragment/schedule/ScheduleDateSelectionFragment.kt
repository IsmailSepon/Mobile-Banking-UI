package com.cloudwell.paywell.ui.scheduledTransfer.fragment.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.vaults.fragment.VaultAddDoneFragmetn
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.schedule_date_selection_layout.view.*


class ScheduleDateSelectionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_date_selection_layout, container, false)


        val tag = requireArguments().getInt("ScheduleDateSelectionFragment")
     //   requireArguments().getInt("ScheduleDateSelectionFragment")

        view.scheduleDateBtn.setOnClickListener(View.OnClickListener {

            if (tag == 1){

                FragmentHelper.replaceFragment(ScheduleSelectDoneFragment(), activity?.supportFragmentManager, R.id.schedule_transfer_container)

            }else if (tag == 2){


                FragmentHelper.replaceFragment(VaultAddDoneFragmetn(), activity?.supportFragmentManager, R.id.vault_intro_container)


            }


        })

        view.date_selection_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })




        //view.transfertype_radiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener())

        view.transfertype_radiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.everyWeek) {
                view.week_days.visibility = View.VISIBLE
            } else if (checkedId == R.id.everyMonth) {
                //do work when radioButton2 is active
                view.week_days.visibility = View.GONE
            }
        })



        return view
    }


}
