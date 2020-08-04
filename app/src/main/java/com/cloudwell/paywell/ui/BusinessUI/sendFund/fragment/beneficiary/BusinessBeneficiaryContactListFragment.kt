package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.beneficiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.pagerAdapter.BeneficiaryDetailsPagerAdapter
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.pagerAdapter.SectionsPagerAdapter
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.pagerAdapter.TranscationPagerAdapter
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.business_beneficiary_cnfm_code_layout.view.*

class BusinessBeneficiaryContactListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_beneficiary_contact_layout, container, false)






        return view
    }


}
