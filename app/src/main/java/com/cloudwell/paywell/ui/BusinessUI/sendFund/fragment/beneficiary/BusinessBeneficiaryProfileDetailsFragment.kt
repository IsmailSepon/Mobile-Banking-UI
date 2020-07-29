package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.beneficiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.pagerAdapter.BeneficiaryProfileDetailsPagerAdapter
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.business_beneficiary_profile_details_layout.view.*

class BusinessBeneficiaryProfileDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_beneficiary_profile_details_layout, container, false)



        val beneficiaryDetailsPagerAdapter = BeneficiaryProfileDetailsPagerAdapter(requireActivity().applicationContext,requireActivity().supportFragmentManager)
        val viewPager: ViewPager = view.findViewById(R.id.beneficiar_profile_yview_pager)
        viewPager.adapter = beneficiaryDetailsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.beneficiary_profile_tab)
        tabs.setupWithViewPager(viewPager)


        view.beneficiary_profile_edit_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BusinessProfileEditFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )
        })


        return view
    }


}
