package com.cloudwell.paywell.ui.BusinessUI.cards.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.cards.fragment.BusinessCardUsersFragment
import com.cloudwell.paywell.ui.BusinessUI.cards.fragment.BusinessPhysicalCardFragment
import com.cloudwell.paywell.ui.BusinessUI.cards.fragment.BusinessvirtualCardFragment
import com.cloudwell.paywell.ui.BusinessUI.cards.fragment.transaction.BusinessCardTransactionFragment

private val TAB_TITLES = arrayOf(
    R.string.transactions,
    R.string.settings
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class CardsTransactionPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BusinessCardTransactionFragment.newInstance(0)
            1 -> BusinessvirtualCardFragment.newInstance(1)
            else -> BusinessCardTransactionFragment.newInstance(0)
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