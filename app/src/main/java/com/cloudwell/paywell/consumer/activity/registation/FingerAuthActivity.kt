package com.cloudwell.paywell.consumer.activity.registation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.activity.thirdActivity
import kotlinx.android.synthetic.main.activity_finger_auth.*
import java.util.concurrent.Executors


class FingerAuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finger_auth)
        val activity = this
        val executor = Executors.newSingleThreadExecutor()
        val biometricPrompt = BiometricPrompt(activity, executor, object : BiometricPrompt.AuthenticationCallback() {

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    // user clicked negative/cancel button
                } else {
                    TODO("Called when an unrecoverable error has been encountered and the operation is complete.")
                }
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                runOnUiThread{
                    startActivity(Intent(activity, thirdActivity::class.java))
                }
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                runOnUiThread{
                    Toast.makeText(activity,"Authentication failed! Please try again.", Toast.LENGTH_SHORT).show()
                }
            }
        })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Authentication prompt!")
            //Subtitle and description are optional parameters, so, you can skip those parameters.
            .setSubtitle("Set the subtitle to display.")
            .setDescription("Verification required")
            .setNegativeButtonText("Cancel")
            .build()

        authenticateButton.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }
    }
}