package com.cloudwell.paywell.uiBusiness.cards.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog


class StatmentDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.statment_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)

//        dialog!!.getWindow()!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
//       // DialogUtils.setMargins( dialog, 0, 150, 50, 75 );
//        val window: Window = dialog!!.getWindow()!!
//        val wlp: WindowManager.LayoutParams = window.getAttributes()
//
//        wlp.gravity = Gravity.RIGHT
//        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
//        window.setAttributes(wlp)



        return view
    }

}