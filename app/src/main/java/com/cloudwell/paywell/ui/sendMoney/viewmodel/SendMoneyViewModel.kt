package com.cloudwell.paywell.ui.sendMoney.viewmodel

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.data.repository.BaseRepository
import com.cloudwell.paywell.ui.beneficiary.fragment.BottomSheetFragment

class SendMoneyViewModel(val repository: BaseRepository) : BaseViewModel() {
    val bottomSheetFragment = BottomSheetFragment()
    val addBankAccountValue = MutableLiveData<Int>()

    fun addBeneficery(view: View) {
        bottomSheetFragment.show(
            (view.context as AppCompatActivity).supportFragmentManager,
            bottomSheetFragment.tag
        )
    }

    fun beneficeryBack(view: View) {

    }

    fun addBankAccount(view: View) {
        addBankAccountValue.value = 1
    }

    fun findPayWellUser(view: View) {
        addBankAccountValue.value = 2
    }


}