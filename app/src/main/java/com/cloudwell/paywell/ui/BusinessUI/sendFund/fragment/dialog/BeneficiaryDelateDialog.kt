package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.BusinessSendFundConfirmationFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.bank_financial_dialog.view.*
import kotlinx.android.synthetic.main.bank_financial_dialog.view.confirm
import kotlinx.android.synthetic.main.movile_financial_dialog.view.*

class BeneficiaryDelateDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.beneficiary_delate_dialog, null)


        return view
    }

}