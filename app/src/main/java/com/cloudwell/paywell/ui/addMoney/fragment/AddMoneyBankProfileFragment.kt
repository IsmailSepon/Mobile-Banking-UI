package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneyViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.add_money_bankprofile_layout.view.*

class AddMoneyBankProfileFragment : Fragment() {

    private lateinit var addMoneyViewmodel: AddMoneyViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_money_bankprofile_layout, container, false)




        view.bank_profile_edit.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                AddMoneyAutoTopupFragment(),
                activity?.supportFragmentManager,
                R.id.add_money_container
            )

        })

        view.bank_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })

        return view
    }


}
