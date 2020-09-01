package com.cloudwell.paywell.uiBusiness.cards.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessCardUsersFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessPhysicalCardFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessvirtualCardFragment

private val TAB_TITLES = arrayOf(
    R.string.physical_cards,
    R.string.virtual_cards,
    R.string.users
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class BiCardsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BusinessPhysicalCardFragment.newInstance(0)
            1 -> BusinessvirtualCardFragment.newInstance(1)
            2 -> BusinessCardUsersFragment.newInstance(2)
            else -> BusinessPhysicalCardFragment.newInstance(0)
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