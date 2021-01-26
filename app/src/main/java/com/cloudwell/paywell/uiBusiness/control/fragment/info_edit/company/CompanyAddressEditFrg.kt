package com.cloudwell.paywell.uiBusiness.control.fragment.info_edit.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.company_address_layout.view.*


class CompanyAddressEditFrg : Fragment() {

    var country = arrayOf(
        "Town/City",
        "Bangladesh",
        "India",
        "USA",
        "China",
        "Japan"
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.company_address_layout, container, false)


        var country_sp : Spinner = root.findViewById(R.id.company_towncity_sp)

        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireActivity(), R.layout.spinner_item_regular, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        country_sp.adapter = aa


        root.address_save_btn.setOnClickListener(View.OnClickListener {


            FragmentHelper.replaceFragment(
                BusinessDetailsEditFrg(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )


        })


        view?.imageView197?.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return root

    }


}