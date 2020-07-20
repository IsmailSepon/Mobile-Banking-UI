package com.cloudwell.paywell.ui.authentication.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.CustomKeyboardWithFingerprint
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.user_auth_with_phn_fragment.view.*

class UserAuthenticateWithPhnFragment : Fragment() {

    var country = arrayOf("+880", "+9715", "+966", "+699", "+778")

    var keyboard: CustomKeyboardWithFingerprint? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.user_auth_with_phn_fragment, container, false)

        keyboard = view.findViewById(R.id.customKeyboardUAS)

        view.spinnerUAP1.onItemSelectedListener
        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.spinnerUAP1.adapter = aa

        view.editTextUAP1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (view.editTextUAP1.text.length == 10){
                    view.buttonContinueUAP1.setBackgroundResource(R.drawable.round_btn_visable)
                }
            }
        })

        view.buttonContinueUAP1.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                UserAuthenticateWithQAFragment(),
                activity?.supportFragmentManager,
                R.id.user_auth_host_container
            )
        })
        return view
    }
}