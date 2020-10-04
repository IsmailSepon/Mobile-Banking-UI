package com.cloudwell.paywell.uiCommon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.fragment.PaywellUserNameFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.RequestMoneyLocationAccessFragment
import com.cloudwell.paywell.utils.FragmentHelper

class PaymentMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_main)

        val parent: String? = intent.getStringExtra("payments")

        if (parent.equals("1")) {

            FragmentHelper.addFirstFragment(
                PaywellUserNameFragment(),
                supportFragmentManager,
                R.id.payment_container
            )

        }else if  (parent.equals("2")){

            FragmentHelper.addFirstFragment(
                RequestMoneyLocationAccessFragment(),
                supportFragmentManager,
                R.id.payment_container
            )
        }





    }
}