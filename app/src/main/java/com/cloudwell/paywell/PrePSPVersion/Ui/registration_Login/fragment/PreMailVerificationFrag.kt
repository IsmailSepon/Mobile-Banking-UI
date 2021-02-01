package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.registration.fragment.RegOneFeg
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.activity_email_verification.view.*
import kotlinx.android.synthetic.main.chnage_currency_fragment.view.*

class PreMailVerificationFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.activity_email_verification, container, false)



        view.email_verification_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.addFirstFragment(AccountVerifiedFrag(), requireActivity().supportFragmentManager, R.id.pre_psp_auth_container)
        })




        return view
    }
}