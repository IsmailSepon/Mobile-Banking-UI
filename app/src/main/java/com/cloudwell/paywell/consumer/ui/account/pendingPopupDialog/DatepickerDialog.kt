package com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseDialog
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog


class DatepickerDialog : BaseDialog(), DatePickerDialog.OnDateSetListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.datepicker_dialog, null)





        return view
    }


    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {

    }


}