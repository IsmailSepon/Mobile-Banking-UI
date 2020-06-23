package com.cloudwell.paywell.ui.cards.fragment.physicalCard

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.CustomKeyboardWithBack
import com.cloudwell.paywell.base.PinEntryEditText
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.card_create_pin_layout.view.*

class CardCreatePinFragment : Fragment() {

    //var etMobileOrRID: PinEntryEditText = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.card_create_pin_layout, container, false)


        val keyboard: CustomKeyboardWithBack = view.card_create_pin_keyboard

        var etMobileOrRID: PinEntryEditText = view.create_pin

        val ic: InputConnection = etMobileOrRID.onCreateInputConnection(EditorInfo())
        keyboard.setInputConnection(ic)
        etMobileOrRID.post(Runnable {
            etMobileOrRID.requestFocus()
            val imgr =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imgr.hideSoftInputFromWindow(etMobileOrRID.windowToken, 0)
        })

        etMobileOrRID.requestFocus()
        etMobileOrRID.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (etMobileOrRID.text!!.length == 4) {
                    etMobileOrRID.text!!.clear()
                    FragmentHelper.replaceFragment(
                        SpecifyDeliveryAddressFragment(),
                        activity?.supportFragmentManager,
                        R.id.Cards_container
                    )
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })


        view.card_create_pin_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })

        return view
    }
}

