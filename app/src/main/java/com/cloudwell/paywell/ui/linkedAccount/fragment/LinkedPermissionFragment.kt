package com.cloudwell.paywell.ui.linkedAccount.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.linkedac_permission_layout.view.*


class LinkedPermissionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.linkedac_permission_layout, container, false)




        view.linkedpermision_done_brn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(LinkedBankDoneFragment(), requireActivity().supportFragmentManager, R.id.linked_account_container)
        })



        return view
    }


    //OnBack press finish activity cz its first fragment in this activity

}