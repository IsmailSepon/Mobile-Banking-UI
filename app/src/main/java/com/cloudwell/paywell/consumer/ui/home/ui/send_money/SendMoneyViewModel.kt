package com.cloudwell.paywell.consumer.ui.home.ui.send_money

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.activity.registation.RegistationMainActivity
import com.cloudwell.paywell.consumer.ui.home.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.consumer.ui.home.ui.beneficiary.BottomSheetFragment
import com.cloudwell.paywell.consumer.ui.home.ui.beneficiary.ChooseTransferTypeFragment
import com.cloudwell.paywell.consumer.ui.home.ui.beneficiary.FragmentSetInterface

class SendMoneyViewModel : ViewModel() {
    val bottomSheetFragment = BottomSheetFragment()
    fun addBeneficery(view: View) {
        val fragmentManager = (view.context as FragmentActivity).supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        val fragment = ChooseTransferTypeFragment()
//        fragmentTransaction.add(R.id.send_money_container, fragment)
//        fragmentTransaction.addToBackStack(null)
//        fragmentTransaction.commit()

//        val newFragment = ChooseTransferTypeFragment()  //replace fragment
//        val transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.send_money_container, newFragment)
//        transaction.addToBackStack(null)
//        transaction.commit()

        //val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(
            (view.context as AppCompatActivity).supportFragmentManager,
            bottomSheetFragment.tag
        )
    }

    fun beneficeryBack(view: View) {

    }

    fun addBankAccount(view: View) {

        view.context.startActivity(Intent(view.context, BeneficeryHostActivity::class.java))

    }


    fun findPayWellUser(view: View) {}
}