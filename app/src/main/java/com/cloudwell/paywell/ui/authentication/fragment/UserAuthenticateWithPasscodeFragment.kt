package com.cloudwell.paywell.ui.authentication.fragment

import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alimuzaffar.lib.pin.PinEntryEditText
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.CustomKeyboardWithFingerprint
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.user_auth_for_switch_pw_account_two.view.*

class UserAuthenticateWithPasscodeFragment : Fragment() {

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

        editTextCreatePin.post(Runnable {
            editTextCreatePin.requestFocus()
            val imgr =
                context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imgr.hideSoftInputFromWindow(editTextCreatePin.getWindowToken(), 0)
        })
        if (editTextCreatePin != null) {

            editTextCreatePin.setOnPinEnteredListener(PinEntryEditText.OnPinEnteredListener { str ->

                if (str.toString() == "0000") {
                    FragmentHelper.replaceFragment(
                        UserLostPhnFirstFragment(),
                        activity?.supportFragmentManager,
                        R.id.user_auth_host_container
                    )
                } else if (str.toString() == "1111") {
                    FragmentHelper.replaceFragment(
                        UserAuthenticateWithFingerPrintFragment(),
                        activity?.supportFragmentManager,
                        R.id.user_auth_host_container
                    )
                } else {
                    editTextCreatePin.setAnimateText(true)
                }
            })
        }

        view.imageViewUAS21.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                UserAuthenticateWithPhnFragment(),
                activity?.supportFragmentManager,
                R.id.user_auth_host_container
            )
        })

        return view
    }
}