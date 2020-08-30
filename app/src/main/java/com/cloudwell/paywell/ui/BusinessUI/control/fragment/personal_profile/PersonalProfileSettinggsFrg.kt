package com.cloudwell.paywell.ui.BusinessUI.control.fragment.personal_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.cards.fragment.BusinessPhysicalCardFragment
import com.cloudwell.paywell.ui.BusinessUI.control.adapter.BuControllPagerAdapter
import com.cloudwell.paywell.ui.BusinessUI.control.adapter.BuCtrlProfilePagerAdapter
import com.google.android.material.tabs.TabLayout


class PersonalProfileSettinggsFrg : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.bu_personal_settings_layout, container, false)


        return root

    }


    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PersonalProfileSettinggsFrg {
            return PersonalProfileSettinggsFrg().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}