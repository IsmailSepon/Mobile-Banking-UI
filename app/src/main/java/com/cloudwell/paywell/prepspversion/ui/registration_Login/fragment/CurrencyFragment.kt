package com.cloudwell.paywell.prepspversion.ui.registration_Login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.currency_fragment.view.*

class CurrencyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.currency_fragment, container, false)



        view.change_currency_btn.setOnClickListener(View.OnClickListener {


            FragmentHelper.addFirstFragment(ChangeCurrencyFragment(), requireActivity().supportFragmentManager, R.id.pre_psp_auth_container)
        })

        view.pre_continue_btn.setOnClickListener(View.OnClickListener {


            

        })


        return view
    }
}