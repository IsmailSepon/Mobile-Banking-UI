package com.cloudwell.paywell.uiBusiness.slider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.cards.fragment.sliderFrg.SliderFragment
import com.cloudwell.paywell.ui.cards.fragment.sliderFrg.SliderFragment2
import com.cloudwell.paywell.ui.cards.fragment.sliderFrg.SliderFragment3
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.cards_fragment.view.*
import kotlinx.android.synthetic.main.expence_managment_main_layout.view.*

class ExpenceManagmentMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.expence_managment_main_layout, container, false)

        var viewpager: ViewPager2 = view.expence_viewpager

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewpager.adapter = pagerAdapter

        var tab: TabLayout = view.expence_tab_layout//root.into_tab_layout

        TabLayoutMediator(tab, viewpager) { tab, position -> }.attach()


        return view
    }

    private inner class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        val root = view

        override fun createFragment(position: Int): Fragment {

            if (position == 0) {
                return ExpenceSliderOneFragment()
            } else if (position == 1) {
                return ExpenceSliderTwoFragment()
            } else if (position == 2) {
                return ExpenceSliderthreeFragment()
            }

            return ExpenceSliderOneFragment()
        }

        //  override fun createFragment(position: Int): Fragment = SliderFragment()

    }
}