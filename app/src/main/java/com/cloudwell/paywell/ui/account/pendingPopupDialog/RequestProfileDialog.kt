package com.cloudwell.paywell.ui.account.pendingPopupDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.request_profile_dialog.view.*

class RequestProfileDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.request_profile_dialog, null)

        view.remind_btn.setOnClickListener(View.OnClickListener {
            val dialog: ReminderDialog = ReminderDialog()
            activity?.supportFragmentManager?.let { it1 ->
                dialog.show(
                    it1,
                    "ReminderDialog"
                )
            }
            dismiss()

        })

//        view.title_txt.text = title
//        view.message.text = message
//        view.submit_button.setOnClickListener(View.OnClickListener {
//            dialog.dismiss()
//        })

        return view
    }

}