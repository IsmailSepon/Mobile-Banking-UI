package com.cloudwell.paywell.consumer.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.edit_personal_details_second.view.*

class EditPersonalDetailsSecondFragment : Fragment() {

    var countryName = arrayOf("Bangladesh", "India", "Pakistan", "Nepal", "Bhutan")
    var cityName = arrayOf("City", "Town")
    var upazilaName = arrayOf("Dhaka", "Savar", "Narayangonge")
    var districtName = arrayOf("Dhaka", "Barishal", "Ctg")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.edit_personal_details_second, container, false)

        view.spinnerEPD21.onItemSelectedListener
        val aa1: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, cityName)
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.spinnerEPD21.adapter = aa1

        view.spinnerEPD22.onItemSelectedListener
        val aa2: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, upazilaName)
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.spinnerEPD22.adapter = aa2

        view.spinnerEPD23.onItemSelectedListener
        val aa3: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, districtName)
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.spinnerEPD23.adapter = aa3

        view.spinnerEPD24.onItemSelectedListener
        val aa4: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, cityName)
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.spinnerEPD24.adapter = aa4

        view.spinnerEPD25.onItemSelectedListener
        val aa5: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, upazilaName)
        aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.spinnerEPD25.adapter = aa5

        view.spinnerEPD26.onItemSelectedListener
        val aa6: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, districtName)
        aa6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.spinnerEPD26.adapter = aa6

        view.profile_edit_done_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                DetailPersonalProfileFragment(),
                activity?.supportFragmentManager,
                R.id.profile_host_container
            )
        })

        return view
    }

}