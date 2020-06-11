package com.cloudwell.paywell.consumer.ui.account.viewModel

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.ui.addMoney.AddMoneyHostActivity
import com.cloudwell.paywell.consumer.ui.bankTransfer.BankTransferHostActivity
import com.cloudwell.paywell.consumer.ui.registration.SignupActivity
import com.cloudwell.paywell.consumer.ui.requestMoney.RequestMoneyHostActivity
import com.cloudwell.paywell.consumer.ui.scheduledTransfer.SchedulTransferHostActivity
import com.cloudwell.paywell.consumer.ui.sendMoney.SendMoneyHostActivity
import com.cloudwell.paywell.consumer.ui.withdrawCash.CashWithdrawHostActivity

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
        Intent(view.context, RequestMoneyHostActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun scheduleTransfer(view: View) {
        Intent(view.context, SchedulTransferHostActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun cashwithdraw(view: View) {
        Intent(view.context, CashWithdrawHostActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun bankTransfer(view: View) {
        Intent(view.context, BankTransferHostActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun vault(view: View) {
        Intent(view.context, SignupActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
}