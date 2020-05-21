package com.cloudwell.paywell.consumer.ui.sendMoney.viewmodel

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.data.repository.BaseRepository
import com.cloudwell.paywell.consumer.ui.beneficiary.fragment.BottomSheetFragment
import com.cloudwell.paywell.consumer.ui.sendMoney.view.IsendMoneyVIew

class SendMoneyViewModel(val repository: BaseRepository) : ViewModel() {

    // var view: IsendMoneyVIew? = null
    var mView: IsendMoneyVIew? = null


    val bottomSheetFragment =
        BottomSheetFragment()
    fun addBeneficery(view: View) {
        bottomSheetFragment.show(
            (view.context as AppCompatActivity).supportFragmentManager,
            bottomSheetFragment.tag
        )
    }

    fun beneficeryBack(view: View) {

    }

    fun addBankAccount(view: View) {
        mView?.startBeneficeryHostActivity(1)

    }

    fun findPayWellUser(view: View) {
        //startActivity(view, 2)
        mView?.startBeneficeryHostActivity(2)
    }


    fun setView(view: IsendMoneyVIew) {
        this.mView = view
    }
}