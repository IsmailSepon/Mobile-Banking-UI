package com.cloudwell.paywell.ui.BusinessUI.cards.dialog

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.monthly_limits_dialog.view.*


class MonthlyLimitDialog : BaseDialog() {


    var country = arrayOf("BDT", "USD", "", "+699", "+778")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.monthly_limits_dialog, null)


        view.currency_spinner.onItemSelectedListener
        val aa: ArrayAdapter<Any?> = ArrayAdapter<Any?>(requireActivity().applicationContext, R.layout.spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.currency_spinner.adapter = aa


        return view
    }

}