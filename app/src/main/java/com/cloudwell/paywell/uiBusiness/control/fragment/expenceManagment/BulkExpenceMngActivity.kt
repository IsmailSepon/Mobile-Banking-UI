package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.bulk_expence_mng_layout.*

class BulkExpenceMngActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bulk_expence_mng_layout)

        expence_bulk_btn.setOnClickListener(View.OnClickListener {
            this.finish()
        })




        bulk_expence_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(supportFragmentManager)
        })


    }
}