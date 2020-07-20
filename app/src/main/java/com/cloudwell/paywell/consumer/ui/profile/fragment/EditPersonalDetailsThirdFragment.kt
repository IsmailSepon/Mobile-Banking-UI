package com.cloudwell.paywell.consumer.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.edit_personal_details_third.*
import kotlinx.android.synthetic.main.edit_personal_details_third.view.*

class EditPersonalDetailsThirdFragment : Fragment() {

    var country = arrayOf("+880", "+9715", "+966", "+699", "+778")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.edit_personal_details_third, container, false)

        view.spinnerEPD31.onItemSelectedListener
        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.spinnerEPD31.adapter = aa

        view.buttonPhnEditDoneEPD3.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                DetailPersonalProfileFragment(),
                activity?.supportFragmentManager,
                R.id.profile_host_container
            )
        })

        return view
    }

}