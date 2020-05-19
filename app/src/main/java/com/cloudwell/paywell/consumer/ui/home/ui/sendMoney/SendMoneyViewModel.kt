package com.cloudwell.paywell.consumer.ui.home.ui.sendMoney

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.home.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.consumer.ui.home.ui.beneficiary.BottomSheetFragment

class SendMoneyViewModel : ViewModel() {
    val bottomSheetFragment = BottomSheetFragment()
    fun addBeneficery(view: View) {
        bottomSheetFragment.show(
            (view.context as AppCompatActivity).supportFragmentManager,
            bottomSheetFragment.tag
        )
    }

    fun beneficeryBack(view: View) {

    }

    fun addBankAccount(view: View) {
        startActivity(view, 1)
    }

    fun findPayWellUser(view: View) {
        startActivity(view, 2)
    }

    fun startActivity(view: View, type: Int) {
        val intent = Intent(view.context, BeneficeryHostActivity::class.java)
        intent.putExtra(view.context.getString(R.string.beneficery_type), type)
        view.context.startActivity(intent)


    }
}