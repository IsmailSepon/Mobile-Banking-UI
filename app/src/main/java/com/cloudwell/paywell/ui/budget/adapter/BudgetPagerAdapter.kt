package com.cloudwell.paywell.ui.budget.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.budget.fragment.BudgetCategoryFragment
import com.cloudwell.paywell.ui.budget.fragment.BudgetMarchantFragment

private val TAB_TITLES = arrayOf(
    R.string.category,
    R.string.marchant,
    R.string.location
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class BudgetPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BudgetCategoryFragment.newInstance(0)
            1 -> BudgetMarchantFragment.newInstance(1)
            2 -> BudgetMarchantFragment.newInstance(2)
            else -> BudgetCategoryFragment.newInstance(0)
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