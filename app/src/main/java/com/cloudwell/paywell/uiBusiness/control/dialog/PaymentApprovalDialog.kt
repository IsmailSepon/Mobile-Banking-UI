package com.cloudwell.paywell.uiBusiness.control.dialog

import android.os.Bundle
import android.view.*
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog


class PaymentApprovalDialog : BaseDialog() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.payment_approval_dialog, null)




        return view
    }

}