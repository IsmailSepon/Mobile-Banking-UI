package com.cloudwell.paywell.ui.bankTransfer.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.BankBeneficeryLayoutBinding
import com.cloudwell.paywell.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.ui.beneficiary.viewModel.BeneficeryViewModel
import com.cloudwell.paywell.ui.sendMoney.fragment.SendMoneyFragment
import kotlinx.android.synthetic.main.bank_beneficery_layout.view.*

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


        binding.root.beneficery_back_btn.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })
        binding.root.bank_ac_layout.setOnClickListener(View.OnClickListener {


          startActivity(4)
        })




        return binding.root
    }


    fun startActivity(type: Int) {
        val intent = Intent(requireActivity(), BeneficeryHostActivity::class.java)
        intent.putExtra(this.getString(R.string.beneficery_type), type)
        this.startActivity(intent)
    }
}
