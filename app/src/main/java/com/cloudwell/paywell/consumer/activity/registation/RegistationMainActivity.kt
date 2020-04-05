package com.cloudwell.paywell.consumer.activity.registation

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.ui.auth.LoginActivity
import kotlinx.android.synthetic.main.activity_registation_main.*

class RegistationMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registation_main)

//        assert(supportActionBar != null)
//        if (supportActionBar != null) {
//            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//            supportActionBar!!.setTitle(getString("R"))
//            supportActionBar!!.elevation = 0f
//            supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#5aac40")));
//        }

        button.setOnClickListener(View.OnClickListener {
            //finish()
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        })
    }

}
