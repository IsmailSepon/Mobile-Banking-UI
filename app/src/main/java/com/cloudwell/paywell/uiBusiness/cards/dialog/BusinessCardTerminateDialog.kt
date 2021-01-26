package com.cloudwell.paywell.uiBusiness.cards.dialog

import android.os.Bundle
import android.view.*
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.bu_card_terminate_dialog.view.*


class BusinessCardTerminateDialog : BaseDialog() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.bu_card_terminate_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)

        view.yest_txt.setOnClickListener(View.OnClickListener {

            dialog?.dismiss()
        })
        view.no_txt.setOnClickListener(View.OnClickListener {

            dialog?.dismiss()
        })



        return view
    }

}