package com.cloudwell.paywell.consumer.ui.authentication.fragment

import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.alimuzaffar.lib.pin.PinEntryEditText
import com.alimuzaffar.lib.pin.PinEntryEditText.OnPinEnteredListener
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.activity.registation.RegistationMainActivity
import com.cloudwell.paywell.consumer.base.CustomKeyboard
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.user_auth_new_passcode_fragment.view.*

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