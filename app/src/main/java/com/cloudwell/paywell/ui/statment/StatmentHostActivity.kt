package com.cloudwell.paywell.ui.statment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.statment.adapter.StatmentPagerAdapter
import com.cloudwell.paywell.uiBusiness.control.adapter.BuControllPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_statment_host.*

class StatmentHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statment_host)


        val sectionsPagerAdapter = StatmentPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = statment_pager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = statment_tab
        tabs.setupWithViewPager(viewPager)



        statment_back.setOnClickListener(View.OnClickListener {

            finish()
        })


    }
}