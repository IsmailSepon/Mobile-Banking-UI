package com.cloudwell.paywell.consumer.ui.home.ui.beneficiary

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.choose_transfertype_layout.view.*


class BeneficeryViewModel : ViewModel() {
    fun addBeneficery(view: View) {

        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(
            (view.context as AppCompatActivity).supportFragmentManager,
            bottomSheetFragment.tag
        )
    }

    fun beneficeryBack(view: View) {

    }

    fun addBankAccount(view: View) {
        if (view.getContext() is AppCompatActivity) {
            (view.getContext() as AppCompatActivity).supportFragmentManager
            Toast.makeText(view.context, "paise", Toast.LENGTH_LONG).show()
        }

        Toast.makeText(view.context, "no", Toast.LENGTH_LONG).show()
    }


    fun findPayWellUser(view: View) {}


    fun transferSelectBtn(view: View) {
        val transferType = view.transfertype_radiogroup.checkedRadioButtonId
        Toast.makeText(view.context, "" + transferType, Toast.LENGTH_SHORT).show();
    }

    fun transferTypeRadiobtnSelected(view: View) {}


}