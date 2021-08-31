package com.cloudwell.paywell.ui.ticket.busticketNew.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialogFragment
import kotlinx.android.synthetic.main.bus_ticket_error_msg_dialog.view.*


class BusErrorMsgDialog(val message: String, val needFinishedActivity: Boolean = false) : BaseDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.bus_ticket_error_msg_dialog, null)

        view.otpErrorMsgTV.text = message
        view.btnOtpErrorCall.setOnClickListener {
            dismiss()
            if (needFinishedActivity) {
                requireActivity().finish()
            }
        }

        isCancelable = false
        return view

    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            dialog.window?.setLayout(width, height)
        }
    }


}