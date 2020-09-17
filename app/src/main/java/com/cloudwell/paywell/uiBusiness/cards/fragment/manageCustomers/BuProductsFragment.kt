package com.cloudwell.paywell.uiBusiness.cards.fragment.manageCustomers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.adapter.ProductsManageAdapter
import com.google.android.material.tabs.TabLayout

class BuProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.products_fragment, container, false)


//        view.new_customers_btn.setOnClickListener(View.OnClickListener {
//            FragmentHelper.replaceFragment(
//                BuInvoicePrintFragment(), requireActivity().supportFragmentManager, R.id.bu_Cards_container
//            )
//        })
//
//


        val sectionsPagerAdapter = ProductsManageAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager =  view.findViewById(R.id.bu_products_view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.product_tabs)
        tabs.setupWithViewPager(viewPager)




        return view
    }





}