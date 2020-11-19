package com.cloudwell.paywell.uiBusiness.control.fragment.info_edit.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.bu_details_edit_layout.view.*


class BusinessDetailsEditFrg : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.bu_details_edit_layout, container, false)


//        root.corporation_country_et.setOnClickListener(View.OnClickListener {
//
//            FragmentHelper.replaceFragment(
//                CorporationDetailsEdit(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Control_container
//            )
//
//        })

        var reg = arrayOf("Place of Registration", "City Bank", "Brack Bank")
        var date_reg = arrayOf("Date of Registration", "City Bank", "Brack Bank")
        var employe_num = arrayOf("How many employees you have?", "City Bank", "Brack Bank")
        var monthly_trx = arrayOf("Monthly transactions volume", "City Bank", "Brack Bank")
        var turnover = arrayOf("Yearly Turnover", "City Bank", "Brack Bank")
        val country = arrayOf("Bangladesh", "India")

        val sp : Spinner = root.counrty_sp
        sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item_regular, country
        )
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = aa
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val index: Int = parent!!.getSelectedItemPosition()
                (sp.getSelectedView() as TextView).setTextColor(resources.getColor(R.color.keypad_text_clr))



            }
        }


        val sp1 : Spinner = root.plase_of_registration
        sp1.onItemSelectedListener
        val aa1: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item_regular, reg)
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp1.adapter = aa1
        sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }
        }


        val sp2 : Spinner = root.date_of_Registration
        sp2.onItemSelectedListener
        val aa2: ArrayAdapter<*> = ArrayAdapter<Any?>(
            requireContext(),
            R.layout.spinner_item_regular,
            date_reg
        )
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp2.adapter = aa2
        sp2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {6
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }
        }





        return root

    }


}