package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.pagerAdapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.beneficiary.*
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.others.BusinessSendFundHistoryFragment
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.transcation.BusinessSendFundBeneficiariesFragment
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.transcation.BusinessSendFundSentFragment
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.transcation.BusinessSendFundUpcomingFragment

private val TAB_TITLES = arrayOf(
    R.string.transactions,
    R.string.statistics
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class BeneficiaryProfileDetailsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BusinessProfileTransactionFragment.newInstance(0)
            1 -> BusinessProfileStatisticsFragment.newInstance(1)
            else -> BusinessProfileTransactionFragment.newInstance(0)
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