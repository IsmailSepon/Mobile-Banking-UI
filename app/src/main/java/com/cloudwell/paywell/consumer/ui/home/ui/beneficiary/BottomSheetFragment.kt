package com.cloudwell.paywell.consumer.ui.home.ui.beneficiary

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.BenefuceryBottomSheetBinding
import com.cloudwell.paywell.consumer.databinding.FragmentBeneficiaryBinding
import com.cloudwell.paywell.consumer.ui.home.ui.send_money.SendMoneyViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    // private var beneficeryViewModel: BeneficeryViewModel? = null
    private var beneficeryViewModel: SendMoneyViewModel? = null

    fun BottomSheetFragment() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        //Code here
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.benefucery_bottom_sheet, container, false)

        beneficeryViewModel =
            ViewModelProviders.of(this).get(SendMoneyViewModel::class.java)
        val binding: BenefuceryBottomSheetBinding =
            DataBindingUtil.inflate(inflater, R.layout.benefucery_bottom_sheet, container, false)
        binding.bottomsheetModel = beneficeryViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}