package com.cloudwell.paywell.ui.withdrawCash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.withdrawCash.fragment.CashWithDreawMainFragment
import com.cloudwell.paywell.utils.FragmentHelper

class CashWithdrawHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_withdraw_host)

//        val binding: ActivityAddMoneyHostBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_money_host)
//        val viewModel = ViewModelProviders.of(this).get(AddMoneyViewModel::class.java)
//        viewModel.setView(this)
//        binding.addMoneyViewModel = viewModel

        FragmentHelper.addFirstFragment(
            CashWithDreawMainFragment(),
            supportFragmentManager,
            R.id.cash_withdraw_container
        )


    }
}