package com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.view_card_pin_dialog.view.*


class ViewCardPinDialog : BaseDialog() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.view_card_pin_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)



        view.view_pin_btn.setOnClickListener(View.OnClickListener {
            dismiss()
        })

        return view
    }


}