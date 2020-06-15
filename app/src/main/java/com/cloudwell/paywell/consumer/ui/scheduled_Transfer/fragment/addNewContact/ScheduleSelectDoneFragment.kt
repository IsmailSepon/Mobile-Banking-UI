package com.cloudwell.paywell.consumer.ui.scheduled_Transfer.fragment.addNewContact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.scheduled_Transfer.fragment.bottomsheet.SchedulContactBottomSheetFragment
import kotlinx.android.synthetic.main.schedule_select_contact_layout.view.*

class ScheduleSelectDoneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.schedule_select_done_layout, container, false)


        view.addnewContact.setOnClickListener(View.OnClickListener {
            val bottomsheer = SchedulContactBottomSheetFragment()
            bottomsheer.show(
                (view.context as AppCompatActivity).supportFragmentManager,
                bottomsheer.tag
            )
        })


        return view
    }


}
