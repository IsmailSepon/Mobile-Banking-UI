package com.cloudwell.paywell.ui.BusinessUI.control.fragment.info_edit.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.business_send_new_beneficiry_layout.view.*
import kotlinx.android.synthetic.main.corporation_details_edit_layout.view.*


class CorporationDetailsEdit : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.corporation_details_edit_layout, container, false)


        val country = arrayOf("Bangladesh", "India")

        val sp : Spinner = root.towncity_sp

        sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item_2nd, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = aa

        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

        }




//        root.incorporation_layout.setOnClickListener(View.OnClickListener {
//
//            FragmentHelper.replaceFragment(
//                BuIncorporationDetailsFrg(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Control_container
//            )
//
//        })
//


        return root

    }


}