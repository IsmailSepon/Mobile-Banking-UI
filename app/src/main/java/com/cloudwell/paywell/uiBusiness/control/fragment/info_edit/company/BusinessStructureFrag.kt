package com.cloudwell.paywell.uiBusiness.control.fragment.info_edit.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_structure_layout.view.*


class BusinessStructureFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.business_structure_layout, container, false)


        root.reg_type_layout.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                BusinessStructureEditFrag(),
                requireActivity().supportFragmentManager,
                R.id.bu_Control_container
            )

        })



        view?.bu_structure_back_btn?.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return root

    }


}