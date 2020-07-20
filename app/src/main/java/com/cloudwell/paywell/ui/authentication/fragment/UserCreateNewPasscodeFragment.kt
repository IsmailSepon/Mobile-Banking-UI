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
import androidx.fragment.app.Fragment
import com.alimuzaffar.lib.pin.PinEntryEditText
import com.alimuzaffar.lib.pin.PinEntryEditText.OnPinEnteredListener
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.CustomKeyboard
import com.cloudwell.paywell.utils.FragmentHelper

class UserCreateNewPasscodeFragment : Fragment() {

    lateinit var keyboard: CustomKeyboard
    lateinit var editTextCreatePin: PinEntryEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.user_auth_new_passcode_fragment, container, false)

        keyboard = view.findViewById(R.id.customKeyboardUANP)
        editTextCreatePin = view.findViewById(R.id.editTextUANP)

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
            editTextCreatePin.setOnPinEnteredListener(OnPinEnteredListener { str ->
                if (str.length == 4) {
                    FragmentHelper.replaceFragment(
                        PasscodeChangeSuccessFragment(),
                        activity?.supportFragmentManager,
                        R.id.user_auth_host_container
                    )
                }
            })
        }


//        view.textViewUANP1.setOnClickListener(View.OnClickListener {
//            FragmentHelper.replaceFragment(
//                UserLostPhnFirstFragment(),
//                activity?.supportFragmentManager,
//                R.id.user_auth_host_container
//            )
//        })

        return view
    }
}