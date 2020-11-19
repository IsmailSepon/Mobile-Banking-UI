package com.cloudwell.paywell.uiBusiness.control.fragment.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.fragment.info_edit.PersonalDetailsOneEditFrg
import com.cloudwell.paywell.uiBusiness.control.fragment.info_edit.PersonalDetailstwoEditFrg
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.bu_personal_layout.view.*


class UserProfile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.bu_user_profile_layout, container, false)


//        root.personal_details_et.setOnClickListener(View.OnClickListener {
//
//            FragmentHelper.replaceFragment(
//                PersonalDetailsOneEditFrg(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Control_container
//            )
//
//        })
//
//
//        root.address_et_ic.setOnClickListener(View.OnClickListener {
//
//            FragmentHelper.replaceFragment(
//                PersonalDetailstwoEditFrg(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Control_container
//            )
//        })


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
        fun newInstance(sectionNumber: Int): UserProfile {
            return UserProfile().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}