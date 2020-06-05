package com.cloudwell.paywell.consumer.ui.scheduledTransfer.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.scheduledTransfer.fragment.bottomsheet.SchedulBottomSheetFragment
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


//            val dialogView: View = layoutInflater.inflate(R.layout.schedule_bottom_sheet, null)
//            val dialog = activity?.let { it1 -> BottomSheetDialog(it1) }
//            dialog?.setContentView(dialogView)
//            dialog?.show()

        })


        return view
    }


}
