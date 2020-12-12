package com.cloudwell.paywell.ui.statment.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.statment.fragment.StatmentPDFFragment

private val TAB_TITLES = arrayOf(
    R.string.pdf,
    R.string.excel,
    R.string.csv
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class StatmentPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> StatmentPDFFragment.newInstance(0)
            1 -> StatmentPDFFragment.newInstance(1)
            2 -> StatmentPDFFragment.newInstance(2)
            else -> StatmentPDFFragment.newInstance(0)
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