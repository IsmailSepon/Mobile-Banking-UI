package com.cloudwell.paywell.ui.BusinessUI.control.fragment.info_edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.cards.fragment.BusinessPhysicalCardFragment
import com.cloudwell.paywell.ui.BusinessUI.control.adapter.BuControllPagerAdapter
import com.cloudwell.paywell.ui.BusinessUI.control.adapter.BuCtrlProfilePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.bu_personal_layout.view.*


class PersonalDetailsOneEditFrg : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.bu_personal_details_edit_layout, container, false)





        return root

    }


}