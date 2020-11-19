package com.cloudwell.paywell.uiCommon.pay.fragment.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.PayBottomSheetBinding
import com.cloudwell.paywell.uiCommon.pay.fragment.AddnewContactforpayFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.EditPaymentProfileFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.FIndPaywelluserforpayFragment
import com.cloudwell.paywell.uiCommon.view.PayBottomsheetVIew
import com.cloudwell.paywell.uiCommon.viewModel.PayBottomsheetViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PayBottomSheetMenu : BottomSheetDialogFragment(), PayBottomsheetVIew {

    private var PayViewModel: PayBottomsheetViewModel? = null

    fun PayBottomSheetMenu() {}


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PayViewModel = ViewModelProviders.of(this).get(PayBottomsheetViewModel::class.java)
        val binding: PayBottomSheetBinding = DataBindingUtil.inflate(inflater, R.layout.pay_bottom_sheet, container, false)
        PayViewModel!!.setView(this)
        binding.bottomsheetModel = PayViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun startPayMainActivity(i: Int) {
        if(i == 1){
                super.dismiss()
            FragmentHelper.replaceFragment(
                EditPaymentProfileFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container

            )

        }else if (i==2){
            super.dismiss()
            FragmentHelper.replaceFragment(
                FIndPaywelluserforpayFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container
            )

        }else if (i==3){
            super.dismiss()
            FragmentHelper.replaceFragment(
                AddnewContactforpayFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container
            )

        }


    }


    override fun noInternetConnectionFound() {

    }

    override fun showProgress() {
    }

    override fun hiddenProgress() {
    }

    override fun onFailure(message: String?) {
    }

//    override fun startBeneficeryHostActivity(i: Int) {
//        //Toast.makeText(context, "INTERFACE"+i, Toast.LENGTH_SHORT).show()
//        startActivity(i)
//    }
//
//    fun startActivity(type: Int) {
//        val intent = Intent(context, BeneficeryHostActivity::class.java)
//        intent.putExtra(this.getString(R.string.beneficery_type), type)
//        this.startActivity(intent)
//    }
//
//    override fun noInternetConnectionFound() {
//    }
//
//    override fun showProgress() {
//    }
//
//    override fun hiddenProgress() {
//    }
//
//    override fun onFailure(message: String?) {
//
//    }

}