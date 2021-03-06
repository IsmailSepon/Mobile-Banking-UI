package com.cloudwell.paywell.ui.scheduledTransfer.fragment.addNewContact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.scheduledTransfer.fragment.bottomsheet.SchedulContactBottomSheetFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.schedule_select_contact_layout.view.*

class ScheduleSelectContactFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_select_contact_layout, container, false)


        view.addnewContact.setOnClickListener(View.OnClickListener {
            val bottomsheer = SchedulContactBottomSheetFragment()
            bottomsheer.show(
                (view.context as AppCompatActivity).supportFragmentManager,
                bottomsheer.tag
            )
        })


        view.schedule_trx_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })
        return view
    }


}
