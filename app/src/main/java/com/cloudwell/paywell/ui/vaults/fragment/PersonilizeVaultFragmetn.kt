package com.cloudwell.paywell.ui.vaults.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.dialog.ElectronicsConfirmDialog
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.personalize_vault_layout.view.*
import kotlinx.android.synthetic.main.vault_spare_layout.view.*

class PersonilizeVaultFragmetn : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.personalize_vault_layout, container, false)







        view.one_off_saving_lay.setOnClickListener(View.OnClickListener {


            val bundle  = Bundle()
            bundle.putString("VaultSetAmountFragmetn", "PersonilizeVaultFragmetn")

            val frg: VaultSetAmountFragmetn = VaultSetAmountFragmetn()
            frg.arguments = bundle
            FragmentHelper.replaceFragment(frg, requireActivity().supportFragmentManager, R.id.vault_intro_container)

        })

        view.imageView307.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })


        return view
    }
}