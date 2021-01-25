package com.cloudwell.paywell.ui.authentication.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import androidx.fragment.app.Fragment
import com.alimuzaffar.lib.pin.PinEntryEditText
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.CustomKeyboardWithFingerprint
import com.cloudwell.paywell.ui.registration.RegistrationUserOptionActivity
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.user_auth_for_switch_pw_account_two.view.*

class UserAuthenticateWithPasscodeFragment : Fragment(),  CustomKeyboardWithFingerprint.CustomKeyboardClickListener {

    lateinit var keyboard: CustomKeyboardWithFingerprint
    lateinit var editTextCreatePin: PinEntryEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.user_auth_for_switch_pw_account_two, container, false)

        keyboard = view.findViewById(R.id.customKeyboardUAS)
        editTextCreatePin = view.findViewById(R.id.editTextUAS1)

        editTextCreatePin.setRawInputType(InputType.TYPE_CLASS_TEXT)
        editTextCreatePin.setTextIsSelectable(true)
        val ic: InputConnection = editTextCreatePin.onCreateInputConnection(EditorInfo())
        keyboard.setInputConnection(ic)

       keyboard.setOnclick(this)

        editTextCreatePin.post(Runnable {
            editTextCreatePin.requestFocus()
            val imgr =
                context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imgr.hideSoftInputFromWindow(editTextCreatePin.windowToken, 0)
        })
        editTextCreatePin.setOnPinEnteredListener(PinEntryEditText.OnPinEnteredListener { str ->


            if (str.toString().length == 4) {

                requireActivity().finish()
                startActivity(Intent(requireContext(), RegistrationUserOptionActivity::class.java))

            } else {
                editTextCreatePin.setAnimateText(true)
            }
        })

        view.imageViewUAS21.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                UserAuthenticateWithPhnFragment(),
                activity?.supportFragmentManager,
                R.id.user_auth_host_container
            )
        })

        return view
    }

    override fun onResume() {
        editTextCreatePin.text!!.clear()

        super.onResume()
    }

    override fun onPause() {
        editTextCreatePin.text!!.clear()
        super.onPause()
    }

    override fun onFingerClick() {

        checkFingerprint()



    }



    private fun checkFingerprint() {

        val fingerprintManagerCompat = FingerprintManagerCompat.from(requireContext())

        if (!fingerprintManagerCompat.isHardwareDetected) {
            // Device doesn't support fingerprint authentication
            Toast.makeText(requireContext(), "Device doesn't support fingerprint authentication!", Toast.LENGTH_SHORT).show()

        } else if (!fingerprintManagerCompat.hasEnrolledFingerprints()) {
            // User hasn't enrolled any fingerprints to authenticate with

            Toast.makeText(requireContext(), "User hasn't enrolled any fingerprints to authenticate with!", Toast.LENGTH_SHORT).show()

        } else {
            FragmentHelper.replaceFragment(
                UserLoginWithFingerPrintFragment(),
                requireActivity().supportFragmentManager,
                R.id.user_auth_host_container
            )
        }

    }




}