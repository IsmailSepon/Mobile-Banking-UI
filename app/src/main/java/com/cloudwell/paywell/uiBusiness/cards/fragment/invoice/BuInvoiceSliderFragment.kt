package com.cloudwell.paywell.uiBusiness.cards.fragment.invoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.invoiceSlider.InvoiceSliderOneFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.invoiceSlider.InvoiceSliderThreeFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.invoiceSlider.InvoiceSliderTwoFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.invoice_slider_fragment.view.*

class BuInvoiceSliderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.invoice_slider_fragment, container, false)


        var viewpager: ViewPager2 = view.invoice_viewpager

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewpager.adapter = pagerAdapter

        var tab: TabLayout = view.invoice_tab_layout//root.into_tab_layout

        TabLayoutMediator(tab, viewpager) { tab, position -> }.attach()


        return view
    }

    private inner class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        val root = view

        override fun createFragment(position: Int): Fragment {

            if (position == 0) {
                return InvoiceSliderOneFragment()
            } else if (position == 1) {
                return InvoiceSliderTwoFragment()
            } else if (position == 2) {
                return InvoiceSliderThreeFragment()
            }

            return InvoiceSliderOneFragment()
        }

    }
}