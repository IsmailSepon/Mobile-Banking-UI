package com.cloudwell.paywell.ui.vaults.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.*
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog


class VaultCloseDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.vault_close_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)



        return view
    }



}