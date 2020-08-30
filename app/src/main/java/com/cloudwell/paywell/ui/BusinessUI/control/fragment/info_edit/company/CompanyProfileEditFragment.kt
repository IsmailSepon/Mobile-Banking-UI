package com.cloudwell.paywell.ui.BusinessUI.control.fragment.info_edit.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.company_profile_edit_layout.view.*


class CompanyProfileEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.company_profile_edit_layout, container, false)


//
        root.company_address_layout.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                CompanyAddressEditFrg(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })





        return root

    }


}