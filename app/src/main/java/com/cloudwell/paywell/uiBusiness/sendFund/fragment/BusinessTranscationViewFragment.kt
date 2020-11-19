package com.cloudwell.paywell.uiBusiness.sendFund.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.pagerAdapter.TranscationPagerAdapter
import com.google.android.material.tabs.TabLayout

class BusinessTranscationViewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_transcation_view_layout, container, false)


        val transcationPagerAdapter = TranscationPagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager = view.findViewById(R.id.transcation_view_pager)
        viewPager.adapter = transcationPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.transcationView_tabs)
        tabs.setupWithViewPager(viewPager)

        return view
    }


}
