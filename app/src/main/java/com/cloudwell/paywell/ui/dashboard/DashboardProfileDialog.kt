package com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.ui.profile.ProfileHostActivity
import com.cloudwell.paywell.ui.profile.ProfileHostSecondActivity
import com.cloudwell.paywell.ui.switchAccount.SwitchAccountHostActivity
import kotlinx.android.synthetic.main.card_pin_dialog.view.*
import kotlinx.android.synthetic.main.profile_popup.view.*


class DashboardProfileDialog : BaseDialog() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.profile_popup, null)
        this.dialog?.setCanceledOnTouchOutside(true)

//
//        val manageAcc = dialog.findViewById(R.id.manage_account) as TextView
//        manageAcc.setOnClickListener {
//            dismiss()
//            Intent(context, ProfileHostActivity::class.java).also {
//                startActivity(it)
//            }
//        }
//
//        val upgrdAcc = dialog.findViewById(R.id.textViewPP1) as TextView
//        upgrdAcc.setOnClickListener {
//            dismiss()
//            Intent(context, ProfileHostSecondActivity::class.java).also {
//                startActivity(it)
//            }
//        }
//
//        val switchAcc = dialog.findViewById(R.id.textViewPP2) as TextView
//        switchAcc.setOnClickListener {
//            dismiss()
//            Intent(context, SwitchAccountHostActivity::class.java).also {
//                startActivity(it)
//            }
//        }
//
//        //val signOut = view.findViewById(R.id.textViewPP3) as TextView
//        view.textViewPP3.setOnClickListener {
//            dismiss()
//            showSignOutDialog()
//        }

        return view
    }

    private fun showSignOutDialog() {
        TODO("Not yet implemented")
    }


}