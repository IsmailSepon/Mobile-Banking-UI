package com.cloudwell.paywell.uiBusiness.sendFund.fragment.beneficiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_beneficiary_cnfm_code_layout.view.*

class BusinessBeneficiaryCnfmCodeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_beneficiary_cnfm_code_layout, container, false)



        view.benificiary_cnfm_code_btn.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                BusinessBeneficiaryContactListFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )

        })


        return view
    }


}
