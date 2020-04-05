package com.cloudwell.paywell.consumer.activity.registation

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.ApplockManager
import com.cloudwell.paywell.consumer.ui.auth.LoginActivity
import kotlinx.android.synthetic.main.activity_signup.*


/**
 * Created by Sepon on 4/1/2020.
 * ==============================Don't extend "BaseActivity" =================
 */

class SignupActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        assert(supportActionBar != null)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setTitle("REG")
            supportActionBar!!.elevation = 0f
            supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#5aac40")));
        }

        ApplockManager.getInstance().enableDefaultAppLockIfAvailable(application)
        login_btn.setOnClickListener(View.OnClickListener {
            finish()
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        })

    }


}
