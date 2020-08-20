package com.cloudwell.paywell.ui.BusinessUI.cards.dialog

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.monthly_limits_dialog.view.*


class BusinessCardTerminateDialog : BaseDialog() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.bu_card_terminate_dialog, null)




        return view
    }

}