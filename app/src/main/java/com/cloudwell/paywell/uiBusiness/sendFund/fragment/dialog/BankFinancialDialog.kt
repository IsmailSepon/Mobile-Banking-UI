package com.cloudwell.paywell.uiBusiness.sendFund.fragment.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.BusinessSendFundConfirmationFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.bank_financial_dialog.view.*

class BankFinancialDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.bank_financial_dialog, null)


        view.confirm.setOnClickListener(View.OnClickListener {
            dismiss()
            FragmentHelper.replaceFragmentWithString(
               BusinessSendFundConfirmationFragment(),
                //BusinessSendFundwithPhoneContactFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container, "bankBeneficiary"
            )
        })



        return view
    }

}