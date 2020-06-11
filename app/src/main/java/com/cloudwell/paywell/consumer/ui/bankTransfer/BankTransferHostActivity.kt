package com.cloudwell.paywell.consumer.ui.bankTransfer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.bankTransfer.fragment.BankBeneficeryFragment
import com.cloudwell.paywell.consumer.utils.FragmentHelper

class BankTransferHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_transfer)


//        val binding: ActivityAddMoneyHostBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_money_host)
//        val viewModel = ViewModelProviders.of(this).get(AddMoneyViewModel::class.java)
//        viewModel.setView(this)
//        binding.addMoneyViewModel = viewModel

        FragmentHelper.replaceFragment(
            BankBeneficeryFragment(),
            supportFragmentManager,
            R.id.bank_transfer_container
        )


    }
}