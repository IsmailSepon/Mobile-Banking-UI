package com.cloudwell.paywell.ui.vaults.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.vaults.dialog.SpareChangeDialog
import com.cloudwell.paywell.ui.vaults.dialog.SuccessDialog
import com.cloudwell.paywell.uiCommon.pay.dialog.TextDialog
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.vault_spare_layout.view.*


class VaultSpareFragmetn : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.vault_spare_layout, container, false)





        view.vault_spare_btn.setOnClickListener(View.OnClickListener {




            FragmentHelper.replaceFragment(
                VaultAddDoneFragmetn(),
                requireActivity().supportFragmentManager,
                R.id.vault_intro_container
            )

        })


        view.spare_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })



// Radio group selection funcation ===================================================
        view.vault_radio_group.check(view.radio1.id)
        view.vault_radio_group.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = group.findViewById<View>(checkedId) as RadioButton
            val isChecked = checkedRadioButton.isChecked
            if (isChecked) {

                Toast.makeText(requireContext(), checkedId.toString(), Toast.LENGTH_SHORT).show()

            }


        })





        view.vault_spare_switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // The toggle is enabledshow
                showSpareDialog()
                Log.e("switch", "ON")

            } else {
                // The toggle is disabled
                Log.e("switch", "OFF")
            }
        })







        return view
    }

    private fun showSpareDialog() {

        val dialog: SpareChangeDialog = SpareChangeDialog()
        dialog.show(activity?.supportFragmentManager!!, "SpareChangeDialog")


    }
}