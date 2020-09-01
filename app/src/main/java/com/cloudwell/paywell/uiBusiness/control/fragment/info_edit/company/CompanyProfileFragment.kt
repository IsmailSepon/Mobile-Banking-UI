package com.cloudwell.paywell.uiBusiness.control.fragment.info_edit.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.company_profile_layout.view.*


class CompanyProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.company_profile_layout, container, false)


        root.incorporation_layout.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                BuIncorporationDetailsFrg(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })
//


        root.nature_of_business_layout.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                NatureOfBusinessFrag(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })

        root.company_profile_et_layout.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                CompanyProfileEditFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )
        })


        root.business_structure_layout.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BusinessStructureFrag(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )
        })



        return root

    }


}