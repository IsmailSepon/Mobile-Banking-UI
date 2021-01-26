package com.cloudwell.paywell.ui.scheduledTransfer.fragment.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.schedule_activation_dialog.view.*

class ScheduleActivationDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.schedule_activation_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)

        view.schedule_cancle_btn.setOnClickListener(View.OnClickListener {

            dialog?.dismiss()
        })

        view.schedule_deactive_btn.setOnClickListener(View.OnClickListener {

            dialog?.dismiss()
        })


//        view.title_txt.text = title
//        view.message.text = message
//        view.submit_button.setOnClickListener(View.OnClickListener {
//            dialog.dismiss()
//        })

        return view
    }

}