package com.cloudwell.paywell.ui.BusinessUI.cards.fragment.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.cards.fragment.transaction.BusinessTransactionSettingFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_physical_card_layout.view.*

class BusinessCardSettingsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_physical_card_layout, container, false)


//            FragmentHelper.replaceFragment(
//                BusinessTransactionSettingFragment(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Cards_container
//            )


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
        fun newInstance(sectionNumber: Int): BusinessCardSettingsFragment {
            return BusinessCardSettingsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}
