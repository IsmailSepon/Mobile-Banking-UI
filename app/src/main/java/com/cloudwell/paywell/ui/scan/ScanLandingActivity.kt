package com.cloudwell.paywell.ui.scan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.scan.fragment.ScanMainFeg
import com.cloudwell.paywell.utils.FragmentHelper

class ScanLandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_landing)



        FragmentHelper.addFirstFragment(ScanMainFeg(), supportFragmentManager, R.id.scan_host_container)
    }
}