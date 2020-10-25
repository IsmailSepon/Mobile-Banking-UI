package com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.model.UtilityPOjo
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.gson.Gson
import kotlinx.android.synthetic.main.electricity_success_layout.view.*

class ElectricitySuccessfulFragment : Fragment(){


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.electricity_success_layout, container, false)

        val pojo : String = requireArguments().getString("electronics", "")
        val gson = Gson()
        val utility : UtilityPOjo = gson.fromJson(pojo, UtilityPOjo::class.java)

       // view.profile_ic.setImageResource(utility.icon!!)
        view.success_mg.text = utility.name+" payment of"


        view.electricity_success_done.setOnClickListener(View.OnClickListener {


            val frag = ElectricitySuccessfulApproveFragment()
            val json = gson.toJson(utility)
            val bundle  = Bundle()
            bundle.putString("electronics", json)
            frag.arguments = bundle


            FragmentHelper.replaceFragment(frag, requireActivity().supportFragmentManager, R.id.payment_container)

        })


        return view
    }


}
