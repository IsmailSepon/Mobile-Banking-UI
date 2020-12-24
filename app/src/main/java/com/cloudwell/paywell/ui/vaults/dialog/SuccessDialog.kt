package com.cloudwell.paywell.ui.vaults.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.*
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog


class SuccessDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.success_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)

//        FragmentHelper.replaceFragment(
//            VaultAddDoneFragmetn(),
//            requireActivity().supportFragmentManager,
//            R.id.vault_intro_container
//        )

        setDialogGravity(Gravity.BOTTOM )

        return view
    }

    protected fun setDialogGravity(gravity: Int) {
        val dialog: Dialog? = dialog
        if (dialog != null) {
            val window: Window = dialog.window!!
            val params = window.attributes
            params.width = WindowManager.LayoutParams.MATCH_PARENT
            params.height = WindowManager.LayoutParams.MATCH_PARENT
            params.horizontalMargin = 0f
            params.gravity = gravity
            params.dimAmount = 0f
            params.flags = params.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
            window.attributes = params
        }
    }

}