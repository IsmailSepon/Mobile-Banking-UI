package com.cloudwell.paywell.uiBusiness.cards.dialog

import android.os.Bundle
import android.view.*
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.trx_profile_dialog.view.*


class trxProfileDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.trx_profile_dialog, null)


        view.close_btn.setOnClickListener(View.OnClickListener {
            dismiss()
        })

        return view
    }

}