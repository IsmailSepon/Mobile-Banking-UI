package com.cloudwell.paywell.uiBusiness.cards.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.adapter.BiCardsPagerAdapter
import com.google.android.material.tabs.TabLayout

class BusinessCardMainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_card_main_layout, container, false)

        val sectionsPagerAdapter = BiCardsPagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager = view.findViewById(R.id.card_view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.card_tabs)
        tabs.setupWithViewPager(viewPager)

        return view
    }


}
