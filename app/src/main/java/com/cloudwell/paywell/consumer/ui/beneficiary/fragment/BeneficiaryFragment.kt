package com.cloudwell.paywell.consumer.ui.beneficiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.FragmentBeneficiaryBinding
import com.cloudwell.paywell.consumer.ui.beneficiary.viewModel.BeneficeryViewModel
import com.cloudwell.paywell.consumer.ui.sendMoney.view.IsendMoneyVIew
import com.cloudwell.paywell.consumer.ui.sendMoney.viewmodel.SendMoneyViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class BeneficiaryFragment : Fragment() {

    private lateinit var beneficeryViewModel: BeneficeryViewModel
    //private lateinit var beneficeryViewModel: SendMoneyViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        beneficeryViewModel =
            ViewModelProviders.of(this).get(BeneficeryViewModel::class.java)
        val binding: FragmentBeneficiaryBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_beneficiary, container, false)
        binding.beneficeryViewModelxml = beneficeryViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}
