package com.cloudwell.paywell.uiBusiness.control.fragment.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.adapter.BuCtrlProfilePagerAdapter
import com.cloudwell.paywell.uiBusiness.control.adapter.BuUserProfilePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.bu_add_an_user_layout.view.*

class UserProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.user_profile_layout, container, false)


        val sectionsPagerAdapter = BuUserProfilePagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager = root.findViewById(R.id.user_profile_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = root.findViewById(R.id.user_profile_tab)
        tabs.setupWithViewPager(viewPager)


        return root


//        view.bu_add_anuser_btn.setOnClickListener(View.OnClickListener {
//
////            FragmentHelper.replaceFragment(
////                BusinessBeneficiaryProfileDetailsFragment(),
////                requireActivity().supportFragmentManager,
////                R.id.bu_Control_container
////            )
//        })


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
        fun newInstance(sectionNumber: Int): UserProfileFragment {
            return UserProfileFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
