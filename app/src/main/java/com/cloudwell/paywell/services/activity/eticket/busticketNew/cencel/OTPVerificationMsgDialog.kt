package com.cloudwell.paywell.services.activity.eticket.busticketNew.cencel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialogFragment
import kotlinx.android.synthetic.main.otp_verification_msg_dialog.view.*

class OTPVerificationMsgDialog(val onClickHandler: OnClickHandler, val  message: String): BaseDialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.otp_verification_msg_dialog, null)
        isCancelable = false
        view.otpOkMsg.setOnClickListener {
            dismiss()
            onClickHandler.onSubmit()

        }

        view.otpVerificationMsgTV.text = ""+message
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    public interface OnClickHandler{

        public fun onSubmit();
    }

}