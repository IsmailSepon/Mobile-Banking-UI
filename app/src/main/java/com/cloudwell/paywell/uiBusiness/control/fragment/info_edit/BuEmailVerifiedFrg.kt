package com.cloudwell.paywell.uiBusiness.control.fragment.info_edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.email_verificatoin_layout.view.*


class BuEmailVerifiedFrg : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.email_verificatoin_layout, container, false)


        root.bu_email_verified_btn.setOnClickListener(View.OnClickListener {

            activity?.finish()

//            FragmentHelper.replaceFragment(
//                NewphoneNumberFrg(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Control_container
//            )

        })



        return root

    }


}