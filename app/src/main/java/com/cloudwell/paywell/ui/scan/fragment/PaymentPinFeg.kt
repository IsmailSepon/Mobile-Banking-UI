package com.cloudwell.paywell.ui.scan.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.registration.fragment.RegOneFeg
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.paywell_pin_layout.view.*

/**
 * Created by Sepon on 4/15/2020.
 */
class PaymentPinFeg : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.paywell_pin_layout, container, false)




        view.pin_confirm.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(PaymentDoneFeg(), requireActivity().supportFragmentManager, R.id.scan_host_container)
        })


        view.scan_back.setOnClickListener(View.OnClickListener {

            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)

        })

        return view
    }

    companion object {
        fun newInstance(): RegOneFeg {
            return RegOneFeg()
        }
    }
}