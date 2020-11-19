package com.cloudwell.paywell.uiBusiness.control.fragment.info_edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.primary_email_number_layout.view.*


class PrimaryEmailNumberFrg : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.primary_email_number_layout, container, false)


        root.business_email_btn.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                BuEmailVerifiedFrg(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })



        return root

    }


}