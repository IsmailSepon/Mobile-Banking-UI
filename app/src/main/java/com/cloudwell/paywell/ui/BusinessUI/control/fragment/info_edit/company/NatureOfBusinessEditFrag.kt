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
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.bu_incorporation_layout.view.*
import kotlinx.android.synthetic.main.company_profile_layout.view.*
import kotlinx.android.synthetic.main.nature_of_business_edit_layout.view.*


class NatureOfBusinessEditFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.nature_of_business_edit_layout, container, false)


//        root.corporation_country_et.setOnClickListener(View.OnClickListener {
//
//            FragmentHelper.replaceFragment(
//                CorporationDetailsEdit(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Control_container
//            )
//
//        })

        val country = arrayOf("How many employees you have?", "50", "100")
        val sp : Spinner = root.employe_sp
        sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = aa
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }



        val monthly_trx = arrayOf("Monthly transactions volume", "50", "100")
        val sp2 : Spinner = root.monthly_trx_sp
        sp2.onItemSelectedListener
        val aa2: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, monthly_trx)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp2.adapter = aa2


        val yearly_turnover = arrayOf("Yearly turnover", "50", "100")
        val sp3 : Spinner = root.yearly_turnover_sp
        sp3.onItemSelectedListener
        val aa3: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, yearly_turnover)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp3.adapter = aa3

        return root

    }


}