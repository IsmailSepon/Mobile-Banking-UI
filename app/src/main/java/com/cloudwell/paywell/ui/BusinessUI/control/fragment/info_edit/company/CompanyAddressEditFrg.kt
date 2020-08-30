package com.cloudwell.paywell.ui.BusinessUI.control.fragment.info_edit.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.cards.fragment.BusinessPhysicalCardFragment
import com.cloudwell.paywell.ui.BusinessUI.control.adapter.BuControllPagerAdapter
import com.cloudwell.paywell.ui.BusinessUI.control.adapter.BuCtrlProfilePagerAdapter
import com.cloudwell.paywell.ui.BusinessUI.control.fragment.info_edit.NewphoneNumberFrg
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.bu_personal_address_edit_layout.view.*
import kotlinx.android.synthetic.main.bu_personal_layout.view.*


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


        var country_sp : Spinner = root!!.findViewById(R.id.company_towncity_sp)

        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireActivity(), R.layout.spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        country_sp.setAdapter(aa)


//        root.address_done_btn.setOnClickListener(View.OnClickListener {
//
//
//            FragmentHelper.replaceFragment(
//                NewphoneNumberFrg(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Control_container
//            )
//
//
//        })



        return root

    }


}