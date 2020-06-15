package com.cloudwell.paywell.consumer.ui.requestMoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.requestMoney.fragment.RequestMoneyMainFragment
import com.cloudwell.paywell.consumer.utils.FragmentHelper

class RequestMoneyHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_money_host)

        FragmentHelper.replaceFragment(
            RequestMoneyMainFragment(),
            supportFragmentManager,
            R.id.request_money_container
        )

    }
}