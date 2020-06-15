package com.cloudwell.paywell.consumer.ui.spiltBill.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.spiltBill.fragment.requestSpiltbill.SpiltBillRequestProfileFragment
import com.cloudwell.paywell.consumer.utils.FragmentHelper

class SpiltBillHoastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spilt_bill_hoast)

        val intent = intent
        val id = intent.getStringExtra("spilt")
        if (id.equals("2")) {


            FragmentHelper.replaceFragment(
                SpiltBillRequestProfileFragment(),
                supportFragmentManager,
                R.id.spilt_bill_container
            )
        } else {
            FragmentHelper.replaceFragment(
                SpiltBillProfileFragment(),
                supportFragmentManager,
                R.id.spilt_bill_container
            )
        }

    }
}