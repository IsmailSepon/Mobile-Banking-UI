package com.cloudwell.paywell.ui.BusinessUI.control.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.control.adapter.BuControllPagerAdapter
import com.google.android.material.tabs.TabLayout


class BuProfileManageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.bu_manage_profile_layout, container, false)

        val sectionsPagerAdapter = BuControllPagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager = root.findViewById(R.id.controll_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = root.findViewById(R.id.controll_tab)
        tabs.setupWithViewPager(viewPager)


        return root

    }
}