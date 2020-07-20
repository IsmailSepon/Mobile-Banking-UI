package com.cloudwell.paywell.consumer.ui.switchAccount.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.profile.fragment.EditPersonalDetailsFirstFragment
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.user_auth_for_switch_pw_account_one.view.*

class ManageSwitchAccountSecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.user_auth_for_switch_pw_account_two, container, false)

        return view
    }
}