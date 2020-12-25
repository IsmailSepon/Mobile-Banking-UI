package com.cloudwell.paywell.ui.vaults.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.vault_recurringedit_layout.view.*
import kotlinx.android.synthetic.main.vault_userprofile_layout.view.*

class VaultInfoFragmetn : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.vault_info_layout, container, false)






//        view.recurring_confirm.setOnClickListener(View.OnClickListener {
//            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
//        })





        return view
    }
}