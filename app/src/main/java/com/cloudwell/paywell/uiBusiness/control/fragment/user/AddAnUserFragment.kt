package com.cloudwell.paywell.uiBusiness.control.fragment.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.fragment.BuPersonalProfileFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.bu_add_an_user_layout.view.*

class AddAnUserFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bu_add_an_user_layout, container, false)


        view.bu_add_anuser_btn.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                UserProfileFragment(),
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
        fun newInstance(sectionNumber: Int): AddAnUserFragment {
            return AddAnUserFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
