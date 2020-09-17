package com.cloudwell.paywell.uiBusiness.cards.fragment.manageCustomers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.new_product_layout.view.*

class NewProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.new_product_layout, container, false)


//        view.product_details_gotit_btn.setOnClickListener(View.OnClickListener {
//            FragmentHelper.replaceFragment(
//                BuInvoicePrintFragment(), requireActivity().supportFragmentManager, R.id.bu_Cards_container
//            )
//        })
//
//

        var country = arrayOf("Unit type", "City Bank", "Brack Bank")
        val sp : Spinner = view.unite_type_sp
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




        return view
    }





}