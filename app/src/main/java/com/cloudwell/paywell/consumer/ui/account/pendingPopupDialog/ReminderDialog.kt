package com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseDialog
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.reminder_dialog.view.*


class ReminderDialog : BaseDialog(), DatePickerDialog.OnDateSetListener {

    val DATEPICKER_TAG = "datepicker"

    private var dpd: DatePickerDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.reminder_dialog, null)



        view.button22.setOnClickListener(View.OnClickListener {


        })


        return view
    }


    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {

    }


}