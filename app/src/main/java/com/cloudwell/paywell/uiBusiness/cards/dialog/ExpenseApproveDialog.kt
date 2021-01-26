package com.cloudwell.paywell.uiBusiness.cards.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.expense_approve_dialog.view.*


class ExpenseApproveDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.expense_approve_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)


        view.approve_confirm.setOnClickListener(View.OnClickListener {
            dismiss()
        })

        view.approve_cancle.setOnClickListener(View.OnClickListener {
            dismiss()
        })

        return view
    }

}