package com.cloudwell.paywell.ui.budget.budgetIntro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.budget.fragment.BudgetSetupFragment
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.expence_managment_main_layout.view.*

class BudgetIntroMainFragment : Fragment() {


//    var  viewPager  : ViewPager2? = null
    lateinit var viewPager: ViewPager2
    var position : Int = -1
    lateinit var tab: TabLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view: View =
            inflater.inflate(R.layout.expence_managment_main_layout, container, false)

        viewPager = view.expence_viewpager
        tab = view.expence_tab_layout

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter
        viewPager.isUserInputEnabled = false


        val tab: TabLayout = view.expence_tab_layout        //root.into_tab_layout
        TabLayoutMediator(tab, viewPager) { tab, position -> }.attach()

        view.intro_btn.setOnClickListener(View.OnClickListener {
            var position : Int  = viewPager.currentItem
            if (position==0){
                viewPager.currentItem = 1
            }else if (position==1){
                viewPager.currentItem = 2
            }else if (position==2){
                FragmentHelper.replaceFragment(BudgetSetupFragment(), requireActivity().supportFragmentManager, R.id.budget_container)
            }
        })

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