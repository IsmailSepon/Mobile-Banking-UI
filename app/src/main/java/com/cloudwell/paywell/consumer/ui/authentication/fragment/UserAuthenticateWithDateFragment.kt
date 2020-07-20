package com.cloudwell.paywell.consumer.ui.authentication.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.user_auth_with_date_fragment.view.*
import kotlinx.android.synthetic.main.user_auth_with_phn_fragment.view.*
import kotlinx.android.synthetic.main.user_auth_with_ques_fragment.view.*

class UserAuthenticateWithDateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.user_auth_with_date_fragment, container, false)

        view.editTextUAD1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                view.buttonContinueUAD.setBackgroundResource(R.drawable.round_btn_visable)

            }
        })

        view.buttonContinueUAD.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                UserAuthenticateWithTrxFragment(),
                activity?.supportFragmentManager,
                R.id.user_auth_host_container
            )
        })

        return view
    }
}