package com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog


class ReciveMoneyDialog : BaseDialog(), DatePickerDialog.OnDateSetListener {

    val DATEPICKER_TAG = "datepicker"

    private var dpd: DatePickerDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.recive_money_dialog, null)





        return view
    }


    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {

    }


}