package com.cloudwell.paywell.uiCommon.pay.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.uiCommon.pay.fragment.NewContactProfileFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.text_dialog.view.*


class TextDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.text_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)


        view.ok_txt.setOnClickListener(View.OnClickListener {

            dismiss()

            FragmentHelper.replaceFragment(
                NewContactProfileFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container

            )
        })
        return view
    }

}