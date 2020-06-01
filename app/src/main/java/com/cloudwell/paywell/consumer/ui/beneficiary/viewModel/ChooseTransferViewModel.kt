package com.cloudwell.paywell.consumer.ui.beneficiary.viewModel

import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.R

class ChooseTransferViewModel : ViewModel() {

    var select: Int = 1
    fun transferSelectBtn(view: View) {
        // val transferType : RadioGroup = transfertype_radiogroup.checkedRadioButtonId
        Toast.makeText(view.context, "" + select, Toast.LENGTH_SHORT).show();
    }

    fun transferTypeRadiobtnSelected(view: View) {

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radiomyselt ->
                    if (checked) {
                        select = 1
                    }
                R.id.radioanother_person ->
                    if (checked) {
                        select = 2
                    }
                R.id.radio_business ->
                    if (checked) {
                        select = 3
                    }
                R.id.radio_card ->
                    if (checked) {
                        select = 4
                    }
            }
        }
    }


}