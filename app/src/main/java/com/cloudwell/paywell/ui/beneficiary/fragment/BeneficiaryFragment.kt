package com.cloudwell.paywell.ui.beneficiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.FragmentBeneficiaryBinding
import com.cloudwell.paywell.ui.beneficiary.viewModel.BeneficeryViewModel
import kotlinx.android.synthetic.main.fragment_beneficiary.view.*

class BeneficiaryFragment : Fragment() {

    private lateinit var beneficeryViewModel: BeneficeryViewModel
    //private lateinit var beneficeryViewModel: SendMoneyViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        beneficeryViewModel = ViewModelProviders.of(this).get(BeneficeryViewModel::class.java)
        val binding: FragmentBeneficiaryBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_beneficiary, container, false)
        //beneficeryViewModel.setView(this)
        binding.beneficeryViewModelxml = beneficeryViewModel
        binding.lifecycleOwner = this


        binding.root.beneficery_back_btn.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })

        return binding.root
    }

}
