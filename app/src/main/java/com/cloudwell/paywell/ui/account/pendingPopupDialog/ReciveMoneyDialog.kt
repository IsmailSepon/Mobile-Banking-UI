package com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.recive_money_dialog.view.*


class ReciveMoneyDialog : BaseDialog() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.recive_money_dialog, null)



        this.dialog?.setCanceledOnTouchOutside(true)
        view.recivemoney_close_btn.setOnClickListener(View.OnClickListener {

            dialog?.dismiss()
        })


        return view
    }


}