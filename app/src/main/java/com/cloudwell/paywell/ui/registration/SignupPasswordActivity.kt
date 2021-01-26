package com.cloudwell.paywell.ui.registration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.alimuzaffar.lib.pin.PinEntryEditText
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.CustomKeyboardWithForget
import kotlinx.android.synthetic.main.activity_signup_password.*


/**
 * Created by Sepon on 4/1/2020.
 * ==============================Don't extend "BaseActivity" =================
 */

class SignupPasswordActivity : AppCompatActivity() {

    lateinit var keyboard: CustomKeyboardWithForget
    lateinit var editTextCreatePin: PinEntryEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_password)


        keyboard = signup_password_keybord
        editTextCreatePin = signup_password_et


        editTextCreatePin.setRawInputType(InputType.TYPE_CLASS_TEXT)
        editTextCreatePin.setTextIsSelectable(true)
        val ic: InputConnection = editTextCreatePin.onCreateInputConnection(EditorInfo())
        keyboard.setInputConnection(ic)


        editTextCreatePin.post(Runnable {
            editTextCreatePin.requestFocus()
            val imgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imgr.hideSoftInputFromWindow(editTextCreatePin.windowToken, 0)
        })
        if (editTextCreatePin != null) {

            editTextCreatePin.setOnPinEnteredListener(PinEntryEditText.OnPinEnteredListener { str ->

                if (str.toString().length == 4) {

                    finish()
                    startActivity(Intent(applicationContext, RegistrationUserOptionActivity::class.java))

                } else {
                    editTextCreatePin.setAnimateText(true)
                }
            })
        }








        buttonBackUAS.setOnClickListener(View.OnClickListener {
            finish()
        })





    }
}