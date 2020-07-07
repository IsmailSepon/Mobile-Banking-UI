package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.AddMoneyBankprofileLayoutBinding
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneyBankProfileVIew
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneyBankProfileViewModel
import com.cloudwell.paywell.utils.FragmentHelper

class AddMoneyBankProfileFragment : Fragment(), IaddMoneyBankProfileVIew {

    private lateinit var addMoneyBankProfielViewmodel: AddMoneyBankProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addMoneyBankProfielViewmodel =
            ViewModelProviders.of(this).get(AddMoneyBankProfileViewModel::class.java)
        val binding: AddMoneyBankprofileLayoutBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.add_money_bankprofile_layout,
            container,
            false
        )
        addMoneyBankProfielViewmodel.setView(this)
        binding.addmoneyProfilexml = addMoneyBankProfielViewmodel
        binding.lifecycleOwner = this


        return binding.root

    }

    override fun bank_profile_edit() {
        FragmentHelper.replaceFragment(
            AddMoneyAutoTopupFragment(),
            activity?.supportFragmentManager,
            R.id.add_money_container
        )
    }

    override fun bank_back_btn() {
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
