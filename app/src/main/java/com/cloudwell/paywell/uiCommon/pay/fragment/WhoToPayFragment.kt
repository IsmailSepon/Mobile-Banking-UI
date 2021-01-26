package com.cloudwell.paywell.uiCommon.pay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.adapter.WhoToPayAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.who_topay_layout.view.*

class WhoToPayFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.who_topay_layout, container, false)


        val sectionsPagerAdapter = WhoToPayAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager = view.findViewById(R.id.whotopay_view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.whotopay_tabs)
        tabs.setupWithViewPager(viewPager)



        view.whotopay_back_btn.setOnClickListener(View.OnClickListener {
            activity?.finish()  // FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }


}
