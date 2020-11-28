package com.cloudwell.paywell.uiBusiness.control.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.bu_virtual_ac_details_layout.view.*


class BuVirtualAccFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.bu_virtual_ac_details_layout, container, false)



        root.transfer_back_btn.setOnClickListener(View.OnClickListener {

            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })
        return root

    }



}