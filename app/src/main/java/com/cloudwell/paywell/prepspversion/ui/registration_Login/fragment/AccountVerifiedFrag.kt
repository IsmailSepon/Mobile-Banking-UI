package com.cloudwell.paywell.prepspversion.ui.registration_Login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R

class AccountVerifiedFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.activity_account_creattion, container, false)



//        view.email_verification_btn.setOnClickListener(View.OnClickListener {
//            FragmentHelper.addFirstFragment(PreCreatePasswordFrag(), requireActivity().supportFragmentManager, R.id.pre_psp_auth_container)
//        })




        return view
    }
}