package com.cloudwell.paywell.consumer.ui.authentication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.user_auth_with_fingerprint_fragment.view.*

class UserAuthenticateWithFingerPrintFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.user_auth_with_fingerprint_fragment, container, false)

        view.textViewUAF1.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                UserAuthenticateWithFingerPrintETryFragment(),
                activity?.supportFragmentManager,
                R.id.user_auth_host_container
            )
        })

        view.textViewUAF2.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                UserAuthenticateWithPasscodeFragment(),
                activity?.supportFragmentManager,
                R.id.user_auth_host_container
            )
        })

        return view
    }
}