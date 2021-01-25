package com.cloudwell.paywell.ui.statment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.fragment.user.AddAnUserFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_user_control_layout.view.*
import kotlinx.android.synthetic.main.statment_csv_layout.view.*
import kotlinx.android.synthetic.main.statment_pdf_layout.view.*
import kotlinx.android.synthetic.main.statment_pdf_layout.view.pdf_get_statment

class StatmentCSVragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.statment_csv_layout, container, false)



        view.csv_statment.setOnClickListener(View.OnClickListener {

            

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
        fun newInstance(sectionNumber: Int): StatmentCSVragment {
            return StatmentCSVragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
