package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.TransferPaywellLayoutBinding
import com.cloudwell.paywell.ui.addMoney.view.ItransferPaywellAcVIew
import com.cloudwell.paywell.ui.addMoney.viewModel.TransferPaywellAcViewModel
import com.cloudwell.paywell.utils.FragmentHelper

class TransferPaywellAccount : Fragment(), ItransferPaywellAcVIew {


    private lateinit var transferPaywellAcViewModel: TransferPaywellAcViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        transferPaywellAcViewModel =
            ViewModelProviders.of(this).get(TransferPaywellAcViewModel::class.java)
        val binding: TransferPaywellLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.transfer_paywell_layout, container, false)
        transferPaywellAcViewModel.setView(this)
        binding.transferPaywellAcXml = transferPaywellAcViewModel
        binding.lifecycleOwner = this


        return binding.root

    }

    override fun transfer_back_btn() {
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
