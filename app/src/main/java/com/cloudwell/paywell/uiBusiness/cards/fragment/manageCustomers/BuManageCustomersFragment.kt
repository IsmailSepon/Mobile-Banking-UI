package com.cloudwell.paywell.uiBusiness.cards.fragment.manageCustomers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.adapter.CustomerManageAdapter
import com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.BuInvoicePrintFragment
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.customer_manage_fragment.view.*
import kotlinx.android.synthetic.main.invoice_main_layout.view.create_invoice

class BuManageCustomersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.customer_manage_fragment, container, false)




        val sectionsPagerAdapter = CustomerManageAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager =  view.findViewById(R.id.bu_customers_view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.customers_tabs)
        tabs.setupWithViewPager(viewPager)



        view.create_invoice.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BuInvoicePrintFragment(), requireActivity().supportFragmentManager, R.id.bu_Cards_container
            )
        })




        view.customermanage_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }

}