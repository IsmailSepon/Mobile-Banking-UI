package com.cloudwell.paywell.ui.account.viewModel

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.ui.account.view.IaccountVIew
import com.cloudwell.paywell.ui.addMoney.AddMoneyHostActivity
import com.cloudwell.paywell.ui.bankTransfer.BankTransferHostActivity
import com.cloudwell.paywell.ui.registration.SignupActivity
import com.cloudwell.paywell.ui.requestMoney.RequestMoneyHostActivity
import com.cloudwell.paywell.ui.scheduledTransfer.SchedulTransferHostActivity
import com.cloudwell.paywell.ui.sendMoney.SendMoneyHostActivity
import com.cloudwell.paywell.ui.withdrawCash.CashWithdrawHostActivity

class AccountViewModel : ViewModel() {

    var mView: IaccountVIew? = null

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

    fun pending_request(view: View) {
        mView?.startAccountPopupDialog()
    }


    fun setView(view: IaccountVIew) {
        this.mView = view
    }
}