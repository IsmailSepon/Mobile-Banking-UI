package com.cloudwell.paywell.uiBusiness.control.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.fragment.user.AddAnUserFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_user_control_layout.view.*

class BusinessUserControlFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_user_control_layout, container, false)


        view.add_an_user.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                AddAnUserFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )
        })


        return view
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
        fun newInstance(sectionNumber: Int): BusinessUserControlFragment {
            return BusinessUserControlFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
