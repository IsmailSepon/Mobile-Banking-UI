package com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.reject_request_dialog.view.*


class RejectRequestDialog : BaseDialog() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.reject_request_dialog, null)




        this.dialog?.setCanceledOnTouchOutside(true)
        view.textView245.setOnClickListener(View.OnClickListener {

            dialog?.dismiss()
        })
        view.textView246.setOnClickListener(View.OnClickListener {

            dialog?.dismiss()
        })


        return view
    }



}