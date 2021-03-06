package com.cloudwell.paywell.uiBusiness.control.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessCardUsersFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessvirtualCardFragment
import com.cloudwell.paywell.uiBusiness.control.fragment.BusinessAPIFragment
import com.cloudwell.paywell.uiBusiness.control.fragment.BusinessGeneralControlFragment
import com.cloudwell.paywell.uiBusiness.control.fragment.BusinessUserControlFragment

private val TAB_TITLES = arrayOf(
    R.string.general,
    R.string.users,
    R.string.api
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class BuControllPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BusinessGeneralControlFragment.newInstance(0)
            1 -> BusinessUserControlFragment.newInstance(1)
            2 -> BusinessAPIFragment.newInstance(2)
            else -> BusinessGeneralControlFragment.newInstance(0)
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