package com.cloudwell.paywell.ui.withdrawCash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.cash_withdraw_process_layout.view.*

class CashWithDrawProcessFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.cash_withdraw_process_layout, container, false)


        view.cashwithdraw_process_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                ATMcashWithdrawFragment(),
                activity?.supportFragmentManager,
                R.id.cash_withdraw_container
            )
        })

        return view
    }


}
