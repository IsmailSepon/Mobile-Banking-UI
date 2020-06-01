package com.cloudwell.paywell.consumer.ui.beneficiary.viewModel

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.ui.beneficiary.fragment.BottomSheetFragment
import com.cloudwell.paywell.consumer.ui.beneficiary.view.IbeneficeryVIew
import com.cloudwell.paywell.consumer.ui.sendMoney.view.IsendMoneyVIew
import kotlinx.android.synthetic.main.choose_transfertype_layout.view.*


class BeneficeryViewModel : ViewModel() {

    var mView: IbeneficeryVIew? = null
    //var mView: IsendMoneyVIew? = null

    fun addBeneficery(view: View) {

        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(
            (view.context as AppCompatActivity).supportFragmentManager,
            bottomSheetFragment.tag
        )
    }

    fun beneficeryBack(view: View) {

    }


    fun transferSelectBtn(view: View) {
        val transferType = view.transfertype_radiogroup.checkedRadioButtonId
        Toast.makeText(view.context, "" + transferType, Toast.LENGTH_SHORT).show();
    }

    fun transferTypeRadiobtnSelected(view: View) {}
    fun getPaywellUser(view: View) {

    }

    fun addBankAccount(view: View) {
        mView?.startBeneficeryHostActivity(1)

    }

    fun findPayWellUser(view: View) {
        //startActivity(view, 2)
        mView?.startBeneficeryHostActivity(2)
    }


    fun setView(view: IbeneficeryVIew) {
        this.mView = view
    }

}