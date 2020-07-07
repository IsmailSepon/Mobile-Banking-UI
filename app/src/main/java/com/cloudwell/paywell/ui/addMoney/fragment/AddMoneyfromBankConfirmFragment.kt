package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.AddMoneyBankconfirmLayoutBinding
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneyBankConfirmVIew
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneyBankConfirmViewModel
import com.cloudwell.paywell.utils.FragmentHelper

class AddMoneyfromBankConfirmFragment : Fragment(), IaddMoneyBankConfirmVIew {

    private lateinit var addMoneyBankConfirmViewModel: AddMoneyBankConfirmViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addMoneyBankConfirmViewModel =
            ViewModelProviders.of(this).get(AddMoneyBankConfirmViewModel::class.java)
        val binding: AddMoneyBankconfirmLayoutBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.add_money_bankconfirm_layout,
            container,
            false
        )
        addMoneyBankConfirmViewModel.setView(this)
        binding.addMoneyBankConfirmxml = addMoneyBankConfirmViewModel
        binding.lifecycleOwner = this


        return binding.root

    }

    override fun bank_confirm() {
        activity?.finish()
    }

    override fun back_back_btn() {
        FragmentHelper.removeFragment(activity?.supportFragmentManager)
    }

    override fun noInternetConnectionFound() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hiddenProgress() {
        TODO("Not yet implemented")
    }

    override fun onFailure(message: String?) {
        TODO("Not yet implemented")
    }


}
