package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.pagerAdapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.beneficiary.BusinessSendFundAccountFragment
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.beneficiary.BusinessSendFundSettingsFragment
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.beneficiary.BusinessSendFundTransactionFragment
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.others.BusinessSendFundHistoryFragment
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.transcation.BusinessSendFundBeneficiariesFragment
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.transcation.BusinessSendFundSentFragment
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.transcation.BusinessSendFundUpcomingFragment

private val TAB_TITLES = arrayOf(
    R.string.account,
    R.string.transactions,
    R.string.settings
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class BeneficiaryDetailsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BusinessSendFundAccountFragment.newInstance(0)
            1 -> BusinessSendFundTransactionFragment.newInstance(1)
            2 -> BusinessSendFundSettingsFragment.newInstance(2)
            else -> BusinessSendFundAccountFragment.newInstance(0)
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