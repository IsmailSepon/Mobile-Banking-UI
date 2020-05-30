package com.cloudwell.paywell.consumer.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.activity.registation.SignupActivity
import com.cloudwell.paywell.consumer.base.ApplockManager
import com.cloudwell.paywell.consumer.ui.home.MainHomeActivity

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        ApplockManager.getInstance().enableDefaultAppLockIfAvailable(application)

        Handler().postDelayed({
            val mainIntent = Intent(this, MainHomeActivity::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}