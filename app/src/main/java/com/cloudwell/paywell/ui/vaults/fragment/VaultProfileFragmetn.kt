package com.cloudwell.paywell.ui.vaults.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.vault_profile_layout.view.*

class VaultProfileFragmetn : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.vault_profile_layout, container, false)








        view.recurring_saving_layout.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(VaultUserProfileFragmetn(), requireActivity().supportFragmentManager, R.id.vault_intro_container)
        })



        view.vault_info.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(VaultInfoFragmetn(), requireActivity().supportFragmentManager, R.id.vault_intro_container)
        })




        return view
    }
}