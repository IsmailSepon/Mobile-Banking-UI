package com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.model.ElectronicsDialogPOjo
import com.google.gson.Gson
import kotlinx.android.synthetic.main.electricity_success_approve_layout.view.*

class ElectricitySuccessfulApproveFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.electricity_success_approve_layout, container, false)

        val pojo : String = requireArguments().getString("electronics", "")
        val gson = Gson()
        val utility : ElectronicsDialogPOjo = gson.fromJson(pojo, ElectronicsDialogPOjo::class.java)

        view.success_mg2.text = utility.typeDetails+" bill payment for"

        view.electricity_success_dones.setOnClickListener(View.OnClickListener {
            requireActivity().finish()
        })


        return view
    }


}
