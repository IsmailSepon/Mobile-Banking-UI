package com.cloudwell.paywell.consumer.ui.scheduled_Transfer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import com.example.nbtk.slider.ScreenUtils
import com.example.nbtk.slider.SliderAdapter
import com.example.nbtk.slider.SliderLayoutManager
import kotlinx.android.synthetic.main.add_money.*
import kotlinx.android.synthetic.main.add_money.view.*
import kotlinx.android.synthetic.main.add_money_banklist_layout.view.*
import kotlinx.android.synthetic.main.schedule_profile_edit_layout.view.*
import kotlinx.android.synthetic.main.send_money.view.*

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



        return view
    }


}
