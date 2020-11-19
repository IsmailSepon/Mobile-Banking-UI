package com.cloudwell.paywell.uiCommon.pay.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.fragment.AllAccountFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp.ComboOfferFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp.InternetOfferFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp.TalkTimeOfferFragment

private val TAB_TITLES = arrayOf(
    R.string.combo,
    R.string.talk_time,
    R.string.internet
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class TopUpOfferAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ComboOfferFragment.newInstance(0)
            1 -> TalkTimeOfferFragment.newInstance(1)
            2 -> InternetOfferFragment.newInstance(2)
            else -> AllAccountFragment.newInstance(0)
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