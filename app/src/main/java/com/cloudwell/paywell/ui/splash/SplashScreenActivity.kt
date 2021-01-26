package com.cloudwell.paywell.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.ApplockManager
import com.cloudwell.paywell.base.Preference
import com.cloudwell.paywell.ui.authentication.UserAuthenticationHostActivity
import com.cloudwell.paywell.ui.registration.SignupActivity

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val preference : Preference = Preference.getInstance(this)
        val userMobileNumber: String = preference.getData("userMobileNumber")
        Log.e("userMobileNumber", userMobileNumber)

        ApplockManager.getInstance().enableDefaultAppLockIfAvailable(application)

        Handler().postDelayed({

            if (userMobileNumber!= ""){
                val mainIntent = Intent(this, UserAuthenticationHostActivity::class.java)
                this.startActivity(mainIntent)
            }else{
                val mainIntent = Intent(this, SignupActivity::class.java)
                this.startActivity(mainIntent)
            }


            this.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}