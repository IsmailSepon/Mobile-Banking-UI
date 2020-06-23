package com.cloudwell.paywell.ui.spiltBill.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.spiltBill.fragment.requestSpiltbill.SpiltBillRequestProfileFragment
import com.cloudwell.paywell.utils.FragmentHelper

class SpiltBillHoastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spilt_bill_hoast)

        val intent = intent
        val id = intent.getStringExtra("spilt")
        if (id.equals("2")) {


            FragmentHelper.addFirstFragment(
                SpiltBillRequestProfileFragment(),
                supportFragmentManager,
                R.id.spilt_bill_container
            )
        } else {
            FragmentHelper.addFirstFragment(
                SpiltBillProfileFragment(),
                supportFragmentManager,
                R.id.spilt_bill_container
            )
        }

    }
}