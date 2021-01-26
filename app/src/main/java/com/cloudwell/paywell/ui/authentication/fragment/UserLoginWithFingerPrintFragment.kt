package com.cloudwell.paywell.ui.authentication.fragment

import android.content.Intent
import android.hardware.biometrics.BiometricManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.registration.RegistrationUserOptionActivity
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.user_login_fingerprint_fragment.view.*
import org.jetbrains.anko.runOnUiThread
import java.util.concurrent.Executors

class UserLoginWithFingerPrintFragment : Fragment() {

    var mBiometricManager: BiometricManager? = null

    var fingerBtn : ImageView? = null
    var authtext : TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.user_login_fingerprint_fragment, container, false)


        showFingerDialog()

        fingerBtn = view.fingeric
        fingerBtn?.setOnClickListener(View.OnClickListener {
            showFingerDialog()
        })

        authtext = view.authtext

        view.usePasscode.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })


        return view
    }

    fun showFingerDialog(){

        val executor = Executors.newSingleThreadExecutor()


        val biometricPrompt = BiometricPrompt(
            this,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    requireContext().runOnUiThread {
                        //this.startActivity(Intent(this@SignupActivity,RegistrationUserOptionActivity::class.java))
                        startActivity(
                            Intent(
                                requireContext(),
                                RegistrationUserOptionActivity::class.java
                            )
                        )

//

                    }
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    requireContext().runOnUiThread {
                       // Toast.makeText(requireContext(), "Authentication failed! Please try again.", Toast.LENGTH_SHORT).show()

                        authtext?.text = "Sorry, that didn’t match. Try again"


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


    }

}