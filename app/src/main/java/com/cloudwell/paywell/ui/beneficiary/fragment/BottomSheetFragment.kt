package com.cloudwell.paywell.ui.beneficiary.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.BenefuceryBottomSheetBinding
import com.cloudwell.paywell.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.ui.beneficiary.view.IbeneficeryVIew
import com.cloudwell.paywell.ui.beneficiary.viewModel.BeneficeryViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment(), IbeneficeryVIew {

    private var beneficeryViewModel: BeneficeryViewModel? = null
    // private var beneficeryViewModel: SendMoneyViewModel? = null

    fun BottomSheetFragment() {}


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


        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        return binding.root
    }

    override fun startBeneficeryHostActivity(i: Int) {
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