package com.cloudwell.paywell.uiBusiness.cards.fragment.manageLink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.adapter.PaymentLinkPagerAdapter
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.payment_link_fragment.view.*

class BuPaymentLinkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.payment_link_fragment, container, false)



        val sectionsPagerAdapter = PaymentLinkPagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager =  view.findViewById(R.id.payment_link_view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.payment_link_tabs)
        tabs.setupWithViewPager(viewPager)





        view.paymentlink_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })


        return view
    }
}