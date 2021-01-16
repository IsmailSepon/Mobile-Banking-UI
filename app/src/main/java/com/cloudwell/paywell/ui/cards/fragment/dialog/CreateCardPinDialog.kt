package com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.card_pin_dialog.view.*


class CreateCardPinDialog : BaseDialog() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.card_pin_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)



        view.card_pin_done.setOnClickListener(View.OnClickListener {

            dismiss()
        })

        return view
    }


}