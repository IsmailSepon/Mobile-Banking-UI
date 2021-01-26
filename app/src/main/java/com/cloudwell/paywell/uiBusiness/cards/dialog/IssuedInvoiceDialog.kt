package com.cloudwell.paywell.uiBusiness.cards.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.InvoicePayPreviewFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.issued_invoice_dialog.view.*


class IssuedInvoiceDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.issued_invoice_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)


        view.issue_invoice_btn.setOnClickListener(View.OnClickListener {
            dismiss()
            FragmentHelper.replaceFragment(
                InvoicePayPreviewFragment(), requireActivity().supportFragmentManager, R.id.bu_Cards_container
            )

        })

        return view
    }

}