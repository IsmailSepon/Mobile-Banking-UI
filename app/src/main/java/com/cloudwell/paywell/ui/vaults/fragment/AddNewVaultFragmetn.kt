package com.cloudwell.paywell.ui.vaults.fragment

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.add_new_vault_layout.view.*

class AddNewVaultFragmetn : Fragment() {

    var et_counter : TextView? = null
    var et_vault : EditText? = null
    var et_button : Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.add_new_vault_layout, container, false)

        et_counter = view.vault_text_counter
        et_vault =    view.vault_et
        et_button = view.newvault_btn


        et_vault?.addTextChangedListener(object : TextWatcher {
             @RequiresApi(Build.VERSION_CODES.O)
             override fun afterTextChanged(s: Editable?) {

                 val length : Int = 40- s!!.length
                 et_counter?.text = length.toString()
                 if(length==0){
                     et_vault?.isEnabled = false
                     et_button?.setBackgroundResource(R.drawable.round_btn_visable)
                 }else if (length < 0){
                     et_vault?.isEnabled = false
                     et_button?.setBackgroundResource(R.drawable.round_btn_visable)
                 }else{

                     et_button?.setBackgroundResource(R.drawable.round_btn_visable)
                 }

             }

             override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
             }

             override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


             }
         })


        et_button?.setOnClickListener(View.OnClickListener {

            val bundle  = Bundle()
            bundle.putString("VaultSetAmountFragmetn", "AddNewVaultFragmetn")

            val frg: VaultSetAmountFragmetn = VaultSetAmountFragmetn()
            frg.arguments = bundle
            FragmentHelper.replaceFragment(frg, requireActivity().supportFragmentManager, R.id.vault_intro_container)

        })





        return view
    }
}