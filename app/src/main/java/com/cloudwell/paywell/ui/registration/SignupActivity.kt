package com.cloudwell.paywell.ui.registration

import android.content.Intent
import android.hardware.biometrics.BiometricManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.authentication.UserAuthenticationHostActivity
import kotlinx.android.synthetic.main.activity_signup.*
import java.util.concurrent.Executors


/**
 * Created by Sepon on 4/1/2020.
 * ==============================Don't extend "BaseActivity" =================
 */

class SignupActivity : AppCompatActivity() {

    var country = arrayOf("+880", "+9715", "+966", "+699", "+778")
    var mBiometricManager: BiometricManager? = null
    var fingerBtn : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        fingerBtn = finger

        checkFingerprint()

        country_code_spinner.onItemSelectedListener
        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        country_code_spinner.adapter = aa


        lost_access_num.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, UserAuthenticationHostActivity::class.java)
            // intent.putExtra("lostAccess", "lostAccess")
            startActivity(intent)

        })


        et_phone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var phone: String = et_phone.text.toString()
                if (phone.length >= 10) {
                    login_btn.setBackgroundResource(R.drawable.round_btn_visable)
                    login_btn.setOnClickListener(View.OnClickListener {
                        finish()
                        //startActivity(Intent(applicationContext, MainHomeActivity::class.java))
                        startActivity(
                            Intent(
                                applicationContext,
                                // RegistationMainActivity::class.java
                                RegistrationUserOptionActivity::class.java
                            )
                        )
                    })
                } else {
                    login_btn.setBackgroundResource(R.drawable.round_btn)
                    //et_phone.setError("Input Field!")
                }
            }
        })


        finger.setOnClickListener(View.OnClickListener {

            val executor = Executors.newSingleThreadExecutor()


            val biometricPrompt = BiometricPrompt(
                this,
                executor,
                object : BiometricPrompt.AuthenticationCallback() {

                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        runOnUiThread {
                            //this.startActivity(Intent(this@SignupActivity,RegistrationUserOptionActivity::class.java))
                            startActivity(
                                Intent(
                                    this@SignupActivity,
                                    RegistrationUserOptionActivity::class.java
                                )
                            )

//                        val intent : Intent = Intent( this@SignupActivity, RegistrationUserOptionActivity::class.java )
//                        startActivity()
//

                        }
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        runOnUiThread {
                            Toast.makeText(
                                this@SignupActivity,
                                "Authentication failed! Please try again.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })



            val promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("PeyWell Fingerprint Sign In")
                /*Subtitle and description are optional parameters, so, you can skip those parameters.
                .setSubtitle("Set the subtitle to display.")
                .setDescription("Verification required")*/
                .setNegativeButtonText("Cancel")
                .build()


            biometricPrompt.authenticate(promptInfo)


        })

    }

    private fun checkFingerprint() {

        val fingerprintManagerCompat = FingerprintManagerCompat.from(applicationContext)

        if (!fingerprintManagerCompat.isHardwareDetected) {
            // Device doesn't support fingerprint authentication
            Toast.makeText(this, " Device doesn't support fingerprint authentication   ", Toast.LENGTH_SHORT
            ).show()
            fingerBtn?.visibility = View.INVISIBLE

        } else if (!fingerprintManagerCompat.hasEnrolledFingerprints()) {
            // User hasn't enrolled any fingerprints to authenticate with
            Toast.makeText(
                this,
                "User hasn't enrolled any fingerprints to authenticate with ",
                Toast.LENGTH_SHORT
            ).show()
            fingerBtn?.visibility = View.INVISIBLE


        } else {
            fingerBtn?.visibility = View.VISIBLE

        }

    }

}
