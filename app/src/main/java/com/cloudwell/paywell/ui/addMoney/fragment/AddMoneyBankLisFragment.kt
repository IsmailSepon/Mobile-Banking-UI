package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.AddMoneyBanklistLayoutBinding
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneyBankListVIew
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneyBankListViewModel
import com.cloudwell.paywell.utils.FragmentHelper

class AddMoneyBankLisFragment : Fragment(), IaddMoneyBankListVIew {


    private lateinit var addMoneyBanklistViewmodel: AddMoneyBankListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addMoneyBanklistViewmodel =
            ViewModelProviders.of(this).get(AddMoneyBankListViewModel::class.java)
        val binding: AddMoneyBanklistLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.add_money_banklist_layout, container, false)
        addMoneyBanklistViewmodel.setView(this)
        binding.addmoneyBanklistxml = addMoneyBanklistViewmodel
        binding.lifecycleOwner = this


        return binding.root

    }

    override fun bank_list_back_btn() {
        FragmentHelper.removeFragment(activity?.supportFragmentManager)
    }

    override fun addmoneyBankListBankOnclick() {
        FragmentHelper.replaceFragment(AddMoneyfromBankConfirmFragment(), activity?.supportFragmentManager, R.id.add_money_container)
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
