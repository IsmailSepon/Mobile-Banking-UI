package com.cloudwell.paywell.ui.authentication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.user_auth_with_ques_fragment.view.*

class UserAuthenticateWithQAFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.user_auth_with_ques_fragment, container, false)

        view.buttonUAQ1.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                UserAuthenticateWithDateFragment(),
                activity?.supportFragmentManager,
                R.id.user_auth_host_container
            )
        })

        return view
    }
}