package com.cloudwell.paywell.ui.profile.fragment

import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.alimuzaffar.lib.pin.PinEntryEditText
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.CustomKeyboardWithFingerprint
import com.cloudwell.paywell.base.CustomKeyboardWithForget
import com.cloudwell.paywell.ui.authentication.fragment.UserAuthenticateWithFingerPrintFragment
import com.cloudwell.paywell.ui.authentication.fragment.UserLostPhnFirstFragment
import com.cloudwell.paywell.utils.FragmentHelper

class ChangePasscodeFragment : Fragment() {

    lateinit var keyboard: CustomKeyboardWithForget
    lateinit var editTextCreatePin: PinEntryEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.change_profile_passcode_fragment, container, false)

        keyboard = view.findViewById(R.id.customKeyboardCPP)
        editTextCreatePin = view.findViewById(R.id.editTextCPP1)

        editTextCreatePin.setRawInputType(InputType.TYPE_CLASS_TEXT)
        editTextCreatePin.setTextIsSelectable(true)
        val ic: InputConnection = editTextCreatePin.onCreateInputConnection(EditorInfo())
        keyboard.setInputConnection(ic)

        editTextCreatePin.post(Runnable {
            editTextCreatePin.requestFocus()
            val imgr =
                context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imgr.hideSoftInputFromWindow(editTextCreatePin.getWindowToken(), 0)
        })
        if (editTextCreatePin != null) {
            editTextCreatePin.setAnimateText(true)
            editTextCreatePin.setOnPinEnteredListener(PinEntryEditText.OnPinEnteredListener { str ->

            })
        }

        return view
    }
}