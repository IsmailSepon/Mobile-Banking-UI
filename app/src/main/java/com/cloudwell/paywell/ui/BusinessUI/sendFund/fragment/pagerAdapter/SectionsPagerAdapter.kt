package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.pagerAdapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.others.BusinessSendFundHistoryFragment

private val TAB_TITLES = arrayOf(
    R.string.history,
    R.string.friends_on_PayWell,
    R.string.favorites
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        // return PlaceholderFragment.newInstance(position + 1)
        return when (position) {
            0 -> BusinessSendFundHistoryFragment.newInstance(0)
            1 -> PlaceholderFragment.newInstance(1)
            2 -> PlaceholderFragment.newInstance(2)
            else -> BusinessSendFundHistoryFragment.newInstance(0)
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}