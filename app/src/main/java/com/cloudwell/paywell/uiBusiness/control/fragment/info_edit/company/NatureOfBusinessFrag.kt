package com.cloudwell.paywell.uiBusiness.control.fragment.info_edit.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.nature_of_business_layout.view.*


class NatureOfBusinessFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.nature_of_business_layout, container, false)


        root.nature_of_bu_et.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                NatureOfBusinessEditFrag(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })


        return root

    }


}