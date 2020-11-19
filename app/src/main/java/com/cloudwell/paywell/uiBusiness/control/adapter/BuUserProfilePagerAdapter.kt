package com.cloudwell.paywell.uiBusiness.control.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.fragment.BusinessGeneralControlFragment
import com.cloudwell.paywell.uiBusiness.control.fragment.personal_profile.PersonalProfile
import com.cloudwell.paywell.uiBusiness.control.fragment.personal_profile.PersonalProfileSettinggsFrg
import com.cloudwell.paywell.uiBusiness.control.fragment.user.UserProfile

private val TAB_TITLES = arrayOf(
    R.string.personal_profile,
    R.string.settings
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class BuUserProfilePagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> UserProfile.newInstance(0)
            1 -> PersonalProfileSettinggsFrg.newInstance(1)
            else -> BusinessGeneralControlFragment.newInstance(0)
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