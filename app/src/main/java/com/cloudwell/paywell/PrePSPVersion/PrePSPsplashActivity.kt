package com.cloudwell.paywell.PrePSPVersion

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.PAuthenticationHostActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.ApplockManager

class PrePSPsplashActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_p_s_psplash)


//        val preference : Preference = Preference.getInstance(this)
//        val userMobileNumber: String = preference.getData("userMobileNumber")
//        Log.e("userMobileNumber", userMobileNumber)

        ApplockManager.getInstance().enableDefaultAppLockIfAvailable(application)

        Handler().postDelayed({

//            if (userMobileNumber!= ""){
            val mainIntent = Intent(this, PAuthenticationHostActivity::class.java)
           // val mainIntent = Intent(this, AirTicketMenuActivity::class.java)

           // startActivity(Intent(this, AirTicketMenuActivity::class.java))
            this.startActivity(mainIntent)
//            }else{
//                val mainIntent = Intent(this, SignupActivity::class.java)
//                this.startActivity(mainIntent)
//            }


            this.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}