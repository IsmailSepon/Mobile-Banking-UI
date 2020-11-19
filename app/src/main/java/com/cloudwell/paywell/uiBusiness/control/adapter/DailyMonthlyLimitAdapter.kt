package com.cloudwell.paywell.uiBusiness.control.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.fragment.limit.BuDailyLimitsFragment
import com.cloudwell.paywell.uiBusiness.control.fragment.limit.BuMonthlyLimitsFragment

private val TAB_TITLES = arrayOf(
    R.string.daily_limits,
    R.string.monthly_limit
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class DailyMonthlyLimitAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BuDailyLimitsFragment.newInstance(0)
            1 -> BuMonthlyLimitsFragment.newInstance(1)
            else -> BuDailyLimitsFragment.newInstance(0)
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}