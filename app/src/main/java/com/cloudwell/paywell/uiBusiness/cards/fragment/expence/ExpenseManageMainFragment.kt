package com.cloudwell.paywell.uiBusiness.cards.fragment.expence

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.adapter.ExpensesPagerAdapter
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.expense_manage_main_layout.view.*

class ExpenseManageMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.expense_manage_main_layout, container, false)




        val sectionsPagerAdapter = ExpensesPagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager =  view.findViewById(R.id.bu_expenses_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.expenses_tabs)
        tabs.setupWithViewPager(viewPager)

        view.expense_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }
}