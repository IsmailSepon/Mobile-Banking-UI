package com.cloudwell.paywell.uiCommon.pay.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity.ElectricitySuccessfulFragment
import com.cloudwell.paywell.uiCommon.pay.model.UtilityPOjo
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.gson.Gson
import kotlinx.android.synthetic.main.polli_confirm_dialog.view.*


class PolliConfirmDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.polli_confirm_dialog, null)


        val pojo : String = requireArguments().getString("electronics", "")
        val gson = Gson()
        val utility : UtilityPOjo = gson.fromJson(pojo, UtilityPOjo::class.java)

        view.polli_confirm_btn.setOnClickListener(View.OnClickListener {

            dismiss()


            val frag = ElectricitySuccessfulFragment()
            val json = gson.toJson(utility)
            val bundle  = Bundle()
            bundle.putString("electronics", json)
            frag.arguments = bundle

            FragmentHelper.replaceFragment(frag, requireActivity().supportFragmentManager, R.id.payment_container)


        })
        return view
    }

}