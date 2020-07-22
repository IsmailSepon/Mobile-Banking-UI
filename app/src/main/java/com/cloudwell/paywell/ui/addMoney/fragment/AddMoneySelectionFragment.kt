package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.AddMoneySelectionLayoutBinding
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneySelectionVIew
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneySelectionViewModel
import com.cloudwell.paywell.utils.FragmentHelper

class AddMoneySelectionFragment : Fragment(), IaddMoneySelectionVIew {

    private lateinit var addMoneyselectionViewmodel: AddMoneySelectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addMoneyselectionViewmodel =
            ViewModelProviders.of(this).get(AddMoneySelectionViewModel::class.java)
        val binding: AddMoneySelectionLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.add_money_selection_layout, container, false)
        addMoneyselectionViewmodel.setView(this)
        binding.addMoneySelectionxml = addMoneyselectionViewmodel
        binding.lifecycleOwner = this


        return binding.root
    }

    override fun bankList() {
        FragmentHelper.replaceFragment(
            AddMoneyBankLisFragment(),
            activity?.supportFragmentManager,
            R.id.add_money_container
        )
    }

    override fun bankItemOnclick() {
        FragmentHelper.replaceFragment(
            AddMoneyBankProfileFragment(),
            activity?.supportFragmentManager,
            R.id.add_money_container
        )
    }

    override fun addmoneypaywell() {
        FragmentHelper.replaceFragment(
            TransferPaywellAccount(),
            activity?.supportFragmentManager,
            R.id.add_money_container
        )
    }

    override fun bankItem2Onclick() {
        FragmentHelper.replaceFragment(
            AddCardDetailsFragment(),
            activity?.supportFragmentManager,
            R.id.add_money_container
        )
    }

    override fun add_money_selection_back() {
        FragmentHelper.removeFragment(activity?.supportFragmentManager)
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
