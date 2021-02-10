package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.base.AirTricketBaseActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.services.activity.eticket.airticket.flightDetails1.fragment.EarningsFragment
import com.cloudwell.paywell.services.activity.eticket.airticket.flightDetails1.fragment.FlightFareFragment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.fragment.RolesFragment
import kotlinx.android.synthetic.main.activity_baggage_and_policies_actiivty.*
import java.util.*


class BaggageAndPoliciesActiivty : AirTricketBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baggage_and_policies_actiivty)
        setToolbar(getString(R.string.title_activity_baggage_and_policies_actiivty))

        setupViewPager(viewpager)
        tabs_policy!!.setupWithViewPager(viewpager)



    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(RolesFragment(), getString(R.string.roles))
        adapter.addFragment(FlightFareFragment(), getString(R.string.fares))
        adapter.addFragment(EarningsFragment(), getString(R.string.earnings))
        viewPager.adapter = adapter

    }


    internal inner class ViewPagerAdapter(var manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }
}
