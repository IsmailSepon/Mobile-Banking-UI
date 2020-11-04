package com.cloudwell.paywell.uiCommon.pay.dialog

import android.os.Bundle
import android.view.*
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog


class ToolTipDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.recurr_tooltip_dialog, null)


        dialog!!.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        // DialogUtils.setMargins( dialog, 0, 150, 50, 75 );
        val window: Window = dialog!!.window!!
        val wlp: WindowManager.LayoutParams = window.attributes

        wlp.gravity = Gravity.RIGHT
        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
        window.attributes = wlp



//        view.ok_txt.setOnClickListener(View.OnClickListener {
//
//            dismiss()
//
//            FragmentHelper.replaceFragment(
//                NewContactProfileFragment(),
//                requireActivity().supportFragmentManager,
//                R.id.payment_container
//
//            )
//        })


        return view
    }

}