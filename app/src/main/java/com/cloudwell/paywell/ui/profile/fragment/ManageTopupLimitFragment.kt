package com.cloudwell.paywell.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.cloudwell.paywell.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.limit_fragment.view.*


class ManageTopupLimitFragment : Fragment() {

    private lateinit var tabLayout1: TabLayout
    private lateinit var tabLayout2: TabLayout
    private lateinit var viewPager1: ViewPager
    private lateinit var viewPager2: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.limit_fragment, container, false)

        tabLayout1 = view.tabsLimits1
        viewPager1 = view.viewPagerLimits1

        tabLayout2 = view.tabsLimits2
        viewPager2 = view.viewPagerLimits2
        createViewPager(viewPager1)
        createViewPagerForAccounts(viewPager2)

        tabLayout1.setupWithViewPager(viewPager1)
        tabLayout2.setupWithViewPager(viewPager2)
        createCustomTab("Daily limits", "Monthly limits", tabLayout1)
        createCustomTab("Personal account", "Business account", tabLayout2)

        viewPager1.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(arg0: Int) {
                // TODO Auto-generated method stub
                if(arg0 == 1) {
                    view.textViewDL18.text = "Monthly allowed limits"
                } else {
                    view.textViewDL18.text = "Dailly allowed limits"
                }
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {
                // TODO Auto-generated method stub
                //println("onPageScrolled")
            }

            override fun onPageScrollStateChanged(num: Int) {
                // TODO Auto-generated method stub
            }
        })

        return view

        //            inflater.inflate(R.layout.manage_acc_profile_topup_limit_fragment, container, false)
    }

    private fun createViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFrag(DailyFragment(), "Daily limits")
        adapter.addFrag(MonthlyFragment(), "Monthly limits")
        viewPager.adapter = adapter
    }

    private fun createViewPagerForAccounts(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFrag(PersonalAccountFragment(), "Personal account")
        adapter.addFrag(BusinessAccountFragment(), "Business account")
        viewPager.adapter = adapter
    }

    private fun createCustomTab(str1: String, str2: String, tab: TabLayout) {
        val tabOne =
            LayoutInflater.from(context).inflate(R.layout.custom_tab, null) as TextView
        tabOne.setText(str1)
        tab.getTabAt(0)?.customView = tabOne

        val tabTwo =
            LayoutInflater.from(context).inflate(R.layout.custom_tab, null) as TextView
        tabTwo.text = str2
        tab.getTabAt(1)?.customView = tabTwo
    }


    internal class ViewPagerAdapter(manager: FragmentManager) :
        FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val mFragmentList: MutableList<Fragment> =
            ArrayList()
        private val mFragmentTitleList: MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }
}