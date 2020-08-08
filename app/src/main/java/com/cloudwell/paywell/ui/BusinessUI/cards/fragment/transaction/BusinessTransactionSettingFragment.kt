package com.cloudwell.paywell.ui.BusinessUI.cards.fragment.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.cards.adapter.CardsTransactionPagerAdapter
import com.google.android.material.tabs.TabLayout

class BusinessTransactionSettingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_transaction_satting_layout, container, false)

        val sectionsPagerAdapter = CardsTransactionPagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager = view.findViewById(R.id.trx_view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.transaction_tabs)
        tabs.setupWithViewPager(viewPager)

        return view
    }


}
