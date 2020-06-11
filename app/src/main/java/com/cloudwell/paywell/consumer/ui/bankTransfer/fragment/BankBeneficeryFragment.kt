package com.cloudwell.paywell.consumer.ui.bankTransfer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.BankBeneficeryLayoutBinding
import com.cloudwell.paywell.consumer.ui.beneficiary.viewModel.BeneficeryViewModel

class BankBeneficeryFragment : Fragment() {

    private lateinit var beneficeryViewModel: BeneficeryViewModel
    //private lateinit var beneficeryViewModel: SendMoneyViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        beneficeryViewModel = ViewModelProviders.of(this).get(BeneficeryViewModel::class.java)
        val binding: BankBeneficeryLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.bank_beneficery_layout, container, false)
        //beneficeryViewModel.setView(this)
        binding.beneficeryViewModelxml = beneficeryViewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
