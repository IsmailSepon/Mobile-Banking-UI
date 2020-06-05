package com.cloudwell.paywell.consumer.ui.account

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.activity.registation.SignupActivity
import com.cloudwell.paywell.consumer.ui.addMoney.AddMoneyHostActivity
import com.cloudwell.paywell.consumer.ui.scheduledTransfer.SchedulTransferHostActivity
import com.cloudwell.paywell.consumer.ui.sendMoney.SendMoneyHostActivity

class AccountViewModel : ViewModel() {

    fun sendMoney(view: View) {
        Intent(view.context, SendMoneyHostActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun addMoney(view: View) {
        Intent(view.context, AddMoneyHostActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun requestMoney(view: View) {
        Intent(view.context, SignupActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun scheduleTransfer(view: View) {
        Intent(view.context, SchedulTransferHostActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
}