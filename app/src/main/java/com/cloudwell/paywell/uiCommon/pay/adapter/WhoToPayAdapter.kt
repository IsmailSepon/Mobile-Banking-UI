package com.cloudwell.paywell.uiCommon.pay.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.fragment.AllAccountFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.BankAccountFragment

private val TAB_TITLES = arrayOf(
    R.string.all,
    R.string.bank_account
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class WhoToPayAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AllAccountFragment.newInstance(0)
            1 -> BankAccountFragment.newInstance(1)
            else -> AllAccountFragment.newInstance(0)
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