package com.cloudwell.paywell.uiCommon.pay.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp.TopupSuccessfulFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.topup_confirm_dialog.view.*


class TopupConfirmDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.topup_confirm_dialog, null)

//
        view.confirm_btn.setOnClickListener(View.OnClickListener {

            dismiss()

            FragmentHelper.replaceFragment(
                TopupSuccessfulFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container

            )

        })
        return view
    }

}