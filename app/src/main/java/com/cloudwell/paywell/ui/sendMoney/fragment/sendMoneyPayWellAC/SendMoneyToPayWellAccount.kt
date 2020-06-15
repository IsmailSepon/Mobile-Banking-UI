package com.cloudwell.paywell.ui.sendMoney.fragment.sendMoneyPayWellAC

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R

class SendMoneyToPayWellAccount : Fragment() {

    companion object {
        fun newInstance() = SendMoneyToPayWellAccount()
    }

    private lateinit var viewModel: SendMoneyToPayWellAccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.send_money_to_pay_well_account_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SendMoneyToPayWellAccountViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
