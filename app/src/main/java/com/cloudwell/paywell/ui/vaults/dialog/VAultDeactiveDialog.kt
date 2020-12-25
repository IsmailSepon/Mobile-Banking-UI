package com.cloudwell.paywell.ui.vaults.dialog

import android.os.Bundle
import android.view.*
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.uiCommon.pay.fragment.NewContactProfileFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.spare_change_dialog.view.*
import kotlinx.android.synthetic.main.text_dialog.view.*
import kotlinx.android.synthetic.main.text_dialog.view.ok_txt


class VAultDeactiveDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.vault_deactive_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)





        return view
    }

}