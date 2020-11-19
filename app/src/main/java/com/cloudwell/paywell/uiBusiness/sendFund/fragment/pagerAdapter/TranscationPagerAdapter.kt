package com.cloudwell.paywell.uiBusiness.sendFund.fragment.pagerAdapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.transcation.BusinessSendFundBeneficiariesFragment
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.transcation.BusinessSendFundSentFragment
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.transcation.BusinessSendFundUpcomingFragment

private val TAB_TITLES = arrayOf(
    R.string.upcoming,
    R.string.sent,
    R.string.beneficiaries
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class TranscationPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        // return PlaceholderFragment.newInstance(position + 1)
        return when (position) {
            0 -> BusinessSendFundUpcomingFragment.newInstance(0)
            1 -> BusinessSendFundSentFragment.newInstance(1)
            2 -> BusinessSendFundBeneficiariesFragment.newInstance(2)
            else -> BusinessSendFundUpcomingFragment.newInstance(0)
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