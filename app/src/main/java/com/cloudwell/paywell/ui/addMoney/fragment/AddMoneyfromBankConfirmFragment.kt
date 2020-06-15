package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.add_money_bankconfirm_layout.view.*

class AddMoneyfromBankConfirmFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_money_bankconfirm_layout, container, false)


        view.bank_confirm.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })

        return view
    }


}
