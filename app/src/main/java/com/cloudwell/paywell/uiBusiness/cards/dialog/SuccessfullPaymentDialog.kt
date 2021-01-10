package com.cloudwell.paywell.uiBusiness.cards.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog


class SuccessfullPaymentDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.success_payment_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)


//        view.close_btn.setOnClickListener(View.OnClickListener {
//            dismiss()
//        })

        return view
    }

}