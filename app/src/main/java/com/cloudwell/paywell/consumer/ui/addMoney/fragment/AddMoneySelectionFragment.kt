package com.cloudwell.paywell.consumer.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.add_money_selection_layout.view.*

class AddMoneySelectionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_money_selection_layout, container, false)

        view.bankList.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                AddMoneyBankLisFragment(),
                activity?.supportFragmentManager,
                R.id.add_money_container
            )

        })

        view.constraintLayout7.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                AddMoneyBankProfileFragment(),
                activity?.supportFragmentManager,
                R.id.add_money_container
            )

        })

        view.addmoneypaywell.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                TransferPaywellAccount(),
                activity?.supportFragmentManager,
                R.id.add_money_container
            )

        })

        view.textView69.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                AddCardDetailsFragment(),
                activity?.supportFragmentManager,
                R.id.add_money_container
            )

        })

        return view
    }


}
