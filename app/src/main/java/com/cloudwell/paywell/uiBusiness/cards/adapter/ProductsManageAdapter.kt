package com.cloudwell.paywell.uiBusiness.cards.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.fragment.manageCustomers.CustomersFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.manageCustomers.CustomersSettingsFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.manageCustomers.ProductsFragment

private val TAB_TITLES = arrayOf(
    R.string.products,
    R.string.settings
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class ProductsManageAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ProductsFragment.newInstance(0)
            1 -> CustomersSettingsFragment.newInstance(1)
            else -> CustomersFragment.newInstance(0)
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