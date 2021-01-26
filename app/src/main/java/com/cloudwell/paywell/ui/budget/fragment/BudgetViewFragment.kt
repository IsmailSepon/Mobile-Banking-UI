package com.cloudwell.paywell.ui.budget.fragment

import android.os.Bundle
import android.util.Log
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
    lateinit var  viewPager: ViewPager
    lateinit var tabs: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.budget_view_layout, container, false)




        viewPager= view.findViewById(R.id.budgetview_viewpager)
        tabs = view.findViewById(R.id.budgetview_tab)
       // initlizePagerAdapter()






        view.budget_view_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }


    override fun onResume() {
        super.onResume()
        Log.e("TEst", "onResume")

        initlizePagerAdapter()

    }

    override fun onDetach() {
        super.onDetach()
        Log.e("TEst", "onDetach")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TEst", "onPause")
    }

    private fun initlizePagerAdapter() {


        val beneficiaryDetailsPagerAdapter = BudgetPagerAdapter(requireActivity().applicationContext,requireActivity().supportFragmentManager)
        viewPager.adapter = beneficiaryDetailsPagerAdapter
        tabs.setupWithViewPager(viewPager)


    }


}
