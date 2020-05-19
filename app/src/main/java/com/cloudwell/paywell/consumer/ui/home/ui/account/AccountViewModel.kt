package com.cloudwell.paywell.consumer.ui.home.ui.account

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.activity.registation.RegistationMainActivity
import com.cloudwell.paywell.consumer.ui.home.ui.sendMoney.SendMoneyHostActivity

class AccountViewModel : ViewModel() {

    fun sendMoney(view: View) {
        Intent(view.context, SendMoneyHostActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun addMoney(view: View) {
        Intent(view.context, RegistationMainActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
}