package com.cloudwell.paywell.uiCommon.pay.fragment.utility.gas

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.dialog.GasConfirmDialog
import com.cloudwell.paywell.uiCommon.pay.model.UtilityPOjo
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.gson.Gson
import kotlinx.android.synthetic.main.gas_details_layout.view.*
import kotlinx.android.synthetic.main.topup_details_layout.view.operator_ic
import kotlinx.android.synthetic.main.water_details_layout.view.*
import kotlinx.android.synthetic.main.water_details_layout.view.water_details


class GasDetailsFragment : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.gas_details_layout, container, false)

        val pojo : String = requireArguments().getString("gas", "")
        val gson = Gson()

        val utility : UtilityPOjo = gson.fromJson(pojo, UtilityPOjo::class.java)


        view.water_details.text = "Your "+utility.name+" bill details"

        view.operator_ic.setImageResource(utility.icon!!)





        view.set_gas.setOnClickListener(View.OnClickListener {


            val dialog: GasConfirmDialog = GasConfirmDialog()
            dialog.show(activity?.supportFragmentManager!!, "GasConfirmDialog")

        })



        view.gas_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 111) {



        }
    }


}
