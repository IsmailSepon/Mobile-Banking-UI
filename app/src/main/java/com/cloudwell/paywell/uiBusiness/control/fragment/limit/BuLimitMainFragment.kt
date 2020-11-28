package com.cloudwell.paywell.uiBusiness.control.fragment.limit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.adapter.AllowedLimitAdapter
import com.cloudwell.paywell.uiBusiness.control.adapter.DailyMonthlyLimitAdapter
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.limit_main_layout.view.*


class BuLimitMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.limit_main_layout, container, false)

        val sectionsPagerAdapter = DailyMonthlyLimitAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager = root.findViewById(R.id.limit_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = root.findViewById(R.id.limit_tab)
        tabs.setupWithViewPager(viewPager)



        val allowedLimitAdapter = AllowedLimitAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager2: ViewPager = root.findViewById(R.id.alowes_limit_pager)
        viewPager2.adapter = allowedLimitAdapter
        val tabs2 : TabLayout = root.findViewById(R.id.alowes_limit_tab)
        tabs2.setupWithViewPager(viewPager2)





        root.limitmain_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })



        return root

    }

}