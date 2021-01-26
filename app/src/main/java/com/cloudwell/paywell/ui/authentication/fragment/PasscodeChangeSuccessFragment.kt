package com.cloudwell.paywell.ui.authentication.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.registration.SignupActivity
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.passcode_change_success_fragment.view.*
import kotlinx.android.synthetic.main.user_auth_retry_fragment.view.*
import kotlinx.android.synthetic.main.user_auth_retry_fragment.view.textViewUAR2

class PasscodeChangeSuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.passcode_change_success_fragment, container, false)

        view.email_verify_done_btn.setOnClickListener(View.OnClickListener {

            requireActivity().startActivity(Intent(requireContext(), SignupActivity :: class.java))
            requireActivity().finish()

        })

        return view
    }
}