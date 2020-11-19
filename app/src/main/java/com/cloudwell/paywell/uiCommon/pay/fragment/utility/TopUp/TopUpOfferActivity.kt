package com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.adapter.TopUpOfferAdapter
import com.google.android.material.tabs.TabLayout


class TopUpOfferActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_up_offer)


        val returnIntent = Intent()
        returnIntent.putExtra("result", "result")

        setResult(RESULT_OK, returnIntent)
      //  finish()

        val sectionsPagerAdapter = TopUpOfferAdapter(
            this.applicationContext,
            this.supportFragmentManager
        )
        val viewPager: ViewPager = findViewById(R.id.topup_offer_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.topup_offer_tabs)
        tabs.setupWithViewPager(viewPager)




    }
}