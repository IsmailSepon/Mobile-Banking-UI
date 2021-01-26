package com.cloudwell.paywell.ui.linkedAccount.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.linkedac_bank_done_layout.view.*

class LinkedBankDoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.linkedac_bank_done_layout, container, false)


        view.bankdone.setOnClickListener(View.OnClickListener {

            requireActivity().finish()
        })

        return view
    }
}