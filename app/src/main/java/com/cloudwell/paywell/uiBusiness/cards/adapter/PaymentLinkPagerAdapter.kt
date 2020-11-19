package com.cloudwell.paywell.uiBusiness.cards.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.fragment.manageLink.*
import com.cloudwell.paywell.uiBusiness.cards.fragment.transaction.BusinessCardTransactionFragment

private val TAB_TITLES = arrayOf(
    R.string.paid,
    R.string.partially_paid,
    R.string.unpaid,
    R.string.api,
    R.string.reminder_settings
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class PaymentLinkPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BusinessPaidFragment.newInstance(0)
            1 -> BusinessPartiallypaidFragment.newInstance(1)
            2 -> BusinessUnPaidFragment.newInstance(2)
            3 -> BusinessAPIFragment.newInstance(3)
            4 -> BusinessReminderSettingsFragment.newInstance(4)
            else -> BusinessCardTransactionFragment.newInstance(0)
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 5
    }
}