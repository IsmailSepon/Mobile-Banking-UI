package com.cloudwell.paywell.uiBusiness.control.fragment.info_edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.new_phone_number_layout.view.*


class NewphoneNumberFrg : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.new_phone_number_layout, container, false)


        root.new_phone_number_done.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                PrimaryEmailNumberFrg(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })


        root.imageView199.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return root

    }


}