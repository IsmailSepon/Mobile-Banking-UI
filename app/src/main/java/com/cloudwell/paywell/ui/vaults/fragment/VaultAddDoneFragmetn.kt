package com.cloudwell.paywell.ui.vaults.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.vault_add_done_layout.view.*

class VaultAddDoneFragmetn : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.vault_add_done_layout, container, false)






        view.vault_adddone_btn.setOnClickListener(View.OnClickListener {

           requireActivity().finish()
        //    FragmentHelper.replaceFragment(VaultSpareFragmetn(), requireActivity().supportFragmentManager, R.id.vault_intro_container)

        })



        return view
    }
}