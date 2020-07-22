package com.cloudwell.paywell.ui.BusinessUI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.BusinessSendFundFragment
import com.cloudwell.paywell.utils.FragmentHelper

class BusinessLandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_landing)


        FragmentHelper.addFirstFragment(
            BusinessSendFundFragment(),
            supportFragmentManager,
            R.id.bu_send_money_container
        )


    }
}