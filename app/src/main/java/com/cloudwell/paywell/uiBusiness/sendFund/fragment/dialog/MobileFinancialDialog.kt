package com.cloudwell.paywell.uiBusiness.sendFund.fragment.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.BusinessSendFundConfirmationFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.movile_financial_dialog.view.*

class MobileFinancialDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.movile_financial_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)

        view.confirm_mobile_finc.setOnClickListener(View.OnClickListener {
            dismiss()
            FragmentHelper.replaceFragment(
                BusinessSendFundConfirmationFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )
        })
        return view
    }

}