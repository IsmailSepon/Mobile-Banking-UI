package com.cloudwell.paywell.uiBusiness.control.fragment.info_edit.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.bu_incorporation_layout.view.*


class BuIncorporationDetailsFrg : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.bu_incorporation_layout, container, false)


        root.corporation_country_et.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                CorporationDetailsEdit(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })
//


        root.incorporation_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return root

    }


}