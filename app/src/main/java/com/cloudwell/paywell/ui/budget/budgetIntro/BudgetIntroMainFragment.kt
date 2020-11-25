package com.cloudwell.paywell.ui.budget.budgetIntro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.expence_managment_main_layout.view.*

class BudgetIntroMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.expence_managment_main_layout, container, false)

        var viewpager: ViewPager2 = view.expence_viewpager

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewpager.adapter = pagerAdapter
      //  viewpager.setUserInputEnabled(false);


        var tab: TabLayout = view.expence_tab_layout//root.into_tab_layout

        TabLayoutMediator(tab, viewpager) { tab, position -> }.attach()


        return view
    }

    private inner class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        val root = view

        override fun createFragment(position: Int): Fragment {

            if (position == 0) {
                return BudgetIntroOneFragment()
            } else if (position == 1) {
                return BudgetIntroTwoFragment()
            } else if (position == 2) {
                return BudgetIntroThreeFragment()
            }

            return BudgetIntroOneFragment()
        }

        //  override fun createFragment(position: Int): Fragment = SliderFragment()

    }
}