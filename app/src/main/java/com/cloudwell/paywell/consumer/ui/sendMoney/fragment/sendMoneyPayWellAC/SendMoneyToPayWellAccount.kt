package com.cloudwell.paywell.consumer.ui.sendMoney.fragment.sendMoneyPayWellAC

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cloudwell.paywell.consumer.R

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
