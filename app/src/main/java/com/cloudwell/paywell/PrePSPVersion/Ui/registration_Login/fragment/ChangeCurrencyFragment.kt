package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.registration.fragment.RegOneFeg
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.chnage_currency_fragment.view.*

class ChangeCurrencyFragment : Fragment() {

    var currencySp : Spinner? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.chnage_currency_fragment, container, false)


        currencySp = view.pre_country_spinner

        view.pre_currency_btn.setOnClickListener(View.OnClickListener {


            FragmentHelper.addFirstFragment(PreCreatePasswordFrag(), requireActivity().supportFragmentManager, R.id.pre_psp_auth_container)
        })




        val country = arrayOf("USD", "TAKA", "EURO")

        currencySp?.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        currencySp?.adapter = aa
        currencySp?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }

        return view
    }
}