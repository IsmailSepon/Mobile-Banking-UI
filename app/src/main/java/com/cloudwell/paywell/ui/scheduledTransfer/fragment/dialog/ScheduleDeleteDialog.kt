package com.cloudwell.paywell.ui.scheduledTransfer.fragment.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog

class ScheduleDeleteDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.schedule_delete_dialog, null)

//        view.title_txt.text = title
//        view.message.text = message
//        view.submit_button.setOnClickListener(View.OnClickListener {
//            dialog.dismiss()
//        })

        return view
    }

}