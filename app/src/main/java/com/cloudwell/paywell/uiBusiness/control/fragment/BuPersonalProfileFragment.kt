package com.cloudwell.paywell.uiBusiness.control.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.adapter.BuCtrlProfilePagerAdapter
import com.google.android.material.tabs.TabLayout


class BuPersonalProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.bu_personal_profile_layout, container, false)

        val sectionsPagerAdapter = BuCtrlProfilePagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager = root.findViewById(R.id.ctrl_profile_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = root.findViewById(R.id.ctrl_profile_tab)
        tabs.setupWithViewPager(viewPager)


        return root

    }
}