package com.cloudwell.paywell.ui.budget.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.budget.adapter.BudgetPagerAdapter
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.budget_view_layout.view.*

class BudgetViewFragment : Fragment() {


    private val data: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.budget_view_layout, container, false)






        val beneficiaryDetailsPagerAdapter = BudgetPagerAdapter(requireActivity().applicationContext,requireActivity().supportFragmentManager)
        val viewPager: ViewPager = view.findViewById(R.id.budgetview_viewpager)
        viewPager.adapter = beneficiaryDetailsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.budgetview_tab)
        tabs.setupWithViewPager(viewPager)









        view.budget_view_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }


}
