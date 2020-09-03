package com.cloudwell.paywell.uiBusiness.control.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.fragment.info_edit.company.CompanyProfileFragment
import com.cloudwell.paywell.uiBusiness.control.fragment.limit.BuLimitMainFragment
import com.cloudwell.paywell.uiBusiness.control.fragment.subscriptionPlan.BuSubscriptionPlanFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_general_control_layout.view.*

class BusinessGeneralControlFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_general_control_layout, container, false)


        view.personal_profile_layout.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                BuPersonalProfileFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })


        view.business_profile.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                CompanyProfileFragment (),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })

        view.virtual_acc_details_layout.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                BuVirtualAccFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })



        view.limit_layout.setOnClickListener(View.OnClickListener {


        })


        view.subscription_plan_layout.setOnClickListener(View.OnClickListener {


            FragmentHelper.replaceFragment(
                BuSubscriptionPlanFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )
        })

        view.document_layout.setOnClickListener(View.OnClickListener {


            FragmentHelper.replaceFragment(
                BuDocumentFragment(),
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
        fun newInstance(sectionNumber: Int): BusinessGeneralControlFragment {
            return BusinessGeneralControlFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
