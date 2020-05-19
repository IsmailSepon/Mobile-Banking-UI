package com.cloudwell.paywell.consumer.activity.registation.nidVerification

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.activity_n_i_dfrontside.*

class NIDfrontsideActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_n_i_dfrontside)

//        assert(supportActionBar != null)
//        if (supportActionBar != null) {
//            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//            val spannablerTitle = SpannableString("NID front side")
//            spannablerTitle.setSpan(
//                ForegroundColorSpan(applicationContext.getColor(R.color.white)),
//                0,
//                spannablerTitle.length,
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//            )
//            supportActionBar!!.title = spannablerTitle
//        }
//      //  getApplicationContext().getResources().getColor(R.color.white)

        take_pic.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, NIDfrontSecondActivity :: class.java))
        })
    }

}
