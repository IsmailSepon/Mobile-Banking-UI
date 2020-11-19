package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.claiment_details_fragment.*

class ClaimentProfileDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.claiment_details_fragment)


        cliamnt_profile_details_btn.setOnClickListener(View.OnClickListener {
                val intent : Intent = Intent(this, BulkExpenceMngActivity::class.java)
                startActivity(intent)
        })


    }
}