package com.cloudwell.paywell.uiBusiness.cards.fragment.invoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.adapter.InvoicePagerAdapter
import com.google.android.material.tabs.TabLayout

class InvoiceMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.invoice_main_layout, container, false)




        val sectionsPagerAdapter = InvoicePagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager =  view.findViewById(R.id.bu_invoice_view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.invoice_tabs)
        tabs.setupWithViewPager(viewPager)







        return view
    }
}