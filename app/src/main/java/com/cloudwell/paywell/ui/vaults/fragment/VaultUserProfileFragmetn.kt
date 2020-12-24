package com.cloudwell.paywell.ui.vaults.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.vault_userprofile_layout.view.*

class VaultUserProfileFragmetn : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.vault_userprofile_layout, container, false)



        view.edit_vault.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(VaultRecurringEditFragmetn(), requireActivity().supportFragmentManager, R.id.vault_intro_container)
        })


        view.uservault_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })




        return view
    }
}