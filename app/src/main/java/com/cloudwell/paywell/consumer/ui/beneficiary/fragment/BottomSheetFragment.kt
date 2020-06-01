package com.cloudwell.paywell.consumer.ui.beneficiary.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.BenefuceryBottomSheetBinding
import com.cloudwell.paywell.consumer.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.consumer.ui.beneficiary.view.IbeneficeryVIew
import com.cloudwell.paywell.consumer.ui.beneficiary.viewModel.BeneficeryViewModel
import com.cloudwell.paywell.consumer.ui.sendMoney.viewmodel.SendMoneyViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment(), IbeneficeryVIew {

    private var beneficeryViewModel: BeneficeryViewModel? = null
    // private var beneficeryViewModel: SendMoneyViewModel? = null

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
        beneficeryViewModel = ViewModelProviders.of(this).get(BeneficeryViewModel::class.java)
        val binding: BenefuceryBottomSheetBinding =
            DataBindingUtil.inflate(inflater, R.layout.benefucery_bottom_sheet, container, false)
        beneficeryViewModel!!.setView(this)
        binding.bottomsheetModel = beneficeryViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun startBeneficeryHostActivity(i: Int) {
        //Toast.makeText(context, "INTERFACE"+i, Toast.LENGTH_SHORT).show()
        startActivity(i)
    }

    fun startActivity(type: Int) {
        val intent = Intent(context, BeneficeryHostActivity::class.java)
        intent.putExtra(this.getString(R.string.beneficery_type), type)
        this.startActivity(intent)
    }

    override fun noInternetConnectionFound() {
    }

    override fun showProgress() {
    }

    override fun hiddenProgress() {
    }

    override fun onFailure(message: String?) {

    }

}