package com.cloudwell.paywell.uiBusiness.cards.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.fragment.expence.ExpenseUpcommingFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.BusinessDraftFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.InvoicePaidFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.InvoicePartiallyPaidFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.transaction.BusinessCardTransactionFragment

private val TAB_TITLES = arrayOf(
    R.string.upcoming,
    R.string.pending_refunds,
    R.string.completed,
    R.string.settings
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class ExpensesPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ExpenseUpcommingFragment.newInstance(0)
            1 -> BusinessDraftFragment.newInstance(1)
            2 -> InvoicePaidFragment.newInstance(2)
            3 -> InvoicePartiallyPaidFragment.newInstance(3)
            else -> BusinessCardTransactionFragment.newInstance(0)
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }
}