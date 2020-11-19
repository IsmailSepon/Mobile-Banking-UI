package com.cloudwell.paywell.uiBusiness.control


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.fragment.BuProfileManageFragment
import com.cloudwell.paywell.utils.FragmentHelper

class BusinessControlHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_control_host_layout)

            FragmentHelper.addFirstFragment(
                BuProfileManageFragment(),
                supportFragmentManager,
                R.id.bu_Control_container
            )

    }
}