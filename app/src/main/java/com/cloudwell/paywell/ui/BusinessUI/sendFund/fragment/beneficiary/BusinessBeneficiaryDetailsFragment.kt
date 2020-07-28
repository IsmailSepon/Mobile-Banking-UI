package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.beneficiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.pagerAdapter.BeneficiaryDetailsPagerAdapter
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.pagerAdapter.SectionsPagerAdapter
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.pagerAdapter.TranscationPagerAdapter
import com.google.android.material.tabs.TabLayout

class BusinessBeneficiaryDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_beneficiary_details_layout, container, false)



        val beneficiaryDetailsPagerAdapter = BeneficiaryDetailsPagerAdapter(requireActivity().applicationContext,requireActivity().supportFragmentManager)
        val viewPager: ViewPager = view.findViewById(R.id.beneficiary_details_view_pager)
        viewPager.adapter = beneficiaryDetailsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.beneficiary_details_tabs)
        tabs.setupWithViewPager(viewPager)


        return view
    }


}
