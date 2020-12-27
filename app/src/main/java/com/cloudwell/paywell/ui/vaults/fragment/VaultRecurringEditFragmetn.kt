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
import com.cloudwell.paywell.ui.vaults.dialog.VaultRepeatDialog
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.vault_recurringedit_layout.view.*
import kotlinx.android.synthetic.main.vault_userprofile_layout.view.*

class VaultRecurringEditFragmetn : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.vault_recurringedit_layout, container, false)






        view.recurring_confirm.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        view.repeat_layout.setOnClickListener(View.OnClickListener {

            val dialog: VaultRepeatDialog = VaultRepeatDialog()
            dialog.show(activity?.supportFragmentManager!!, "trxProfileDialog")


        })



        val country = arrayOf("৳30,000", "৳40,000", "৳50,000")
        val sp : Spinner = view.amount_sp
        sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = aa
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }

        return view
    }
}